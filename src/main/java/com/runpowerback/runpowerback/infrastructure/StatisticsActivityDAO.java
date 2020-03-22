package com.runpowerback.runpowerback.infrastructure;

import com.runpowerback.runpowerback.domaine.StatisticsActivity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StatisticsActivityDAO extends JpaRepository<StatisticsActivity, Long> {

   @Query(value = "SELECT * FROM statisticsactivity WHERE (idathlete = :idathlete AND idpoweractivity = :idpoweractivity) ;", nativeQuery = true)
   StatisticsActivity findOneStatisticsActivity(Long idathlete, Long idpoweractivity);

   @Query(value = "SELECT * FROM statisticsactivity WHERE (idathlete = :idathlete) ;", nativeQuery = true)
   List<StatisticsActivity> findAllStatisticsActivityForOneAthlete(Long idathlete);

}
