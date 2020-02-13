package com.runpowerback.runpowerback.infrastructure;

import com.runpowerback.runpowerback.domaine.StatisticsActivity;
import com.runpowerback.runpowerback.domaine.StatisticsActivityRepository;
import com.runpowerback.runpowerback.domaine.exception.ErrorCodes;
import com.runpowerback.runpowerback.domaine.exception.MyProjectException500;
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
        if (this.statisticsActivityDAO.findOneStatisticsActivity(idathlete,idpoweractivity) == null) {
             throw new MyProjectException500(ErrorCodes.NOT_FOUND);
        } else {
            return this.statisticsActivityDAO.findOneStatisticsActivity(idathlete, idpoweractivity);
        }
    }



}
