package com.runpowerback.runpowerback.application;

import com.runpowerback.runpowerback.RunpowerbackApplication;
import com.runpowerback.runpowerback.domaine.Activity;
import com.runpowerback.runpowerback.domaine.PowerActivity;
import com.runpowerback.runpowerback.domaine.PowerActivityRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.ZonedDateTime;
import java.util.List;

@Service
@Transactional
public class FromActivityToPowerActivityService {

    private static final Logger logger = LogManager.getLogger(RunpowerbackApplication.class);

    @Autowired
    PowerActivityRepository powerActivityRepository;

    void toTransform(List<Activity> run) {

        float distanceFromStart = 0;
        float timeFromStart = 0;
        float powerPrevious;
        float powerCurrent = 0;

        int i = 1;
        logger.info("taille : " + run.size());

        while(i <= run.size()-1) {

            float deltaDistancePowerActivity =
                    getDistanceFromLatLontoMeter(
                            run.get(i-1).getLatitude(),
                            run.get(i-1).getLongitude(),
                            run.get(i).getLatitude(),
                            run.get(i).getLongitude());
            logger.info("deltaDistance : " + deltaDistancePowerActivity);

            float hearthratePowerActivity = run.get(i).getHearthrate();
            logger.info("heathrate : " + hearthratePowerActivity);

            float deltaTimezonePowerActivity =
                    getDeltaTimeFromTimezoneString(run.get(i-1).getTimezone(), run.get(i).getTimezone());
            logger.info("timezone : " + deltaTimezonePowerActivity);

            float speedPowerActivity = getSpeedFromDistanceAndTime(deltaDistancePowerActivity, deltaTimezonePowerActivity);
            logger.info("speed : " + speedPowerActivity);

            float pacePowerActivity = getPaceFromSpeed(speedPowerActivity);
            logger.info("pace : " + pacePowerActivity);

            float rateElevation = (run.get(i).getElevation() - run.get(i-1).getElevation()) / run.get(i).getElevation();
            logger.info("rate Elevation : " + rateElevation);

            float mass = 70.0f;
            float Ar = 0.24f;
            float massVolumic = 1.2f;
            float speedWind = 0f;
            float gravity = 9.81f;

            powerPrevious = powerCurrent;
            float power = getPower(mass, deltaDistancePowerActivity, deltaTimezonePowerActivity, Ar, massVolumic, speedWind, rateElevation, gravity);
            logger.info("power : " + power);
            powerCurrent = power;

            distanceFromStart = distanceFromStart +
                    getDistanceFromLatLontoMeter(run.get(i-1).getLatitude(),
                            run.get(i-1).getLongitude(),
                            run.get(i).getLatitude(),
                            run.get(i).getLongitude());

            timeFromStart = timeFromStart +
                    getDeltaTimeFromTimezoneString(run.get(i-1).getTimezone(), run.get(i).getTimezone());

            if ((power > 0) && (powerCurrent < (1.5f * powerPrevious))) {
                PowerActivity powerActivity = new PowerActivity(null, 1L,1L,power, speedPowerActivity, hearthratePowerActivity, distanceFromStart, pacePowerActivity, timeFromStart);
                logger.info("Object power : " + powerActivity);

                this.powerActivityRepository.save(powerActivity);
            }
            i=i+1;

        }
    }

    static float getDistanceFromLatLontoMeter(float lat1, float lon1, float lat2, float lon2) {
        float earthRadius = 6371;
        float dLat = degToRad(lat2-lat1);
        float dLon = degToRad(lon2-lon1);
        float intResA = (float) (Math.sin(dLat/2) * Math.sin(dLat/2) +
                Math.cos(degToRad(lat1)) * Math.cos(degToRad(lat2)) * Math.sin(dLon/2) * Math.sin(dLon/2));
        float intResB = (float) (2 * Math.atan2(Math.sqrt(intResA), Math.sqrt(1-intResA)));
        float dDist = 1000 * (earthRadius * intResB);
        return dDist;
    }

    static float degToRad(float deg) {
        return (float) (deg * (Math.PI / 180));
    }


    static float getDeltaTimeFromTimezoneString(String timezone1, String timezone2){
        float timezoneStartPoint = 3600 * (ZonedDateTime.parse(timezone1).getHour()) + 60 * (ZonedDateTime.parse(timezone1).getMinute()) +
                ZonedDateTime.parse(timezone1).getSecond();
        float timezoneEndPoint = 3600 * (ZonedDateTime.parse(timezone2).getHour()) + 60 * (ZonedDateTime.parse(timezone2).getMinute()) +
                ZonedDateTime.parse(timezone2).getSecond();
        return  (timezoneEndPoint- timezoneStartPoint);
    }

    static float getSpeedFromDistanceAndTime(float distance, float time) {
        return distance / time;
    }

    static float getPaceFromSpeed(float speed) {
        return (60f / (speed * 3.6f));
    }

    static float getPower(float mass, float deltaDistance, float deltaTime, float Ar, float massVolumic, float speedWind, float rateElevation, float gravity) {
        return mass * (deltaDistance / deltaTime) +
               0.5f * Ar * massVolumic * (deltaDistance / deltaTime + speedWind) * (deltaDistance / deltaTime + speedWind)
                          * deltaDistance/deltaTime +
               mass * gravity * rateElevation * (deltaDistance / deltaTime);
    }



}