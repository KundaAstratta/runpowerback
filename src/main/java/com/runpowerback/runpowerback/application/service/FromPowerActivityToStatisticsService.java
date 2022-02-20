package com.runpowerback.runpowerback.application.service;

import com.runpowerback.runpowerback.domaine.entity.Athlete;
import com.runpowerback.runpowerback.domaine.entity.PowerActivityPointOf;
import com.runpowerback.runpowerback.domaine.entity.StatisticsActivity;
//import com.runpowerback.runpowerback.domaine.entity.StatisticsActivityFireBase;
import com.runpowerback.runpowerback.domaine.repository.AthleteRepository;
import com.runpowerback.runpowerback.domaine.repository.PowerActivityRepository;
import com.runpowerback.runpowerback.domaine.repository.PredictionRepository;
import com.runpowerback.runpowerback.domaine.repository.StatisticsActivityRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
@Transactional
public class FromPowerActivityToStatisticsService {

    @Autowired
    StatisticsActivityRepository statisticsActivityRepository;

    @Autowired
    PowerActivityRepository powerActivityRepository;

    @Autowired
    AthleteRepository athleteRepository;

    @Autowired
    PredictionRepository predictionRepository;

    //@Autowired
    //FireBaseService fireBaseService;

    private static final Logger logger = LogManager.getLogger();

    public void toStatistics (List<PowerActivityPointOf> runpower, Long idathlete) throws ExecutionException, InterruptedException {
        List<Float> runpowerSorted = new ArrayList<>();
        logger.info("here");
        logger.info(runpower);

        float sumOfPower = runpower.get(1).getPower();
        float currentPower;

        int i = 2;
        logger.info("size : " + runpower.size());

        float sumOfVariance = 0;
        float deviation;

        String DateOfStatisticActivity = runpower.get(1).getDate();
        logger.info("Date : " + DateOfStatisticActivity);

        runpowerSorted.add(runpower.get(1).getPower());

        Athlete athlete = new Athlete();
        athlete = athleteRepository.findOneAthlete(idathlete);

        while(i <= runpower.size()-1) {
            currentPower = runpower.get(i).getPower();

            runpowerSorted.add(currentPower);
            sumOfPower = sumOfPower + currentPower;

            sumOfVariance = sumOfVariance + (i * runpower.get(i).getPower() - sumOfPower) *  (i * runpower.get(i).getPower() - sumOfPower) / (i * (i-1));

            i = i + 1;
        }


        Collections.sort(runpowerSorted);
        logger.info(runpowerSorted);

        float powerMax = runpowerSorted.get(runpowerSorted.size()-1);
        logger.info("power max : " + powerMax);

        float powerAverage = sumOfPower / (runpower.size()-1);
        logger.info("Average Power : " + powerAverage);

        deviation = (float) Math.sqrt(sumOfVariance / (runpower.size()-1));
        logger.info("deviation : " + deviation);

        int averageNumber;
        if (runpowerSorted.size()%2 != 0) {
            averageNumber = runpowerSorted.size()/2 + 1;
        } else {
            averageNumber = runpowerSorted.size()/2;
        }
        logger.info("average Number : " + averageNumber);
        float powerMedian = runpowerSorted.get(averageNumber-1);
        logger.info("power Median : " + powerMedian);

        double firstQuartil;
        float powerFirstQuartil = 0;
        firstQuartil = (runpowerSorted.size() + 3) / 4;
        logger.info("first Quartil " + firstQuartil);
        double numberFirstQuartil = firstQuartil - Math.floor(firstQuartil) ;
        logger.info("numberFirstQuartil  " +  numberFirstQuartil);
        if (numberFirstQuartil == 0) {
            powerFirstQuartil = runpowerSorted.get((int)firstQuartil);
        } 
        if (numberFirstQuartil == 0.25) {
            firstQuartil = firstQuartil - 0.25;
            powerFirstQuartil = ( 3 * runpowerSorted.get((int)firstQuartil) + runpowerSorted.get((int)firstQuartil + 1) ) / 4;
        }  
        if (numberFirstQuartil == 0.5) {
            firstQuartil = firstQuartil - 0.5;
            powerFirstQuartil = ( runpowerSorted.get((int)firstQuartil) + runpowerSorted.get((int)firstQuartil + 1) ) / 2;
        } 
        if (numberFirstQuartil == 0.75) {
            firstQuartil = firstQuartil - 0.75;
            powerFirstQuartil = ( runpowerSorted.get((int)firstQuartil) + 3 * runpowerSorted.get((int)firstQuartil + 1) ) / 4;
        }  
        logger.info("Power first Quartil " + powerFirstQuartil);

        double thirdQuartil;
        float powerThirdQuartil = 0;
        thirdQuartil = (3 * runpowerSorted.size() + 1) / 4;
        double numberThirdQuartil = thirdQuartil - Math.floor(thirdQuartil);
        logger.info("third Quartil " + numberThirdQuartil);
        if (numberThirdQuartil == 0) {
            powerThirdQuartil = runpowerSorted.get((int)thirdQuartil);
        }
        if (numberThirdQuartil == 0.25) {
            thirdQuartil = thirdQuartil - 0.25;
            powerThirdQuartil = ( 3 * runpowerSorted.get((int)thirdQuartil) + runpowerSorted.get((int)thirdQuartil +1) ) / 4;
        }
        if (numberThirdQuartil == 0.5) {
            thirdQuartil = thirdQuartil - 0.5;
            powerThirdQuartil = ( runpowerSorted.get((int)thirdQuartil) + runpowerSorted.get((int)thirdQuartil +1) ) / 2;
        }
        if (numberThirdQuartil == 0.75) {
            thirdQuartil = thirdQuartil - 0.75;
            powerThirdQuartil = ( runpowerSorted.get((int)thirdQuartil) + 3 * runpowerSorted.get((int)thirdQuartil +1) ) / 4;
        }
        logger.info("Power thrid Quartil " + powerThirdQuartil);

        
        float powerScore = (powerAverage - powerMedian) * (powerAverage - powerMedian) * deviation;
        logger.info("power Score : " + powerScore);

        float deltaFirstQuartil = (powerMedian - powerFirstQuartil) ;
        logger.info("delta first quartil" + deltaFirstQuartil);

        float deltaThirdQuartil = (powerThirdQuartil - powerMedian);
        logger.info("delta third quartil " + deltaThirdQuartil);

        idathlete = runpower.get(runpower.size()-1).getIdathlete();

        Long idpoweractivity = this.powerActivityRepository.findMaxIdPowerActivity(idathlete);
        logger.info("idathlete : "  + idathlete + "idpoweractivity : " + idpoweractivity);

        float speedOptimal;
        if (predictionRepository.findAllPredictionForOneAthlete(idathlete).isEmpty()) {
            speedOptimal = powerMedian / athleteRepository.findOneAthlete(idathlete).getMass();
        } else {
            speedOptimal = predictionRepository.findLastPrediction(idathlete).getSpeedOptimal();
        }
        logger.info("speed optimal {}", speedOptimal);

        float speedMin = speedOptimal - 1f / 1.8f;
        logger.info("speedMin {}" , speedMin);

        float speedMax = speedOptimal + 1f / 1.2f;
        logger.info("speedMax {}" , speedMax);

        float speed40Km =  getSpeedPredictionFromDistance(40000,speedOptimal,speedMin,speedMax);

        float speed20Km = getSpeedPredictionFromDistance(20000,speedOptimal,speedMin,speedMax);

        float speed1OKm = getSpeedPredictionFromDistance(10000,speedOptimal,speedMin,speedMax);

        float speed5Km = getSpeedPredictionFromDistance(5000,speedOptimal,speedMin,speedMax);

        int numberOfEasy = 0;
        int numberOfModerate = 0;
        int numberOfThreshold = 0;
        int numberOfInterval = 0;
        int numberOfRepetition = 0;

        i = 2;
        while(i <= runpower.size()-1) {

            if (runpower.get(i).getSpeed() < speed40Km) {
                numberOfEasy = numberOfEasy + 1;
            } else {
                if ((speed40Km <= runpower.get(i).getSpeed()) && (runpower.get(i).getSpeed() < speed20Km)) {
                    numberOfModerate = numberOfModerate + 1;
                } else {
                    if ((speed20Km <= runpower.get(i).getSpeed()) && (runpower.get(i).getSpeed() < speed1OKm)) {
                        numberOfThreshold = numberOfThreshold + 1;
                    } else {
                        if ((speed1OKm <= runpower.get(i).getSpeed()) && (runpower.get(i).getSpeed()< speed5Km)) {
                            numberOfInterval = numberOfInterval + 1;
                        } else {
                            if (speed5Km <= runpower.get(i).getSpeed()) {
                                numberOfRepetition = numberOfRepetition + 1;
                            }
                        }
                    }
                }
            }

        i = i + 1;

        }

        StatisticsActivity statisticsActivity = new StatisticsActivity(
                null,
                idathlete,
                idpoweractivity,
                powerAverage,
                powerMedian,deviation,
                powerScore, numberOfEasy,
                numberOfModerate,
                numberOfThreshold,
                numberOfInterval,
                numberOfRepetition,
                DateOfStatisticActivity,
                powerFirstQuartil,
                deltaFirstQuartil,
                powerThirdQuartil,
                deltaThirdQuartil
                );

        this.statisticsActivityRepository.save(statisticsActivity);

        //FireBase : created a Prediction : begin
        /*StatisticsActivityFireBase statisticsActivityFireBase =
                new StatisticsActivityFireBase(
                        getStringFromLong(idathlete) + getStringFromLong(idpoweractivity),
                        getStringFromFloat(numberOfEasy),
                        getStringFromFloat(numberOfMarathon),
                        getStringFromFloat(numberOfThreshold),
                        getStringFromFloat(numberOfInterval),
                        getStringFromFloat(numberOfRepetition)
                );

        fireBaseService.saveStatisticsDetailsToFirebase(statisticsActivityFireBase);
        */
        //FireBase : created a Prediction : end

        logger.info("number of Esay : " +  numberOfEasy);
        logger.info("number of Marathon : " + numberOfModerate);
        logger.info("number of Threshold : " + numberOfThreshold);
        logger.info("number of Interval : " + numberOfInterval);
        logger.info("number of Repetition : " + numberOfRepetition);

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



}
