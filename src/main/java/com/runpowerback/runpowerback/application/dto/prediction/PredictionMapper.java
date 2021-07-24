package com.runpowerback.runpowerback.application.dto.prediction;

import java.util.List;
import java.util.stream.Collectors;

import com.runpowerback.runpowerback.domaine.entity.Prediction;

public class PredictionMapper {

    public PredictionMapper() {
    }

    public static Prediction mapToOnePrediction (PredictionDTO predictionDTO) {
        return new Prediction(
                null,
                predictionDTO.idathlete,
                predictionDTO.idpoweractivity,
                predictionDTO.powerOptimal,
                predictionDTO.speedOptimal,
                predictionDTO.paceOptimal,
                predictionDTO.paceEasy,
                predictionDTO.paceThreshold,
                predictionDTO.paceHard,
                predictionDTO.paceMin,
                predictionDTO.paceMax,
                predictionDTO.paceMarathon,
                predictionDTO.timeForMarathon,
                predictionDTO.paceHalfMarathon,
                predictionDTO.timeForHalfMarathon,
                predictionDTO.paceTenKm,
                predictionDTO.timeForTenKm
        );
    }

    public static PredictionDTO mapToOnePredictionDTO (Prediction prediction) {
        return new PredictionDTO(
                prediction.getIdathlete(),
                prediction.getIdpoweractivity(),
                prediction.getPowerOptimal(),
                prediction.getSpeedOptimal(),
                prediction.getPaceOptimal(),
                prediction.getPaceEasy(),
                prediction.getPaceThreshold(),
                prediction.getPaceHard(),
                prediction.getPaceMin(),
                prediction.getPaceMax(),
                prediction.getPaceMarathon(),
                prediction.getTimeForMarathon(),
                prediction.getPaceHalfMarathon(),
                prediction.getTimeForHalfMarathon(),
                prediction.getPaceTenKm(),
                prediction.getTimeForTenKm()
        );
    }

    public static List<PredictionDTO> mapToListPredictionDTO (List<Prediction> predictionList) {
        return predictionList.stream().map(PredictionMapper::mapToOnePredictionDTO).collect(Collectors.toList());
    }


}
