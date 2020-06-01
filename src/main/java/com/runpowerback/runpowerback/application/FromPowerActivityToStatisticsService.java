package com.runpowerback.runpowerback.application;

import com.runpowerback.runpowerback.domaine.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@Transactional
public class FromPowerActivityToStatisticsService {

    @Autowired
    StatisticsActivityRepository statisticsActivityRepository;

    @Autowired
    PowerActivityRepository powerActivityRepository;

    @Autowired
    AthleteRepository athleteRepository;

    private static final Logger logger = LogManager.getLogger();

    public void toStatistics (List<PowerActivity> runpower, Long idathlete) {
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

        float easyMin = athlete.getEasyhearthmin();
        float easyMax = athlete.getEasyhearthmax();
        float marathonMin = athlete.getMarathonhearthmin();
        float marathonMax = athlete.getMarathonhearthmax();
        float thresholdMin = athlete.getThresholdhearthmin();
        float thresholdMax = athlete.getThresholdhearthmax();
        float intervalMin = athlete.getIntervalhearthmin();
        float intervalMax = athlete.getIntervalhearthmax();
        float repetitionMin = athlete.getRepetitionhearthmin();
        float repetitionMax = athlete.getRepetitionhearthmax();

        int numberOfEasy = 0;
        int numberOfMarathon = 0;
        int numberOfThreshold = 0;
        int numberOfInterval = 0;
        int numberOfRepetition = 0;

        while(i <= runpower.size()-1) {
            currentPower = runpower.get(i).getPower();

            if (runpower.get(i).getHearthrate() <= easyMax) {
                numberOfEasy = numberOfEasy + 1;
            } else {
                if ((marathonMin >= runpower.get(i).getHearthrate()) && (runpower.get(i).getHearthrate() <= marathonMax)) {
                    numberOfMarathon = numberOfMarathon + 1;
                } else {
                    if ((thresholdMin >= runpower.get(i).getHearthrate()) && (runpower.get(i).getHearthrate() <= thresholdMax)) {
                        numberOfThreshold = numberOfThreshold + 1;
                    } else {
                        if ((intervalMin >= runpower.get(i).getHearthrate()) && (runpower.get(i).getHearthrate()<= intervalMax)) {
                            numberOfInterval = numberOfInterval + 1;
                        } else {
                            if (repetitionMin >= runpower.get(i).getHearthrate()) {
                                numberOfRepetition = numberOfRepetition + 1;
                            }
                        }
                    }
                }
            }

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

        StatisticsActivity statisticsActivity = new StatisticsActivity(
                null,
                idathlete,
                idpoweractivity,
                powerAverage,
                powerMedian,deviation,
                powerScore, numberOfEasy,
                numberOfMarathon,
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

        logger.info("number of Esay : " +  numberOfEasy);
        logger.info("number of Marathon : " + numberOfMarathon);
        logger.info("number of Threshold : " + numberOfThreshold);
        logger.info("number of Interval : " + numberOfInterval);
        logger.info("number of Repetition : " + numberOfRepetition);

    }

}
