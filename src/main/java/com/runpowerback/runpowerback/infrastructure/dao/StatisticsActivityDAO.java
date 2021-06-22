package com.runpowerback.runpowerback.infrastructure.dao;

import com.runpowerback.runpowerback.domaine.entity.StatisticsActivity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StatisticsActivityDAO extends JpaRepository<StatisticsActivity, Long> {

   @Modifying
   @Query(value = "DELETE FROM statisticsactivity WHERE (idathlete = :idathlete AND idpoweractivity = :idpoweractivity) ;", nativeQuery = true)
   void deleteOneStatisticsActivity(Long idathlete, Long idpoweractivity);
   
   @Query(value = "SELECT * FROM statisticsactivity WHERE (idathlete = :idathlete AND idpoweractivity = :idpoweractivity) ;", nativeQuery = true)
   StatisticsActivity findOneStatisticsActivity(Long idathlete, Long idpoweractivity);

   @Query(value = "SELECT * FROM statisticsactivity WHERE (idathlete = :idathlete) ORDER BY idpoweractivity DESC;", nativeQuery = true)
   List<StatisticsActivity> findAllStatisticsActivityForOneAthlete(Long idathlete);

   @Query(value = "SELECT * FROM statisticsactivity WHERE (idathlete = :idathlete) ORDER BY idpoweractivity DESC LIMIT 1 ;", nativeQuery = true)
   StatisticsActivity findLastStatisticsActivity(Long idathlete);


}
