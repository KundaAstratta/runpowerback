package com.runpowerback.runpowerback.domaine;


import java.util.List;

public interface StatisticsActivityRepository {

   Long save (StatisticsActivity statisticsActivity);
   StatisticsActivity findOneStatisticsActivity (Long idathlete, Long idpoweractivity);
   List<StatisticsActivity> findAllStatisticsActivityForOneAthlete (Long idathlete);

}
