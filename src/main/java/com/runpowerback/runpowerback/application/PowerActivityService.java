package com.runpowerback.runpowerback.application;


import com.runpowerback.runpowerback.domaine.PowerActivity;
import com.runpowerback.runpowerback.domaine.PowerActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.runpowerback.runpowerback.domaine.StatisticsActivity;

import javax.transaction.Transactional;
import java.util.List;

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

    public Long createOnePointOfPowerActivity(PowerActivity powerActivity) {
        return this.powerActivityRepository.save(powerActivity);
    }

    public List<PowerActivity> findAll() {
        return this.powerActivityRepository.findAll();
    }

    public void deleteAll() {
        this.powerActivityRepository.deleteAll();
    }

    public void deleteOnePowerActivity(Long idathlete, Long idpoweractivity) {
        this.powerActivityRepository.deleteOnePowerActivity(idathlete,idpoweractivity);
    }

    public List<PowerActivity> findOnePowerActivity(Long idathlete, Long idpoweractivity) {
        return this.powerActivityRepository.findOnePowerActivity(idathlete, idpoweractivity);
    }

    public void fromPowerActivityToStatistics(Long idathlete, Long idpoweractivity) {
        List<PowerActivity> runpower;
        idpoweractivity = this.powerActivityRepository.findMaxIdPowerActivity(idathlete);
        runpower = this.powerActivityRepository.findOnePowerActivity(idathlete,idpoweractivity);
        this.fromPowerActivityToStatisticsService.toStatistics(runpower, idathlete);
        List<StatisticsActivity> statisticsActivityList = this.statisticsActivityService.findAllStatisticsActivityForOneAthlete(idathlete);
        this.fromStatisticsToPredictionsService.toPredictions(statisticsActivityList,idathlete);
    }

    public Long findMaxIdPowerActivity(Long idathlete) {
        return this.powerActivityRepository.findMaxIdPowerActivity(idathlete);
    }

}
