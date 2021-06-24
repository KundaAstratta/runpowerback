package com.runpowerback.runpowerback.exposition.controller;


import com.runpowerback.runpowerback.application.dto.externalCondition.ExternalConditionDTO;
import com.runpowerback.runpowerback.application.dto.externalCondition.ExternalConditionMapper;
import com.runpowerback.runpowerback.application.service.ActivityService;
import com.runpowerback.runpowerback.application.service.ExternalConditionService;
import com.runpowerback.runpowerback.application.service.PowerActivityService;
import com.runpowerback.runpowerback.exposition.exception.MessageFileXML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

@RestController
public class TransformController {

    @Autowired
    ActivityService activityService;

    @Autowired
    ExternalConditionService externalConditionService;

    @Autowired
    PowerActivityService powerActivityService;

    @RequestMapping(method = RequestMethod.GET, path = {"/fromXMLtoActivity/{fileXML}"})
    @ResponseStatus(HttpStatus.CREATED)
    public MessageFileXML fromXMLtoActivity(@PathVariable("fileXML") String fileXML) throws IOException {
        MessageFileXML messageFileXML = new MessageFileXML(this.activityService.fromXMLtoActivity(fileXML));
        return messageFileXML;
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/fromActivityToPowerActivity/athlete/{idathlete}/activity/{idpoweractivity}"})
    public void fromActivityToPowerActivity(@PathVariable("idathlete") Long idathlete, @PathVariable("idpoweractivity") Long idpoweractivity) throws ExecutionException, InterruptedException {
        this.activityService.fromActivityToPowerActivity(idathlete,idpoweractivity);
    }

    @RequestMapping(method = RequestMethod.POST, path = {"/fromExternalConditionToPrediction/athlete/{idathlete}"})
    @ResponseStatus(HttpStatus.CREATED)
    public void fromExternalConditionToPrediction(@PathVariable("idathlete") Long idathlete, @Valid @RequestBody ExternalConditionDTO externalConditionDTO) throws IOException, ExecutionException, InterruptedException {
        this.externalConditionService.fromExternalConditionToPrediction(idathlete, ExternalConditionMapper.mapToOneExternalCondition(externalConditionDTO));
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/fromPowerActivityToStatisticsAndPredictions/athlete/{idathlete}/activity/{idpoweractivity}"})
    public void fromPowerActivityToStatisticsAndPredictions(@PathVariable("idathlete") Long idathlete, @PathVariable("idpoweractivity") Long idpoweractivity) throws ExecutionException, InterruptedException {
        this.powerActivityService.fromPowerActivityToStatisticsAndPredictions(idathlete,idpoweractivity);
    }


}
