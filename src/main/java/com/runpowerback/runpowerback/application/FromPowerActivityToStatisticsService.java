package com.runpowerback.runpowerback.application;

import com.runpowerback.runpowerback.domaine.PowerActivity;
import com.runpowerback.runpowerback.domaine.PowerActivityRepository;
import com.runpowerback.runpowerback.domaine.StatisticsActivity;
import com.runpowerback.runpowerback.domaine.StatisticsActivityRepository;
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

    private static final Logger logger = LogManager.getLogger();

    public void toStatistics (List<PowerActivity> runpower) {
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

        float powerScore = (powerAverage - powerMedian) * (powerAverage - powerMedian) * deviation;
        logger.info("power Score : " + powerScore);

        Long idathlete = runpower.get(runpower.size()-1).getIdathlete();

        Long idpoweractivity = this.powerActivityRepository.findMaxIdPowerActivity(idathlete);
        logger.info("idathlete : "  + idathlete + "idpoweractivity : " + idpoweractivity);

        StatisticsActivity statisticsActivity = new StatisticsActivity(null,idathlete,idpoweractivity, powerAverage, powerMedian,deviation,powerScore, DateOfStatisticActivity);
        this.statisticsActivityRepository.save(statisticsActivity);
    }

}
