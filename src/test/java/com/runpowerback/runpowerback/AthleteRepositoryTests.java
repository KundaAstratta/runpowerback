package com.runpowerback.runpowerback;

import com.runpowerback.runpowerback.domaine.entity.Athlete;
import com.runpowerback.runpowerback.domaine.exception.MyProjectException500;
import com.runpowerback.runpowerback.infrastructure.inmemory.AthleteInMemoryRepositoryImpl;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class AthleteRepositoryTests {

    @Test
    void createOneAthlete() {
        AthleteInMemoryRepositoryImpl athleteInMemoryRepository = new AthleteInMemoryRepositoryImpl();

        assertThat(1L).isEqualTo(athleteInMemoryRepository.save(new Athlete(1L,1L,"name","surname",72f,188f,120f,130f,131f,140f,141f,150f,151f,160f,161f,170f)));

    }

    @Test
    void createThreeAthetesAndFindTheSecond() {
        AthleteInMemoryRepositoryImpl athleteInMemoryRepository = new AthleteInMemoryRepositoryImpl();

        athleteInMemoryRepository.save(new Athlete(1L,1L,"name1","surname1",72f,188f,120f,130f,131f,140f,141f,150f,151f,160f,161f,170f));
        athleteInMemoryRepository.save(new Athlete(2L,2L,"name2","surname2",92f,190f,125f,135f,136f,145f,146f,155f,156f,165f,166f,175f));
        athleteInMemoryRepository.save(new Athlete(3L,4L,"name3","surname3",52f,189f,129f,139f,140f,146f,150f,160f,161f,170f,171f,180f));

        assertThat("name2").isEqualTo(athleteInMemoryRepository.findOneAthlete(2L).getName());
    }

    @Test
    void threeAthletesAndFindOneById() {
        AthleteInMemoryRepositoryImpl athleteInMemoryRepository = new AthleteInMemoryRepositoryImpl();

        athleteInMemoryRepository.save(new Athlete(1L,1L,"name1","surname1",72f,188f,120f,130f,131f,140f,141f,150f,151f,160f,161f,170f));
        athleteInMemoryRepository.save(new Athlete(2L,2L,"name2","surname2",92f,190f,125f,135f,136f,145f,146f,155f,156f,165f,166f,175f));
        athleteInMemoryRepository.save(new Athlete(3L,4L,"name3","surname3",52f,189f,129f,139f,140f,146f,150f,160f,161f,170f,171f,180f));

        assertThat("name1").isEqualTo(athleteInMemoryRepository.findById(1L).getName());
    }

    @Test
    void deleteOneAthleteOfAList() {
        AthleteInMemoryRepositoryImpl athleteInMemoryRepository = new AthleteInMemoryRepositoryImpl();

        athleteInMemoryRepository.save(new Athlete(1L,1L,"name1","surname1",72f,188f,120f,130f,131f,140f,141f,150f,151f,160f,161f,170f));
        athleteInMemoryRepository.save(new Athlete(2L,2L,"name2","surname2",92f,190f,125f,135f,136f,145f,146f,155f,156f,165f,166f,175f));
        athleteInMemoryRepository.save(new Athlete(3L,4L,"name3","surname3",52f,189f,129f,139f,140f,146f,150f,160f,161f,170f,171f,180f));

        assertThat(1L).isEqualTo(athleteInMemoryRepository.findOneAthlete(1L).getId());

        athleteInMemoryRepository.deleteOneAthlete(1L);

        try {
           athleteInMemoryRepository.findOneAthlete(1L);
        } catch (MyProjectException500 exception500)  {
            assertThat("[ERR_0001]").isEqualTo(exception500.getCodeErreurs().toString());
        }

    }


}
