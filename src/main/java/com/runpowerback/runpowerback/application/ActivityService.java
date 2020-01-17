package com.runpowerback.runpowerback.application;

import com.runpowerback.runpowerback.domaine.Activity;
import com.runpowerback.runpowerback.domaine.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ActivityService {

    @Autowired
    ActivityRepository activityRepository;

    public Long createOnePointOfActivity (Activity activity) {
        return this.activityRepository.save(activity);
    }

    public List<Activity> findOneActivity() {

        return this.activityRepository.findAll();
    }

}
