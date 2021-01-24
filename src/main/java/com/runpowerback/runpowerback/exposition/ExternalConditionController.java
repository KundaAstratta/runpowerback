package com.runpowerback.runpowerback.exposition;

import com.runpowerback.runpowerback.application.ExternalConditionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;

@RestController
public class ExternalConditionController {

    @Autowired
    ExternalConditionService externalConditionService;

    @RequestMapping(method = RequestMethod.POST, path = {"/externalcondition/athlete/{idathlete}"})
    @ResponseStatus(HttpStatus.CREATED)
    public Long createOneExternalCondition (@PathVariable("idathlete") Long idathlete, @Valid @RequestBody ExternalConditionDTO externalConditionDTO) {
      return this.externalConditionService.createOneExternalCondition(idathlete,ExternalConditionMapper.mapToOneExternalCondition(externalConditionDTO));
    }

    @RequestMapping(method = RequestMethod.POST, path = {"/fromexternalconditiontoprediction/athlete/{idathlete}"})
    @ResponseStatus(HttpStatus.CREATED)
    public void fromexternalconditiontoprediction (@PathVariable("idathlete") Long idathlete, @Valid @RequestBody ExternalConditionDTO externalConditionDTO) throws IOException {
        this.externalConditionService.fromExternalConditionToPrediction(idathlete,ExternalConditionMapper.mapToOneExternalCondition(externalConditionDTO));
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/externalcondition/athlete/{idathlete}/activity/{idpoweractivity}"})
    public ExternalConditionDTO findOneExternalCondition(@PathVariable("idathlete") Long idathlete, @PathVariable("idpoweractivity") Long idpoweractivity) {
        return ExternalConditionMapper.mapToExternalConditionDTO(this.externalConditionService.findOneExternalCondition(idathlete, idpoweractivity));
    }

}
