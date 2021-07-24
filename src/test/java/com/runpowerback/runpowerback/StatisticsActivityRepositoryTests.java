package com.runpowerback.runpowerback;

import com.runpowerback.runpowerback.domaine.entity.StatisticsActivity;

import com.runpowerback.runpowerback.domaine.exception.MyProjectException500;
import com.runpowerback.runpowerback.infrastructure.inmemory.StatisticsActivityInMemoryRepositoryImpl;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StatisticsActivityRepositoryTests {

    @Test
    void createOneStatisticsActivity() {
        StatisticsActivityInMemoryRepositoryImpl statisticsActivityRepository = new StatisticsActivityInMemoryRepositoryImpl();

        assertThat(1L).isEqualTo(statisticsActivityRepository.save(new StatisticsActivity(1L,1L,1L, 180, 180, 20, 180, 10, 1300, 0, 10, 0, null, 140, 20, 150, 10)));
    }

    @Test
    void findOneStatisticsActivityOfAList() {
        StatisticsActivityInMemoryRepositoryImpl statisticsActivityRepository = new StatisticsActivityInMemoryRepositoryImpl();

        statisticsActivityRepository.save(new StatisticsActivity(1L,1L,1L, 180, 180, 20, 180, 10, 1300, 0, 10, 0, null, 140, 20, 150, 10));
        statisticsActivityRepository.save(new StatisticsActivity(2L,1L,2L, 170, 170, 20, 170, 1300, 10, 10, 10, 0, null, 140, 20, 150, 10));
        statisticsActivityRepository.save(new StatisticsActivity(3L,1L,3L, 160, 160, 20, 150, 10, 10, 1000, 10, 0, null, 140, 20, 150, 10));

        assertThat(170f).isEqualTo(statisticsActivityRepository.findOneStatisticsActivity(1L,2L).getPowermedian());
    }

    @Test
    void findAllStatisticsActivityForOneGivenAthlete() {
        StatisticsActivityInMemoryRepositoryImpl statisticsActivityRepository = new StatisticsActivityInMemoryRepositoryImpl();

        statisticsActivityRepository.save(new StatisticsActivity(1L,1L,1L, 180, 180, 20, 180, 10, 1300, 0, 10, 0, null, 140, 20, 150, 10));
        statisticsActivityRepository.save(new StatisticsActivity(2L,1L,2L, 170, 170, 20, 170, 1300, 10, 10, 10, 0, null, 140, 20, 150, 10));
        statisticsActivityRepository.save(new StatisticsActivity(3L,1L,3L, 165, 160, 20, 150, 10, 10, 1000, 10, 0, null, 140, 20, 150, 10));
        statisticsActivityRepository.save(new StatisticsActivity(4L,2L,1L, 185, 180, 20, 180, 10, 1300, 0, 10, 0, null, 140, 20, 150, 10));
        statisticsActivityRepository.save(new StatisticsActivity(5L,2L,2L, 170, 170, 20, 170, 1300, 10, 10, 10, 0, null, 140, 20, 150, 10));
        statisticsActivityRepository.save(new StatisticsActivity(6L,1L,4L, 164, 160, 20, 150, 10, 10, 1000, 10, 0, null, 140, 20, 150, 10));

        assertThat(180f).isEqualTo(statisticsActivityRepository.findAllStatisticsActivityForOneAthlete(2L).get(0).getPowermedian());
        assertThat(170f).isEqualTo(statisticsActivityRepository.findAllStatisticsActivityForOneAthlete(2L).get(1).getPowermedian());

    }

    @Test
    void findTheLastStatisticsActivityForOneGiveAthlete() {
        StatisticsActivityInMemoryRepositoryImpl statisticsActivityRepository = new StatisticsActivityInMemoryRepositoryImpl();

        statisticsActivityRepository.save(new StatisticsActivity(1L,1L,1L, 180, 180, 20, 180, 10, 1300, 0, 10, 0, null, 140, 20, 150, 10));
        statisticsActivityRepository.save(new StatisticsActivity(2L,1L,2L, 170, 170, 20, 170, 1300, 10, 10, 10, 0, null, 140, 20, 150, 10));
        statisticsActivityRepository.save(new StatisticsActivity(3L,1L,3L, 165, 160, 20, 150, 10, 10, 1000, 10, 0, null, 140, 20, 150, 10));
        statisticsActivityRepository.save(new StatisticsActivity(4L,2L,1L, 185, 180, 20, 180, 10, 1300, 0, 10, 0, null, 140, 20, 150, 10));
        statisticsActivityRepository.save(new StatisticsActivity(5L,2L,2L, 170, 170, 20, 170, 1300, 10, 10, 10, 0, null, 140, 20, 150, 10));
        statisticsActivityRepository.save(new StatisticsActivity(6L,1L,4L, 164, 160, 20, 150, 10, 10, 1000, 10, 0, null, 140, 20, 150, 10));

        assertThat(4L).isEqualTo(statisticsActivityRepository.findLastStatisticsActivity(1L).getIdpoweractivity());
    }

    @Test
    void deleteOneStatisticsActivityInAList() {
        StatisticsActivityInMemoryRepositoryImpl statisticsActivityRepository = new StatisticsActivityInMemoryRepositoryImpl();

        statisticsActivityRepository.save(new StatisticsActivity(1L,1L,1L, 180, 180, 20, 180, 10, 1300, 0, 10, 0, null, 140, 20, 150, 10));
        statisticsActivityRepository.save(new StatisticsActivity(2L,1L,2L, 170, 170, 20, 170, 1300, 10, 10, 10, 0, null, 140, 20, 150, 10));
        statisticsActivityRepository.save(new StatisticsActivity(3L,1L,3L, 165, 160, 20, 150, 10, 10, 1000, 10, 0, null, 140, 20, 150, 10));
        statisticsActivityRepository.save(new StatisticsActivity(4L,2L,1L, 185, 180, 20, 180, 10, 1300, 0, 10, 0, null, 140, 20, 150, 10));
        statisticsActivityRepository.save(new StatisticsActivity(5L,2L,2L, 170, 170, 20, 170, 1300, 10, 10, 10, 0, null, 140, 20, 150, 10));
        statisticsActivityRepository.save(new StatisticsActivity(6L,1L,4L, 164, 160, 20, 150, 10, 10, 1000, 10, 0, null, 140, 20, 150, 10));

        assertThat(170f).isEqualTo(statisticsActivityRepository.findOneStatisticsActivity(2L,2L).getPowermedian());

        statisticsActivityRepository.deleteOneStatisticsActivity(2L,2L);

        try {
            statisticsActivityRepository.findOneStatisticsActivity(2l, 2L);
        } catch (MyProjectException500 myProjectException500) {
            assertThat("[ERR_0001]").isEqualTo(myProjectException500.getCodeErreurs().toString());
        }

    }

}
