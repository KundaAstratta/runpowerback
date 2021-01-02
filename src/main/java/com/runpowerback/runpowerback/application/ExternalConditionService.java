package com.runpowerback.runpowerback.application;

import com.runpowerback.runpowerback.domaine.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;

@Service
@Transactional
public class ExternalConditionService {

    @Autowired
    ExternalConditionRepository externalConditionRepository;

    @Autowired
    PowerActivityRepository powerActivityRepository;

    @Autowired
    ActivityRepository activityRepository;

    @Autowired
    FromXMLtoActivityService fromXMLtoActivityService;

    @Autowired
    AthleteRepository athleteRepository;

    @Autowired
    FromActivityToPowerActivityService fromActivityToPowerActivityService;

    @Autowired
    FromPowerActivityToStatisticsService fromPowerActivityToStatisticsService;

    @Autowired
    StatisticsActivityService statisticsActivityService;

    @Autowired
    FromStatisticsToPredictionsService fromStatisticsToPredictionsService;


    public Long createOneExternalCondition (ExternalCondition externalCondition) {
        Long idathlete = externalCondition.getIdathlete();
        Long idpoweractivity = this.powerActivityRepository.findMaxIdPowerActivity(idathlete);
        externalCondition.setIdpoweractivity(idpoweractivity+1);
        return this.externalConditionRepository.save(externalCondition);
    }

    public void fromExternalConditionToPrediction(ExternalCondition externalCondition) throws IOException {

        Long idathlete = externalCondition.getIdathlete();
        Long idpoweractivity = this.powerActivityRepository.findMaxIdPowerActivity(idathlete);
        externalCondition.setIdpoweractivity(idpoweractivity+1);
        this.externalConditionRepository.save(externalCondition);

        List<Activity> run;
        run = this.activityRepository.findAll();
        float mass = this.athleteRepository.findOneAthlete(idathlete).getMass();
        idpoweractivity = this.powerActivityRepository.findMaxIdPowerActivity(idathlete) + 1;
        this.fromActivityToPowerActivityService.toTransform(idathlete,idpoweractivity,run,mass);

        List<PowerActivity> runpower;
        idpoweractivity = this.powerActivityRepository.findMaxIdPowerActivity(idathlete);
        runpower = this.powerActivityRepository.findOnePowerActivity(idathlete,idpoweractivity);
        this.fromPowerActivityToStatisticsService.toStatistics(runpower, idathlete);
        List<StatisticsActivity> statisticsActivityList = this.statisticsActivityService.findAllStatisticsActivityForOneAthlete(idathlete);
        this.fromStatisticsToPredictionsService.toPredictions(statisticsActivityList,idathlete);

    }

    public ExternalCondition findOneExternalCondition (Long idathlete, Long idpoweractivity) {
        return this.externalConditionRepository.findOneExternalCondition(idathlete,idpoweractivity);
    }

}
