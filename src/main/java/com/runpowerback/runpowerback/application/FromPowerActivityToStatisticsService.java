package com.runpowerback.runpowerback.application;

import com.runpowerback.runpowerback.RunpowerbackApplication;
import com.runpowerback.runpowerback.domaine.PowerActivity;
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

    private static final Logger logger = LogManager.getLogger(RunpowerbackApplication.class);

    void toStatistics (List<PowerActivity> runpower) {
        List<Float> runpowerSorted = new ArrayList<>();
        logger.info("ici");
        logger.info(runpower);

        float sumOfPower = runpower.get(1).getPower();
        float currentPower;

        int i = 2;
        logger.info("taille : " + runpower.size());

        float sumOfVariance = 0;
        float deviation;
     //   float s = runpower.get(1).getPower();

        while(i <= runpower.size()-1) {
            currentPower = runpower.get(i).getPower();
            runpowerSorted.add(currentPower);
            sumOfPower = sumOfPower + currentPower;
     //       if  (i>= 2) {
         //       s = s + runpower.get(i).getPower();
            sumOfVariance = sumOfVariance + (i * runpower.get(i).getPower() - sumOfPower) *  (i * runpower.get(i).getPower() - sumOfPower) / (i * (i-1));
      //      }
            i = i + 1;
        }

        Collections.sort(runpowerSorted);
        logger.info(runpowerSorted);

        float powerMax = runpowerSorted.get(runpowerSorted.size()-1);
        logger.info("power max : " + powerMax);

        float powerAverage = sumOfPower / (runpowerSorted.size() - 1);
        logger.info("Average Power : " + powerAverage);

        deviation = (float) Math.sqrt(sumOfVariance / (runpower.size()-1));
        logger.info("deviation : " + deviation);

        int averageNumber;
        if (runpower.size()%2 != 0) {
            averageNumber = runpower.size()/2 + 1;
        } else {
            averageNumber = runpower.size()/2;
        }
        logger.info("average Number : " + averageNumber);
        float powerMedian = runpowerSorted.get(averageNumber);
        logger.info("power Median : " + powerMedian);

  /*      i = 1;
        s = 0;
        while(i <= runpower.size()-1) {
            s = s + (runpower.get(i).getPower() - powerAverage) * (runpower.get(i).getPower() - powerAverage);
            i = i + 1;
        }

        deviation = (float) Math.sqrt(s / runpower.size());
        logger.info("deviation : " + deviation);
  */
        StatisticsActivity statisticsActivity = new StatisticsActivity(null,1L,1L, powerAverage, powerMedian,deviation);
        this.statisticsActivityRepository.save(statisticsActivity);
    }

}
