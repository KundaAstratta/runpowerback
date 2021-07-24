package com.runpowerback.runpowerback.infrastructure.crudrepository;

import com.runpowerback.runpowerback.domaine.entity.StatisticsActivity;
import com.runpowerback.runpowerback.domaine.repository.StatisticsActivityRepository;
import com.runpowerback.runpowerback.domaine.exception.ErrorCodes;
import com.runpowerback.runpowerback.domaine.exception.MyProjectException500;
import com.runpowerback.runpowerback.infrastructure.dao.StatisticsActivityDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Profile({"cloud"})
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

    @Override
    public List<StatisticsActivity> findAllStatisticsActivityForOneAthlete(Long idathlete) {
        return this.statisticsActivityDAO.findAllStatisticsActivityForOneAthlete(idathlete).stream().collect(Collectors.toList());
    }

    @Override
    public void deleteOneStatisticsActivity(Long idathlete, Long idpoweractivity) {
        // TODO Auto-generated method stub
        statisticsActivityDAO.deleteOneStatisticsActivity(idathlete, idpoweractivity);
    }

    @Override
    public StatisticsActivity findLastStatisticsActivity(Long idathlete) {
        // TODO Auto-generated method stub
        if (this.statisticsActivityDAO.findLastStatisticsActivity(idathlete) == null) {
            throw new MyProjectException500(ErrorCodes.NOT_FOUND);
        } else {
            return this.statisticsActivityDAO.findLastStatisticsActivity(idathlete);
        }    }

}
