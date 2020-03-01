package com.runpowerback.runpowerback.application;

import com.runpowerback.runpowerback.domaine.Activity;
import com.runpowerback.runpowerback.domaine.ActivityRepository;
import com.runpowerback.runpowerback.domaine.AthleteRepository;
import com.runpowerback.runpowerback.domaine.PowerActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;

@Service
@Transactional
public class ActivityService {

    @Autowired
    AthleteRepository athleteRepository;

    @Autowired
    ActivityRepository activityRepository;

    @Autowired
    PowerActivityRepository powerActivityRepository;

    @Autowired
    FromActivityToPowerActivityService fromActivityToPowerActivityService;

    @Autowired
    FromXMLtoActivityService fromXMLtoActivityService;

    public Long createOnePointOfActivity (Activity activity) {
        return this.activityRepository.save(activity);
    }

     public List<Activity> findAll() {
        return this.activityRepository.findAll();
    }

    public void fromXMLtoActivity() throws IOException {
        this.activityRepository.deleteAll();
        this.fromXMLtoActivityService.toReadXMLService();
    }

    public void fromActivityToPowerActivity(Long idathlete, Long idpoweractivity) {
     //   this.powerActivityRepository.deleteOnePowerActivity(idathlete,idpoweractivity);
        List<Activity> run;
        run = this.activityRepository.findAll();
        float mass = this.athleteRepository.findOneAthlete(idathlete).getMass();
        idpoweractivity = this.powerActivityRepository.findMaxIdPowerActivity(idathlete) + 1;
        this.fromActivityToPowerActivityService.toTransform(idathlete,idpoweractivity,run,mass);
    }

    public void deleteAll () {
        this.activityRepository.deleteAll();
    }

}
