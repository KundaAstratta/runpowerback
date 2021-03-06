package com.runpowerback.runpowerback.application.service;

import java.util.List;

import javax.transaction.Transactional;

import com.runpowerback.runpowerback.domaine.entity.Prediction;
import com.runpowerback.runpowerback.domaine.repository.PredictionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PredictionService {

    @Autowired
    PredictionRepository predictionRepository;

    public Long createOnePrediction(Prediction prediction) {
        return this.predictionRepository.save(prediction);
    }

    public Prediction findOnePrediction (Long idathlete, Long idpoweractivity) {
        return this.predictionRepository.findOnePrediction(idathlete, idpoweractivity);
    }

    public void deleteOnePrediction (Long idathlete, Long idpoweractivity) {
        this.predictionRepository.deleteOnePrediction(idathlete,idpoweractivity);
    }

    public List<Prediction> findAllPredictionForOneAthlete (Long idathlete) {
        return this.predictionRepository.findAllPredictionForOneAthlete(idathlete);
    }

    public Prediction findLastPrediction(Long idathlete) {
        return this.predictionRepository.findLastPrediction(idathlete);
    }

}
