package com.runpowerback.runpowerback.application.service;

import com.runpowerback.runpowerback.domaine.entity.StatisticsActivity;
import com.runpowerback.runpowerback.domaine.repository.StatisticsActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class StatisticsActivityService {

    @Autowired
    StatisticsActivityRepository statisticsActivityRepository;

    public Long createOneStatisticsActivity(StatisticsActivity statisticsActivity) {
       return this.statisticsActivityRepository.save(statisticsActivity);
    }

    public StatisticsActivity findOneStatisticsActivity (Long idathlete, Long idpoweractivity) {
        return this.statisticsActivityRepository.findOneStatisticsActivity(idathlete, idpoweractivity);
    }

    public void deleteOneStatisticsActivity(Long idathlete, Long idpoweractivity) {
        this.statisticsActivityRepository.deleteOneStatisticsActivity(idathlete,idpoweractivity);
    }

    public List<StatisticsActivity> findAllStatisticsActivityForOneAthlete (Long idathlete) {
        return this.statisticsActivityRepository.findAllStatisticsActivityForOneAthlete(idathlete);
    }

    public StatisticsActivity findLastStatisticsActivity(Long idathlete) {
        return this.statisticsActivityRepository.findLastStatisticsActivity(idathlete);
    }

}
