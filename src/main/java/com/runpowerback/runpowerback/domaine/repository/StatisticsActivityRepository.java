package com.runpowerback.runpowerback.domaine.repository;


import com.runpowerback.runpowerback.domaine.entity.StatisticsActivity;

import java.util.List;

public interface StatisticsActivityRepository {

   Long save (StatisticsActivity statisticsActivity);
   StatisticsActivity findOneStatisticsActivity (Long idathlete, Long idpoweractivity);
   void deleteOneStatisticsActivity(Long idathlete, Long idpoweractivity);
   List<StatisticsActivity> findAllStatisticsActivityForOneAthlete (Long idathlete);
   StatisticsActivity findLastStatisticsActivity(Long idathlete);


}
