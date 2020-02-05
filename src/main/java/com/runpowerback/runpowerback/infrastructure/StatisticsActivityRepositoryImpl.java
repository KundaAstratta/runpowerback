package com.runpowerback.runpowerback.infrastructure;

import com.runpowerback.runpowerback.domaine.StatisticsActivity;
import com.runpowerback.runpowerback.domaine.StatisticsActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StatisticsActivityRepositoryImpl implements StatisticsActivityRepository {

    @Autowired
    StatisticsActivityDAO statisticsActivityDAO;

    @Override
    public Long save(StatisticsActivity statisticsActivity) {
        this.statisticsActivityDAO.save(statisticsActivity);
        return statisticsActivity.getId();
    }

    @Override
    public StatisticsActivity findOneStatisticsActivity(Long idathlete, Long idpoweractivity) {
        return this.statisticsActivityDAO.findOneStatisticsActivity(idathlete, idpoweractivity);

    }

}
