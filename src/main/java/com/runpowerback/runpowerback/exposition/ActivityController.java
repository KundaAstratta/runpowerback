package com.runpowerback.runpowerback.exposition;

import com.runpowerback.runpowerback.application.ActivityService;
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

    @RequestMapping(method =RequestMethod.GET, path = {"/fromXMLtoActivity"})
    public void fromXMLtoActivity() throws IOException {
        this.activityService.fromXMLtoActivity();
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
