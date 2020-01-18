package com.runpowerback.runpowerback.application;

import com.runpowerback.runpowerback.domaine.Activity;
import com.runpowerback.runpowerback.domaine.PowerActivity;
import com.runpowerback.runpowerback.domaine.PowerActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.ZonedDateTime;
import java.util.List;

@Service
@Transactional
public class TransformService {

    @Autowired
    PowerActivityRepository powerActivityRepository;

    void toTransform(List<Activity> run, int i) {

        float deltaDistancePowerActivity =
                getDistanceFromLatLontoMeter(run.get(1).getLatitude(),
                        run.get(1).getLongitude(),
                        run.get(2).getLatitude(),
                        run.get(2).getLongitude()) -
                getDistanceFromLatLontoMeter(run.get(0).getLatitude(),
                        run.get(0).getLongitude(),
                        run.get(1).getLatitude(),
                        run.get(1).getLongitude())
                ;
        System.out.println("deltaDistance : " + deltaDistancePowerActivity);

        float hearthratePowerActivity=run.get(2).getHearthrate();
        System.out.println("heathrate : " + hearthratePowerActivity);

        float deltaTimezonePowerActivity =
                getDeltaTimeFromTimezoneString(run.get(0).getTimezone(),run.get(1).getTimezone()) -
                getDeltaTimeFromTimezoneString(run.get(1).getTimezone(),run.get(2).getTimezone());
        System.out.println("timezone : " + deltaTimezonePowerActivity);

        float speedPowerActivity = getSpeedFromDistanceAndTime(deltaDistancePowerActivity,deltaTimezonePowerActivity);
        System.out.println("speed : " + speedPowerActivity);

        float rateElevation = run.get(2).getElevation() / run.get(0).getElevation();
        System.out.println("rate Elevation : " + rateElevation);

        float mass = 70.0f;
        float Ar = 0.24f;
        float massVolumic = 1.2f;
        float speedWind = 0f;
        float gravity = 9.81f;
        float power = getPower(mass, deltaDistancePowerActivity, deltaTimezonePowerActivity,Ar, massVolumic, speedWind, gravity, rateElevation);
        System.out.println("power :" + power);

        float distanceFromStart =
                getDistanceFromLatLontoMeter(run.get(1).getLatitude(),
                       run.get(1).getLongitude(),
                       run.get(2).getLatitude(),
                       run.get(2).getLongitude()) -
                getDistanceFromLatLontoMeter(run.get(0).getLatitude(),
                        run.get(0).getLongitude(),
                        run.get(1).getLatitude(),
                        run.get(1).getLongitude())
                 ;

        float timeFromStart =
                getDeltaTimeFromTimezoneString(run.get(0).getTimezone(),run.get(1).getTimezone()) -
                getDeltaTimeFromTimezoneString(run.get(1).getTimezone(),run.get(2).getTimezone());

        PowerActivity powerActivity = new PowerActivity(null,power,speedPowerActivity,hearthratePowerActivity,distanceFromStart,timeFromStart);
        System.out.println("Object power : " + powerActivity );

        this.powerActivityRepository.save(powerActivity);


    }

    static float getDistanceFromLatLontoMeter(float lat1, float lon1, float lat2, float lon2) {
        float earthRadius = 6371;
        float dLat = degToRad(lat2-lat1);
        float dLon = degToRad(lon2-lon1);
        float intResA = (float) (Math.sin(dLat/2) * Math.sin(dLat/2) +
                Math.cos(degToRad(lat1)) * Math.cos(degToRad(lat2)) * Math.sin(dLon/2) * Math.sin(dLon/2));
        float intResB = (float) (2 * Math.atan2(Math.sqrt(intResA), Math.sqrt(1-intResA)));
        float dDist = 1000*(earthRadius * intResB);
        return dDist;
    }

    static float degToRad(float deg) {
        return (float) (deg * (Math.PI/180));
    }


    static float getDeltaTimeFromTimezoneString(String timezone1, String timezone2){
        return  3600*(ZonedDateTime.parse(timezone2).getHour()-ZonedDateTime.parse(timezone1).getHour()) +
                60*(ZonedDateTime.parse(timezone2).getMinute()-ZonedDateTime.parse(timezone1).getMinute()) +
                (ZonedDateTime.parse(timezone2).getSecond()-ZonedDateTime.parse(timezone1).getSecond());
    }

    static float getSpeedFromDistanceAndTime(float distance, float time) {
        return distance / time;
    }

    static float getPower(float mass, float deltaDistance, float deltaTime, float Ar, float massVolumic, float speedWind,float gravity , float rateElevation) {
        return mass * (deltaDistance / deltaTime) +
                0.5f * Ar * massVolumic * (deltaDistance / deltaTime + speedWind) * (deltaDistance / deltaTime + speedWind)
                          * deltaDistance +
                mass * gravity * rateElevation * (deltaDistance / deltaTime);
    }



}
