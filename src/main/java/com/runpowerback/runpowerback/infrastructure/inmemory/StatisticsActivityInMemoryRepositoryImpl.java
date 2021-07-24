package com.runpowerback.runpowerback.infrastructure.inmemory;

import com.runpowerback.runpowerback.domaine.entity.StatisticsActivity;
import com.runpowerback.runpowerback.domaine.repository.StatisticsActivityRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Profile({"in-memory"})
@Repository
public class StatisticsActivityInMemoryRepositoryImpl implements StatisticsActivityRepository {

    List<StatisticsActivity> statisticsActivityList = new ArrayList<>();

    @Override
    public Long save(StatisticsActivity statisticsActivity) {
        statisticsActivityList.add(statisticsActivity);
        return statisticsActivityList.get(statisticsActivityList.size()-1).getId();
    }

    @Override
    public StatisticsActivity findOneStatisticsActivity(Long idathlete, Long idpoweractivity) {
        StatisticsActivity statisticsActivityFound  = statisticsActivityList.stream()
                .filter(index -> index.getIdathlete().equals(idathlete) && index.getIdpoweractivity().equals(idpoweractivity))
                .findFirst()
                .orElse(null);

        if (statisticsActivityFound == null) {
            return null;
        } else {
            return statisticsActivityFound;
        }
    }

    @Override
    public List<StatisticsActivity> findAllStatisticsActivityForOneAthlete(Long idathlete) {
        return statisticsActivityList.stream().filter(index -> index.getIdathlete() == idathlete).collect(Collectors.toList());
    }

    @Override
    public StatisticsActivity findLastStatisticsActivity(Long idathlete) {
        List<StatisticsActivity> sortedList = statisticsActivityList.stream()
                .filter(index -> index.getIdathlete().equals(idathlete))
                .sorted(Comparator.comparing(StatisticsActivity::getIdpoweractivity))
                .collect(Collectors.toList());

        return sortedList.size() != 0 ? sortedList.get(sortedList.size() - 1) : null;
    }

    @Override
    public void deleteOneStatisticsActivity(Long idathlete, Long idpoweractivity) {
        StatisticsActivity statisticsActivityFound  = statisticsActivityList.stream()
                .filter(index -> index.getIdathlete().equals(idathlete) && index.getIdpoweractivity().equals(idpoweractivity))
                .findFirst()
                .orElse(null);

        statisticsActivityList.remove(statisticsActivityFound);
    }

}
