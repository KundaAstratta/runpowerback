package com.runpowerback.runpowerback.exposition.controller;

import com.runpowerback.runpowerback.application.service.ActivityService;
import com.runpowerback.runpowerback.application.dto.activity.ActivityPoinfOfDTO;
import com.runpowerback.runpowerback.application.dto.activity.ActivityMapper;
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
    public Long createOnePointOfActivity (@Valid @RequestBody ActivityPoinfOfDTO activityDTO){
        return this.activityService.createOnePointOfActivity(ActivityMapper.mapToOnePointActivity(activityDTO));
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/activity"})
    public List<ActivityPoinfOfDTO> findActivity() {
        return ActivityMapper.mapToOneActivity(this.activityService.findAll());
    }

    @RequestMapping(method = RequestMethod.DELETE, path = {"/activity"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteActivity() {
        this.activityService.deleteAll();
    }

}
