package com.runpowerback.runpowerback.exposition.controller;

import com.runpowerback.runpowerback.application.service.ExternalConditionService;
import com.runpowerback.runpowerback.application.dto.externalCondition.ExternalConditionDTO;
import com.runpowerback.runpowerback.application.dto.externalCondition.ExternalConditionMapper;
import com.runpowerback.runpowerback.application.service.FromWeatherAPItoExternalConditionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class ExternalConditionController {

    @Autowired
    ExternalConditionService externalConditionService;

    @Autowired
    FromWeatherAPItoExternalConditionService fromWeatherAPItoExternalConditionService;

    @RequestMapping(method = RequestMethod.GET, path = {"/weatherapi/latitude/{latitude}/longitude/{longitude}"})
    public ExternalConditionDTO weatherapi(@PathVariable("latitude") float latitude, @PathVariable("longitude") float longitude) {
        return ExternalConditionMapper.mapToExternalConditionDTO(this.fromWeatherAPItoExternalConditionService.toCallWeatherAPI(latitude, longitude));
    }

    @RequestMapping(method = RequestMethod.POST, path = {"/externalcondition"})
    @ResponseStatus(HttpStatus.CREATED)
    public Long createOneExternalCondition (@Valid @RequestBody ExternalConditionDTO externalConditionDTO) {
        return this.externalConditionService.createOneExternalCondition(ExternalConditionMapper.mapToOneExternalCondition(externalConditionDTO));
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/externalcondition/athlete/{idathlete}/activity/{idpoweractivity}"})
    public ExternalConditionDTO findOneExternalCondition(@PathVariable("idathlete") Long idathlete, @PathVariable("idpoweractivity") Long idpoweractivity) {
        return ExternalConditionMapper.mapToExternalConditionDTO(this.externalConditionService.findOneExternalCondition(idathlete, idpoweractivity));
    }

    @RequestMapping(method = RequestMethod.DELETE, path = {"/externalcondition/delete/athlete/{idathlete}/activity/{idpoweractivity}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOneExternalCondition(@PathVariable("idathlete") Long idathlete, @PathVariable("idpoweractivity") Long idpoweractivity ) {
        this.externalConditionService.deleteOneExternalCondition(idathlete,idpoweractivity);
    }



}
