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

//Power Statistics to Predictions with VDOT
@Service
@Transactional
public class FromStatisticsToPredictionsService {

    private static final Logger logger = LogManager.getLogger();

    @Autowired
    PredictionRepository predictionRepository;

    @Autowired
    AthleteRepository athleteRepository;

    @Autowired
    FormulaVDOTService formulaVDOTService;

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

        float vo2 = formulaVDOTService.VO2(60 * speedOptimal);
        logger.info("vo2 {}" , vo2);
        float vdot = formulaVDOTService.VDOT(vo2,0.85f);
        logger.info("vdot {}" , vdot);

        String paceEasy = getStringFromPace(formulaVDOTService.target(1000,0.67f,vdot));
        logger.info("paceEasy {}",paceEasy);

        String paceThreshold = getStringFromPace(formulaVDOTService.target(1000,0.88f,vdot));
        logger.info("paceThreshold {}",paceThreshold);

        String paceRepetition = getStringFromPace(formulaVDOTService.target(1000,1.2f,vdot));
        logger.info("paceRepetition {}",paceRepetition);
        String paceHard = paceRepetition;

        String paceModerate = getStringFromPace(formulaVDOTService.target(1000,0.82f,vdot));
        logger.info("paceModerate {}",paceModerate);
        String paceMin = paceModerate;

        String paceInterval = getStringFromPace(formulaVDOTService.target(1000,0.975f,vdot));
        logger.info("paceInterval {}",paceInterval);
        String paceMax = paceInterval;

        float timeMarathon = formulaVDOTService.target(42195,0.811f,vdot);
        logger.info("timeMarathon {}" , timeMarathon);
        String timeForMarathon = getCalculateTimeFromSecondes((long) (timeMarathon * 60));
        float speedMarathon = 42195f / (timeMarathon * 60);
        String paceMarathon = getPaceFromSpeed(speedMarathon);
        logger.info("speedMarathon {}" , speedMarathon);
        logger.info("paceMarathon {}" , paceMarathon);
        logger.info("timeForMarathon {}" , timeForMarathon);

        float timeHalfMarathon = formulaVDOTService.target(21097.5f,0.849f,vdot);
        logger.info("timeHalfMarathon {}" , timeHalfMarathon);
        String timeForHalfMarathon = getCalculateTimeFromSecondes((long) (timeHalfMarathon * 60));
        float speedHalfMarathon = 21097.5f / (timeHalfMarathon * 60);
        String paceHalfMarathon = getPaceFromSpeed(speedHalfMarathon);
        logger.info("speedHalfMarathon {}" , speedHalfMarathon);
        logger.info("paceHalfMarathon {}" , paceHalfMarathon);
        logger.info("timeForHalfMarathon {}" , timeForHalfMarathon);

        float timeTenKm = formulaVDOTService.target(10000f,0.903f,vdot);
        logger.info("timeTenKm {}" , timeTenKm);
        String timeForTenKm = getCalculateTimeFromSecondes((long) (timeTenKm * 60));
        float speedTenKm = 10000f / (timeTenKm * 60);
        String paceTenKm = getPaceFromSpeed(speedTenKm);
        logger.info("speedTenKm {}" , speedTenKm);
        logger.info("paceTenKm {}" , paceTenKm);
        logger.info("timeForTenKm {}" , timeForTenKm);


        Prediction prediction = new Prediction(null,idathlete,idPowerActivity,powerOptimal,speedOptimal, paceOptimal,paceEasy,paceThreshold,
                paceHard, paceMin, paceMax,paceMarathon,timeForMarathon,paceHalfMarathon,timeForHalfMarathon,
                paceTenKm,timeForTenKm);
        logger.info("prediction {}" , prediction.toString());

        this.predictionRepository.save(prediction);

        logger.info("to Prediction end...");

        return prediction;

    }

    public static String getStringFromPace(float pace) {
        int paceInteger = (int)pace;
        float paceDecimal = (pace - paceInteger) * 60f;
        StringBuffer sbPace = new StringBuffer("");
        sbPace.append(paceInteger);
        sbPace.append(":");
        if (paceDecimal < 10f) {
            sbPace.append("0");
            sbPace.append(paceDecimal);
        } else {
            sbPace.append(paceDecimal);
        }
        return sbPace.toString().substring(0,4);
    }

    public static String getPaceFromSpeed(float speed) {
        float paceFromSpeed = (60f / (speed * 3.6f));
        int paceFromSpeedInteger = (int)paceFromSpeed;
        float paceFromSpeedDecimal = (paceFromSpeed - paceFromSpeedInteger) * 60f;
        StringBuffer sbPaceFromSpeed = new StringBuffer("");
        sbPaceFromSpeed.append(paceFromSpeedInteger);
        sbPaceFromSpeed.append(":");
        if (paceFromSpeedDecimal < 10f) {
            sbPaceFromSpeed.append("0");
            sbPaceFromSpeed.append(paceFromSpeedDecimal);

        } else {
            sbPaceFromSpeed.append(paceFromSpeedDecimal);
        }
        String paceOptimalString = sbPaceFromSpeed.toString().substring(0,4);

        return paceOptimalString;
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
