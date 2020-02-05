package com.runpowerback.runpowerback.application;

import com.runpowerback.runpowerback.domaine.PowerActivity;
import com.runpowerback.runpowerback.domaine.PowerActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PowerActivityService {

    @Autowired
    PowerActivityRepository powerActivityRepository;

    @Autowired
    FromPowerActivityToStatisticsService fromPowerActivityToStatisticsService;

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

    public void statisticsOfPowerActivity() {
        List<PowerActivity> runpower;
        runpower = this.powerActivityRepository.findOnePowerActivity(1L,1L);
        this.fromPowerActivityToStatisticsService.toStatistics(runpower);
    }

}
