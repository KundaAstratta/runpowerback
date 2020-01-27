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

    @RequestMapping(method =RequestMethod.POST, path = {"/fromXMLtoActivity"})
    public void readXMLconvertToActivity() throws IOException {
        this.activityService.readXMLconvertToActivity();
    }

    /*
    @RequestMapping(method = RequestMethod.GET, path = {"/libraries/director/surname/{surname}"})
    public List<LibraryDTO> listAllLibrairiesByDirectorName(@PathVariable("surname") String surname) {
        return LibraryAdapter.adaptToLibraryDTOList(this.libraryService.listAllByDirectorName(surname));
    }
    */

   @RequestMapping(method = RequestMethod.GET, path = {"/fromActivityToPowerActivity"})
   public void fromActivityToPowerActivity() {
        this.activityService.fromActivityToPowerActivity();
   }

    @RequestMapping(method = RequestMethod.GET, path = {"/activity"})
    public List<ActivityDTO> findOneActivity() {
        return ActivityMapper.mapToOneActivity(this.activityService.findOneActivity());
    }


}
