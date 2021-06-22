package com.runpowerback.runpowerback.infrastructure.dao;

import java.util.List;

import com.runpowerback.runpowerback.domaine.entity.Prediction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface PredictionDAO extends JpaRepository<Prediction , Long>{

    @Modifying
    @Query(value = "DELETE FROM prediction WHERE (idathlete = :idathlete AND idpoweractivity = :idpoweractivity) ;", nativeQuery = true)
    void deleteOnePrediction(Long idathlete, Long idpoweractivity);

    @Query(value = "SELECT * FROM prediction WHERE (idathlete = :idathlete AND idpoweractivity = :idpoweractivity) ;", nativeQuery = true)
    Prediction findOnePrediction(Long idathlete, Long idpoweractivity);

    @Query(value = "SELECT * FROM prediction WHERE (idathlete = :idathlete) ;", nativeQuery = true)
    List<Prediction> findAllPredictionForOneAthlete(Long idathlete);

 //   @Query(value = "SELECT * FROM prediction ORDER BY idpoweractivity DESC LIMIT 1", nativeQuery = true)
 //   @Query(value = "SELECT * FROM (SELECT * FROM prediction ORDER BY idpoweractivity DESC LIMIT 1) AS TMP WHERE (idathlete = :idathlete) ;", nativeQuery = true)
     @Query(value = "SELECT * FROM prediction  WHERE (idathlete = :idathlete) ORDER BY idpoweractivity DESC LIMIT 1 ;", nativeQuery = true)
     Prediction findLastPrediction(Long idathlete);

}