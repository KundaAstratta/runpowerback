package com.runpowerback.runpowerback.application.service;

import com.runpowerback.runpowerback.domaine.entity.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.transaction.Transactional;

import com.runpowerback.runpowerback.domaine.repository.AthleteRepository;
import com.runpowerback.runpowerback.domaine.repository.PredictionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
@Transactional
public class FromStatisticsToPredictionsService {

    private static final Logger logger = LogManager.getLogger();

    @Autowired
    PredictionRepository predictionRepository;

    @Autowired
    AthleteRepository athleteRepository;

    public Prediction toPredictions(List<StatisticsActivity> statisticsActivites, Long idathlete) throws ExecutionException, InterruptedException {
        logger.info("to Predictions begin....");

        Double upperBarrycentre = statisticsActivites.stream().mapToDouble(p -> p.getDeviation() * p.getPowermedian()).sum();

        Double lowerBarrycentre = statisticsActivites.stream().mapToDouble(StatisticsActivity::getDeviation).sum();

        Long idPowerActivity = statisticsActivites.stream().mapToLong(StatisticsActivity::getIdpoweractivity).max().orElse(1L);

        float powerOptimal = (float) (upperBarrycentre / lowerBarrycentre);

        logger.info("upperBarrycentre {}" , upperBarrycentre);
        logger.info("lowerBarrycentre {}" , lowerBarrycentre);
        logger.info("power {}" , powerOptimal);
        logger.info("idPowerActivity {}" , idPowerActivity);

        Athlete athlete = new Athlete();
        athlete = this.athleteRepository.findOneAthlete(idathlete);
        logger.info("athlete {}" , athlete);

        float speedOptimal = powerOptimal / athlete.getMass();
        logger.info("speedOptimal {}" , speedOptimal);
        String paceOptimal = getPaceFromSpeed(speedOptimal);
        logger.info("paceOptimal {}" , paceOptimal);

        float speedMin = speedOptimal - 1f / 1.8f;
        logger.info("speedMin {}" , speedMin);

        float speedMax = speedOptimal + 1f / 1.2f;
        logger.info("speedMax {}" , speedMax);

        String paceEasy = getPaceFromSpeed(getSpeedPredictionFromDistance(40000, speedOptimal,speedMin,speedMax));
        logger.info("Easy {}" , paceEasy);

        String paceThreshold = getPaceFromSpeed(getSpeedPredictionFromDistance(20000, speedOptimal,speedMin,speedMax));
        logger.info("Threshold {}" , paceThreshold);

        String paceHard = getPaceFromSpeed(getSpeedPredictionFromDistance(10000, speedOptimal,speedMin,speedMax));
        logger.info("Hard {}" , paceHard);

        String paceMin = getPaceFromSpeed(speedOptimal - 1f / 1.8f);
        logger.info("paceMin {}" , paceMin);

        String paceMax = getPaceFromSpeed(speedOptimal + 1f / 1.2f);
        logger.info("paceMax {}" , paceMax);

        float speedMarathon = getSpeedPredictionFromDistance(42195, speedOptimal,speedMin,speedMax);
        logger.info("speed 42,195 km {}" , speedMarathon);
        String paceMarathon = getPaceFromSpeed(getSpeedPredictionFromDistance(42195, speedOptimal,speedMin,speedMax));
        logger.info("Pace {}" , paceMarathon);
        String timeForMarathon = getCalculateTimeFromSecondes((long) (42195 / speedMarathon));
        logger.info("marathon time {}" , timeForMarathon);

        float speedHalfMarathon = getSpeedPredictionFromDistance(21097.5f, speedOptimal,speedMin,speedMax);
        logger.info("speed 21,0975 km {}" , speedHalfMarathon);
        String paceHalfMarathon = getPaceFromSpeed(getSpeedPredictionFromDistance(21097.5f, speedOptimal,speedMin,speedMax));
        logger.info("Pace {}" , paceHalfMarathon);
        String  timeForHalfMarathon = getCalculateTimeFromSecondes((long) (21097.5f / speedHalfMarathon));
        logger.info("half marathon {}" , timeForHalfMarathon);

        float speedTenKm = getSpeedPredictionFromDistance(10000, speedOptimal,speedMin,speedMax);
        logger.info("speed 10 km {}" , speedTenKm);
        String paceTenKm = getPaceFromSpeed(getSpeedPredictionFromDistance(10000, speedOptimal,speedMin,speedMax));
        logger.info("Pace {}" , paceTenKm);
        String  timeForTenKm = getCalculateTimeFromSecondes((long) (10000 / speedTenKm));
        logger.info("10km {}" , timeForTenKm);

        Prediction prediction = new Prediction(null,idathlete,idPowerActivity,powerOptimal,speedOptimal, paceOptimal,paceEasy,paceThreshold,
                paceHard, paceMin, paceMax,paceMarathon,timeForMarathon,paceHalfMarathon,timeForHalfMarathon,
                paceTenKm,timeForTenKm);
        logger.info("prediction {}" , prediction.toString());

        this.predictionRepository.save(prediction);

        logger.info("to Prediction end...");

        return prediction;

    }

    public static String getStringFromLong (Long number) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(number);
        return stringBuffer.toString();
    }

    public static String getStringFromFloat(float number) {
        StringBuffer stringBuffer =  new StringBuffer();
        stringBuffer.append(number);
        return stringBuffer.toString();
    }

    public static String getPaceFromSpeed(float speed) {

        float paceOptimal = (60f / (speed * 3.6f));
        int paceOptimalEntier = (int)paceOptimal;
        float paceOptimalDecimal = (paceOptimal - paceOptimalEntier) * 60f;
        StringBuffer sbPaceOptimal = new StringBuffer("");
        sbPaceOptimal.append(paceOptimalEntier);
        sbPaceOptimal.append(":");
        if (paceOptimalDecimal < 10f) {
            sbPaceOptimal.append("10");
        } else {
            sbPaceOptimal.append(paceOptimalDecimal);
        }
        String paceOptimalString = sbPaceOptimal.toString().substring(0,4);

        return paceOptimalString;
    }

    public static float getSpeedPredictionFromDistance(float distance, float speedOptimal, float speedMin, float speedMax) {
        float speedReturned = speedOptimal + (5f / 6f) - (1f / 36000f) * distance;
        if (speedReturned < speedMin) {
            speedReturned = speedMin;
        }
        if (speedReturned > speedMax) {
            speedReturned = speedMax;
        }
        return speedReturned;
    }

    public static String getCalculateTimeFromSecondes(long seconds) {
        long sec = seconds % 60;
        long min = seconds % 3600 / 60;
        long hours = seconds % 86400 / 3600;
        long days = seconds / 86400;
        StringBuffer sbCalculateTime = new StringBuffer("");
        if (days != 0) {
            sbCalculateTime.append(days);
            sbCalculateTime.append("days");
        }
        if (hours != 0) {
            sbCalculateTime.append(hours);
            sbCalculateTime.append("h");
        }
        if (min != 0) {
            sbCalculateTime.append(min);
            sbCalculateTime.append("m");
        }
        if (sec != 0) {
            sbCalculateTime.append(sec);
            sbCalculateTime.append("s");
        }
        String timeCalculateString = sbCalculateTime.toString();

        return timeCalculateString;
    }

}
