package com.runpowerback.runpowerback.application.service;


import com.runpowerback.runpowerback.domaine.entity.PowerActivityPointOf;
import com.runpowerback.runpowerback.domaine.entity.Prediction;
import com.runpowerback.runpowerback.domaine.repository.PowerActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.runpowerback.runpowerback.domaine.entity.StatisticsActivity;

import javax.transaction.Transactional;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
@Transactional
public class PowerActivityService {

    @Autowired
    PowerActivityRepository powerActivityRepository;

    @Autowired
    FromPowerActivityToStatisticsService fromPowerActivityToStatisticsService;

    @Autowired
    StatisticsActivityService statisticsActivityService;

    @Autowired
    FromStatisticsToPredictionsService fromStatisticsToPredictionsService;

    public Long createOnePointOfPowerActivity(PowerActivityPointOf powerActivity) {
        return this.powerActivityRepository.save(powerActivity);
    }

    public List<PowerActivityPointOf> findAll() {
        return this.powerActivityRepository.findAll();
    }

    public void deleteAll() {
        this.powerActivityRepository.deleteAll();
    }

    public void deleteOnePowerActivity(Long idathlete, Long idpoweractivity) {
        this.powerActivityRepository.deleteOnePowerActivity(idathlete,idpoweractivity);
    }

    public List<PowerActivityPointOf> findOnePowerActivity(Long idathlete, Long idpoweractivity) {
        return this.powerActivityRepository.findOnePowerActivity(idathlete, idpoweractivity);
    }

    public void fromPowerActivityToStatisticsAndPredictions(Long idathlete, Long idpoweractivity) throws ExecutionException, InterruptedException {
        List<PowerActivityPointOf> runpower;
        runpower = this.powerActivityRepository.findOnePowerActivity(idathlete,idpoweractivity);
        this.fromPowerActivityToStatisticsService.toStatistics(runpower, idathlete);
        List<StatisticsActivity> statisticsActivityList = this.statisticsActivityService.findAllStatisticsActivityForOneAthlete(idathlete);
        Prediction prediction = this.fromStatisticsToPredictionsService.toPredictions(statisticsActivityList,idathlete);
    }

    public Long findMaxIdPowerActivity(Long idathlete) {
        return this.powerActivityRepository.findMaxIdPowerActivity(idathlete);
    }

}
