package com.runpowerback.runpowerback.application;

import com.runpowerback.runpowerback.domaine.Activity;
import com.runpowerback.runpowerback.domaine.ActivityRepository;
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
    ActivityRepository activityRepository;

    @Autowired
    PowerActivityRepository powerActivityRepository;

    @Autowired
    TransformService transformService;

    @Autowired
    ReadXMLService readXMLService;

    public Long createOnePointOfActivity (Activity activity) {
        return this.activityRepository.save(activity);
    }

     public List<Activity> findAll() {
        return this.activityRepository.findAll();
    }

    public void fromXMLtoActivity() throws IOException {
        this.activityRepository.deleteAll();
        this.readXMLService.toReadXMLService();
    }

    public void fromActivityToPowerActivity() {
   //   this.powerActivityRepository.deleteAll();
        this.powerActivityRepository.deleteOnePowerActivity(1L,1L);
        List<Activity> run;
        run = this.activityRepository.findAll();
        this.transformService.toTransform(run);
    }

    public void deleteAll () {
        this.activityRepository.deleteAll();
    }


}
