package com.runpowerback.runpowerback.application.service;

import com.runpowerback.runpowerback.domaine.entity.ActivityPointOf;
import com.runpowerback.runpowerback.domaine.entity.PowerActivityPointOf;
import com.runpowerback.runpowerback.domaine.repository.ExternalConditionRepository;
import com.runpowerback.runpowerback.domaine.repository.PowerActivityRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
@Transactional
public class FromActivityToPowerActivityService {

    private static final Logger logger = LogManager.getLogger();

    @Autowired
    PowerActivityRepository powerActivityRepository;

    @Autowired
    ExternalConditionRepository externalConditionRepository;

    List<PowerActivityPointOf> powerActivityPointOfList = new ArrayList<>();

    public List<PowerActivityPointOf> toTransform(Long idathlete, Long idpoweractivity, List<ActivityPointOf> run, float mass) throws ExecutionException, InterruptedException {

        float distanceFromStart = 0;
        float timeFromStart = 0;
        float powerPrevious;
        float powerCurrent = 0;
        float Ar = 0.24f;
        float gravity = 9.81f;

        float speedWind;
        float temperature;
        float pressureATM;
        float pressureSaturation;
        float percentHumidity;

        speedWind = this.externalConditionRepository.findOneExternalCondition(idathlete, idpoweractivity).getSpeedwind();
        temperature = this.externalConditionRepository.findOneExternalCondition(idathlete, idpoweractivity).getTemperature();
        pressureATM = this.externalConditionRepository.findOneExternalCondition(idathlete, idpoweractivity).getPressureatm();
        pressureSaturation = toBuckEquation(temperature);
        percentHumidity = this.externalConditionRepository.findOneExternalCondition(idathlete, idpoweractivity).getHumidity();
        float massVolumic;
        massVolumic = toTransformMassVolumic(percentHumidity,pressureSaturation,pressureATM,temperature);

        int i = 1;
        logger.info("taille : " + run.size());

        String DateOfPowerActivity =  ZonedDateTime.parse(run.get(i).getTimezone()).getDayOfMonth() + " "+
                ZonedDateTime.parse(run.get(i).getTimezone()).getMonth() +  " " +
                ZonedDateTime.parse(run.get(i).getTimezone()).getYear();

        String TimeOfPowerActivity = ZonedDateTime.parse(run.get(i).getTimezone()).getHour() + ":"+
                ZonedDateTime.parse(run.get(i).getTimezone()).getMinute();

        while(i <= run.size()-1) {

            logger.info("idathlete " + idathlete);
            logger.info("idpoweractivity" + idpoweractivity);

            logger.info("speedWind " + speedWind);
            logger.info("temperature " + temperature);
            logger.info("pressureATM " + pressureATM);
            logger.info("pressureSaturation" + pressureSaturation);
            logger.info("percentHumidity " + percentHumidity );
            logger.info("massVolumic " + massVolumic);

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
            logger.info("date " + DateOfPowerActivity);
            logger.info("time " + TimeOfPowerActivity);

            float speedPowerActivity = getSpeedFromDistanceAndTime(deltaDistancePowerActivity, deltaTimezonePowerActivity);
            logger.info("speed : " + speedPowerActivity);

            float pacePowerActivity = getPaceFromSpeed(speedPowerActivity);
            logger.info("pace : " + pacePowerActivity);

            float rateElevation = (run.get(i).getElevation() - run.get(i-1).getElevation()) / run.get(i).getElevation();
            logger.info("rate Elevation : " + rateElevation);

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

            if (((power > 0) && (powerCurrent < (1.5f * powerPrevious))) && (hearthratePowerActivity > 0) && (pacePowerActivity < 20.0f))
            {
                PowerActivityPointOf powerActivity = new PowerActivityPointOf(null,
                                                                idathlete,
                                                                idpoweractivity,
                                                                power,
                                                                speedPowerActivity,
                                                                hearthratePowerActivity,
                                                                distanceFromStart,
                                                                pacePowerActivity,
                                                                timeFromStart,
                                                                DateOfPowerActivity,
                                                                TimeOfPowerActivity);
                logger.info("Object power : " + powerActivity);

                this.powerActivityRepository.save(powerActivity);
                powerActivityPointOfList.add(powerActivity);

            }

            i=i+1;

        }

        return powerActivityPointOfList;
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

    public float toTransformMassVolumic (float percentHumidity, float pressureSaturation, float pressureATM, float temperature) {
        float temperatureKelvin = temperature + 273.15f;
        float Rs = 287.058f;
        float Humidity = percentHumidity / 100;

        return (1.0f - (0.3783f * Humidity * pressureSaturation) / pressureATM) * pressureATM / (Rs * temperatureKelvin);
    }

    public float toBuckEquation (float temperature) {
        double forBuckEquation = (18.878f - (temperature / 234.5f)) * (temperature / (257.14f + temperature));
        return (float)(611.21f * Math.exp(forBuckEquation));
    }

}
