package com.runpowerback.runpowerback.application.service;

import com.runpowerback.runpowerback.domaine.entity.ActivityPointOf;
import com.runpowerback.runpowerback.domaine.entity.ExternalCondition;
import com.runpowerback.runpowerback.domaine.entity.PowerActivityPointOf;
import com.runpowerback.runpowerback.domaine.entity.StatisticsActivity;
import com.runpowerback.runpowerback.domaine.repository.ActivityRepository;
import com.runpowerback.runpowerback.domaine.repository.AthleteRepository;
import com.runpowerback.runpowerback.domaine.repository.ExternalConditionRepository;
import com.runpowerback.runpowerback.domaine.repository.PowerActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
@Transactional
public class ExternalConditionService {

    @Autowired
    ExternalConditionRepository externalConditionRepository;

    @Autowired
    PowerActivityRepository powerActivityRepository;

    @Autowired
    ActivityRepository activityRepository;

//    @Autowired
//    FromXMLtoActivityService fromXMLtoActivityService;

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

    @Autowired
    FromWeatherAPItoExternalConditionService fromWeatherAPItoExternalConditionService;

    public Long createOneExternalCondition (ExternalCondition externalCondition) {
        return this.externalConditionRepository.save(externalCondition);
    }

    public Long createOneExternalConditionWithIncrement (ExternalCondition externalCondition) {
        Long idpoweractivity = this.powerActivityRepository.findMaxIdPowerActivity(externalCondition.getIdathlete());
        externalCondition.setIdpoweractivity(idpoweractivity+1);
        return this.externalConditionRepository.save(externalCondition);
    }

    public void deleteOneExternalCondition(Long idathlete, Long idpoweractivity) {
        this.externalConditionRepository.deleteOneExternalCondition(idathlete,idpoweractivity);
    }

    public void fromExternalConditionToPrediction(Long idathlete,ExternalCondition externalCondition) throws IOException, ExecutionException, InterruptedException {

     // Long idathlete = externalCondition.getIdathlete();
        Long idpoweractivity = this.powerActivityRepository.findMaxIdPowerActivity(idathlete);
        externalCondition.setIdpoweractivity(idpoweractivity+1);

        List<ActivityPointOf> run;
        run = this.activityRepository.findAll();

        // Call the Weather API only in the case we have the default values
        if ((externalCondition.getPressureatm() == 100000) &&
            (externalCondition.getTemperature() == 10) &&
            (externalCondition.getHumidity() == 50) &&
            (externalCondition.getSpeedwind() == 0)) {
                ExternalCondition externalConditionFromWeatherAPI;
                externalConditionFromWeatherAPI = fromWeatherAPItoExternalConditionService.toCallWeatherAPI(run.get(0).getLatitude(),run.get(0).getLongitude());
                externalCondition.setPressureatm(externalConditionFromWeatherAPI.getPressureatm());
                externalCondition.setTemperature(externalConditionFromWeatherAPI.getTemperature());
                externalCondition.setHumidity(externalConditionFromWeatherAPI.getHumidity());
                externalCondition.setSpeedwind(externalConditionFromWeatherAPI.getSpeedwind());
        }
        this.externalConditionRepository.save(externalCondition);

        float mass = this.athleteRepository.findOneAthlete(idathlete).getMass();
        idpoweractivity = this.powerActivityRepository.findMaxIdPowerActivity(idathlete) + 1;
        this.fromActivityToPowerActivityService.toTransform(idathlete,idpoweractivity,run,mass);

        List<PowerActivityPointOf> runpower;
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
