package com.runpowerback.runpowerback.domaine.repository;

import com.runpowerback.runpowerback.domaine.entity.Prediction;

import java.util.List;

public interface PredictionRepository {

    Long save (Prediction prediction);
    Prediction findOnePrediction (Long idathlete, Long idpoweractivity);
    void deleteOnePrediction(Long idathlete, Long idpoweractivity);
    List<Prediction> findAllPredictionForOneAthlete (Long idathlete);
    Prediction findLastPrediction(Long idathlete);

}
