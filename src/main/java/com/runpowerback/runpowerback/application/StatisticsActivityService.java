package com.runpowerback.runpowerback.application;

import com.runpowerback.runpowerback.domaine.StatisticsActivity;
import com.runpowerback.runpowerback.domaine.StatisticsActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

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



}
