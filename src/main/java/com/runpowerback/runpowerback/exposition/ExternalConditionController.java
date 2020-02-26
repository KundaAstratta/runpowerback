package com.runpowerback.runpowerback.exposition;

import com.runpowerback.runpowerback.application.ExternalConditionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class ExternalConditionController {

    @Autowired
    ExternalConditionService externalConditionService;

    @RequestMapping(method = RequestMethod.POST, path = {"/externalcondition"})
    @ResponseStatus(HttpStatus.CREATED)
    public Long createOneExternalCondition (@Valid @RequestBody ExternalConditionDTO externalConditionDTO) {
      return this.externalConditionService.createOneExternalCondition(ExternalConditionMapper.mapToOneExternalCondition(externalConditionDTO));
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/externalcondition/athlete/{idathlete}/activity/{idpoweractivity}"})
    public ExternalConditionDTO findOneExternalCondition(@PathVariable("idathlete") Long idathlete, @PathVariable("idpoweractivity") Long idpoweractivity) {
        return ExternalConditionMapper.mapToExternalConditionDTO(this.externalConditionService.findOneExternalCondition(idathlete, idpoweractivity));
    }

}
