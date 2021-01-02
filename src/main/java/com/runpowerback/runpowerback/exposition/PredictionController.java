package com.runpowerback.runpowerback.exposition;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.validation.Valid;

import com.runpowerback.runpowerback.application.PredictionService;

@RestController
public class PredictionController {

    @Autowired
    PredictionService predictionService;

    @RequestMapping(method = RequestMethod.POST, path = {"/prediction"})
    @ResponseStatus(HttpStatus.CREATED)
    public Long createOnePrediction(@Valid @RequestBody PredictionDTO predictionDTO) {
        return this.predictionService.createOnePrediction(PredictionMapper.mapToOnePrediction(predictionDTO));
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/prediction/athlete/{idathlete}/activity/{idpoweractivity}"})
    public PredictionDTO findOnePredicton(@PathVariable("idathlete") Long idathlete, @PathVariable("idpoweractivity") Long idpoweractivity ) {
        return PredictionMapper.mapToOnePredictionDTO(this.predictionService.findOnePrediction(idathlete,idpoweractivity));
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/prediction/last/{idathlete}"})
    public PredictionDTO findLastPrediction(@PathVariable("idathlete") Long idathlete) {
        return PredictionMapper.mapToOnePredictionDTO(this.predictionService.findLastPrediction(idathlete));
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/prediction//athlete/{idathlete}"})
    public List<PredictionDTO> findAllPredictionForOneAthlete(@PathVariable("idathlete") Long idathlete) {
        return PredictionMapper.mapToListPredictionDTO(this.predictionService.findAllPredictionForOneAthlete(idathlete));
    }

}
