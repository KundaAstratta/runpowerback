package com.runpowerback.runpowerback.domaine;



public interface StatisticsActivityRepository {

   Long save (StatisticsActivity statisticsActivity);
   StatisticsActivity findOneStatisticsActivity (Long idathlete, Long idpoweractivity);

}
