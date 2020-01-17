package com.runpowerback.runpowerback.exposition;

import com.runpowerback.runpowerback.application.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ActivityController {

    @Autowired
    ActivityService activityService;

    @RequestMapping(method = RequestMethod.POST, path = {"/activity"})
    @ResponseStatus(HttpStatus.CREATED)
    public Long createOnePointOfActivity (@Valid @RequestBody ActivityDTO activityDTO){
        return this.activityService.createOnePointOfActivity(ActivityMapper.mapToOnePointActivity(activityDTO));
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/activity"})
    public List<ActivityDTO> findOneActivity() {
        return ActivityMapper.mapToOneActivity(this.activityService.findOneActivity());
    }

}
