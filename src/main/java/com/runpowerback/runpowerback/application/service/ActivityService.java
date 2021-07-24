package com.runpowerback.runpowerback.application.service;

import com.runpowerback.runpowerback.domaine.entity.ActivityPointOf;
import com.runpowerback.runpowerback.domaine.entity.PowerActivityPointOf;
import com.runpowerback.runpowerback.domaine.repository.ActivityRepository;
import com.runpowerback.runpowerback.domaine.repository.AthleteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
@Transactional
public class ActivityService {

    @Autowired
    AthleteRepository athleteRepository;

    @Autowired
    ActivityRepository activityRepository;

    @Autowired
    FromActivityToPowerActivityService fromActivityToPowerActivityService;

    @Autowired
    FromXMLtoActivityService fromXMLtoActivityService;

    public Long createOnePointOfActivity (ActivityPointOf activity) {
        return this.activityRepository.save(activity);
    }

     public List<ActivityPointOf> findAll() {
        return this.activityRepository.findAll();
    }

    public String fromXMLtoActivity(String fileXML) throws IOException {
        this.activityRepository.deleteAll();
        return this.fromXMLtoActivityService.toReadXMLService(fileXML);
    }

    public void fromActivityToPowerActivity(Long idathlete, Long idpoweractivity) throws ExecutionException, InterruptedException {
        List<ActivityPointOf> run;
        run = this.activityRepository.findAll();
        float mass = this.athleteRepository.findOneAthlete(idathlete).getMass();
        List<PowerActivityPointOf> runpower = this.fromActivityToPowerActivityService.toTransform(idathlete, idpoweractivity, run, mass);
    }

    public void deleteAll () {
        this.activityRepository.deleteAll();
    }

}
