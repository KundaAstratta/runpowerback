package com.runpowerback.runpowerback.domaine;

import java.util.List;

public interface PredictionRepository {

    Long save (Prediction prediction);
    Prediction findOnePrediction (Long idathlete, Long idpoweractivity);
    List<Prediction> findAllPredictionForOneAthlete (Long idathlete);
    Prediction findLastPrediction(Long idathlete);

}
