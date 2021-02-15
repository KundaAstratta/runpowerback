package com.runpowerback.runpowerback.exposition.controller;

import com.runpowerback.runpowerback.application.service.ActivityService;
import com.runpowerback.runpowerback.application.dto.activity.ActivityDTO;
import com.runpowerback.runpowerback.application.dto.activity.ActivityMapper;
import com.runpowerback.runpowerback.exposition.exception.MessageFileXML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
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

    @RequestMapping(method = RequestMethod.GET, path = {"/fromXMLtoActivity/{fileXML}"})
    @ResponseStatus(HttpStatus.CREATED)
    public MessageFileXML fromXMLtoActivity(@PathVariable("fileXML") String fileXML) throws IOException {
        MessageFileXML messageFileXML = new MessageFileXML(this.activityService.fromXMLtoActivity(fileXML));
        return messageFileXML;

    }

   @RequestMapping(method = RequestMethod.GET, path = {"/fromActivityToPowerActivity/athlete/{idathlete}/activity/{idpoweractivity}"})
   public void fromActivityToPowerActivity(@PathVariable("idathlete") Long idathlete, @PathVariable("idpoweractivity") Long idpoweractivity) {
        this.activityService.fromActivityToPowerActivity(idathlete,idpoweractivity);
   }

    @RequestMapping(method = RequestMethod.GET, path = {"/activity"})
    public List<ActivityDTO> findAll() {
        return ActivityMapper.mapToOneActivity(this.activityService.findAll());
    }

    @RequestMapping(method = RequestMethod.DELETE, path = {"/activity"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAll() {
        this.activityService.deleteAll();
    }

}
