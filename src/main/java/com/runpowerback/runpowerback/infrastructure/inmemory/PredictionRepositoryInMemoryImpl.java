package com.runpowerback.runpowerback.infrastructure.inmemory;

import com.runpowerback.runpowerback.domaine.entity.Prediction;
import com.runpowerback.runpowerback.domaine.exception.ErrorCodes;
import com.runpowerback.runpowerback.domaine.exception.MyProjectException500;
import com.runpowerback.runpowerback.domaine.repository.PredictionRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Profile({"in-memory"})
@Repository
public class  PredictionRepositoryInMemoryImpl implements PredictionRepository {

    List<Prediction> predictionList = new ArrayList<>();

    @Override
    public Long save(Prediction prediction) {
        predictionList.add(prediction);
        return predictionList.get(predictionList.size()-1).getId();
    }

    @Override
    public Prediction findOnePrediction(Long idathlete, Long idpoweractivity) {
        Prediction predictionFound =    predictionList.stream()
                .filter(index -> index.getIdathlete().equals(idathlete) && index.getIdpoweractivity().equals(idpoweractivity))
                .findFirst().orElse(null);
        if (predictionFound == null) {
            throw new MyProjectException500(ErrorCodes.NOT_FOUND);
        } else {
            return predictionFound;
        }
    }

    @Override
    public List<Prediction> findAllPredictionForOneAthlete(Long idathlete) {
        return predictionList.stream().filter(index -> index.getIdathlete() == idathlete).collect(Collectors.toList());
    }

    @Override
    public Prediction findLastPrediction(Long idathlete) {
        List<Prediction> sortedList = predictionList.stream()
                .filter(index -> index.getIdathlete().equals(idathlete))
                .sorted(Comparator.comparing(Prediction::getIdpoweractivity))
                .collect(Collectors.toList());

        return sortedList.size() != 0 ? sortedList.get(sortedList.size() - 1) : null;
    }

    @Override
    public void deleteOnePrediction(Long idathlete, Long idpoweractivity) {
        Prediction predictionFound = predictionList.stream()
                .filter(index -> index.getIdathlete() == idathlete && index.getIdpoweractivity()==idpoweractivity)
                .findFirst()
                .orElse(null);

        predictionList.remove(predictionFound);
    }

}
