package com.runpowerback.runpowerback.infrastructure.crudrepository;

import java.util.List;
import java.util.stream.Collectors;

import com.runpowerback.runpowerback.domaine.entity.Prediction;
import com.runpowerback.runpowerback.domaine.repository.PredictionRepository;
import com.runpowerback.runpowerback.domaine.exception.ErrorCodes;
import com.runpowerback.runpowerback.domaine.exception.MyProjectException500;

import com.runpowerback.runpowerback.infrastructure.dao.PredictionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Profile({"local","cloud"})
@Repository
public class PredictionRepositoryImpl implements PredictionRepository {

    @Autowired
    PredictionDAO predictionDAO;

    @Override
    public Long save(Prediction prediction) {
        this.predictionDAO.save(prediction);
        return prediction.getId();
    }

    @Override
    public Prediction findOnePrediction(Long idathlete, Long idpoweractivity) {
        if (this.predictionDAO.findOnePrediction(idathlete,idpoweractivity) == null) {
            throw new MyProjectException500(ErrorCodes.NOT_FOUND);
        } else {
            return this.predictionDAO.findOnePrediction(idathlete, idpoweractivity);
        }
    }

    @Override
    public List<Prediction> findAllPredictionForOneAthlete(Long idathlete) {
        // TODO Auto-generated method stub
        return this.predictionDAO.findAllPredictionForOneAthlete(idathlete).stream().collect(Collectors.toList());

    }

    @Override
    public Prediction findLastPrediction(Long idathlete) {
        if (this.predictionDAO.findLastPrediction(idathlete) == null) {
            throw new MyProjectException500(ErrorCodes.NOT_FOUND);
        } else {
            return this.predictionDAO.findLastPrediction(idathlete);
        }
    }

    @Override
    public void deleteOnePrediction(Long idathlete, Long idpoweractivity) {
        // TODO Auto-generated method stub
        predictionDAO.deleteOnePrediction(idathlete, idpoweractivity);
    }



}
