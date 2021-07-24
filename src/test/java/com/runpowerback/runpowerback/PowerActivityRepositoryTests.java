package com.runpowerback.runpowerback;

import com.runpowerback.runpowerback.domaine.entity.PowerActivityPointOf;
import com.runpowerback.runpowerback.infrastructure.inmemory.PowerActivityInMemoryRepositoryImpl;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class PowerActivityRepositoryTests {

    @Test
    void createOnePowerActivity() {
        PowerActivityInMemoryRepositoryImpl powerActivityInMemoryRepository = new PowerActivityInMemoryRepositoryImpl();

        assertThat(1L).isEqualTo(powerActivityInMemoryRepository.save(new PowerActivityPointOf(1L,1L,1L,180,3,145,1,6,1)));
    }

    @Test
    void findAllPowerActivityPointOf() {
        PowerActivityInMemoryRepositoryImpl powerActivityInMemoryRepository = new PowerActivityInMemoryRepositoryImpl();

        powerActivityInMemoryRepository.save(new PowerActivityPointOf(1L,1L,1L,180,3,145,1,6,1));
        powerActivityInMemoryRepository.save(new PowerActivityPointOf(2L,1L,1L,185,4,140,2,7,1));
        powerActivityInMemoryRepository.save(new PowerActivityPointOf(3L,1L,1L,175,5,155,3,6,1));

        List<PowerActivityPointOf> powerActivityPointOfList = powerActivityInMemoryRepository.findAll();

        assertThat(1L).isEqualTo(powerActivityPointOfList.get(0).getId());
        assertThat(2L).isEqualTo(powerActivityPointOfList.get(1).getId());
        assertThat(3L).isEqualTo(powerActivityPointOfList.get(2).getId());
    }

    @Test
    void createListThenDeleteAllOfPointsOfPowerActivity() {
        PowerActivityInMemoryRepositoryImpl powerActivityInMemoryRepository = new PowerActivityInMemoryRepositoryImpl();

        powerActivityInMemoryRepository.save(new PowerActivityPointOf(1L,1L,1L,180,3,145,1,6,1));
        powerActivityInMemoryRepository.save(new PowerActivityPointOf(2L,1L,1L,185,4,140,2,7,1));
        powerActivityInMemoryRepository.save(new PowerActivityPointOf(3L,1L,1L,175,5,155,3,6,1));
        powerActivityInMemoryRepository.save(new PowerActivityPointOf(4L,1L,2L,170,5,155,3,6,2));
        powerActivityInMemoryRepository.save(new PowerActivityPointOf(5L,1L,2L,175,5,145,3,7,2));

        List<PowerActivityPointOf> powerActivityPointOfList = powerActivityInMemoryRepository.findAll();

        assertThat(5).isEqualTo(powerActivityPointOfList.size());

        powerActivityInMemoryRepository.deleteAll();;

        powerActivityPointOfList = powerActivityInMemoryRepository.findAll();

        assertThat(0L).isEqualTo(powerActivityPointOfList.size());

    }

    @Test
    void findOnePowerActivityOfAListOfThree() {
        PowerActivityInMemoryRepositoryImpl powerActivityInMemoryRepository = new PowerActivityInMemoryRepositoryImpl();

        powerActivityInMemoryRepository.save(new PowerActivityPointOf(1L,1L,1L,180,3,145,1,6,1));
        powerActivityInMemoryRepository.save(new PowerActivityPointOf(2L,1L,1L,185,4,140,2,7,1));
        powerActivityInMemoryRepository.save(new PowerActivityPointOf(3L,1L,1L,175,5,155,3,6,1));
        powerActivityInMemoryRepository.save(new PowerActivityPointOf(4L,1L,2L,170,5,155,1,6,2));
        powerActivityInMemoryRepository.save(new PowerActivityPointOf(5L,1L,2L,175,5,145,2,7,2));
        powerActivityInMemoryRepository.save(new PowerActivityPointOf(6L,1L,3L,178,5,155,1,6,2));
        powerActivityInMemoryRepository.save(new PowerActivityPointOf(7L,1L,3L,172,3,147,2,7,2));

        assertThat(170f).isEqualTo(powerActivityInMemoryRepository.findOnePowerActivity(1L,2L).get(0).getPower());
        assertThat(175f).isEqualTo(powerActivityInMemoryRepository.findOnePowerActivity(1L,2L).get(1).getPower());

    }

    @Test
    void deleteOnePowerActivityOfAListOfThree () {
        PowerActivityInMemoryRepositoryImpl powerActivityInMemoryRepository = new PowerActivityInMemoryRepositoryImpl();

        powerActivityInMemoryRepository.save(new PowerActivityPointOf(1L,1L,1L,180,3,145,1,6,1));
        powerActivityInMemoryRepository.save(new PowerActivityPointOf(2L,1L,1L,185,4,140,2,7,1));
        powerActivityInMemoryRepository.save(new PowerActivityPointOf(3L,1L,1L,175,5,155,3,6,1));
        powerActivityInMemoryRepository.save(new PowerActivityPointOf(4L,1L,2L,170,5,155,1,6,2));
        powerActivityInMemoryRepository.save(new PowerActivityPointOf(5L,1L,2L,175,5,145,2,7,2));
        powerActivityInMemoryRepository.save(new PowerActivityPointOf(6L,1L,3L,178,5,155,1,6,2));
        powerActivityInMemoryRepository.save(new PowerActivityPointOf(7L,1L,3L,172,3,147,2,7,2));

        assertThat(170f).isEqualTo(powerActivityInMemoryRepository.findOnePowerActivity(1L,2L).get(0).getPower());
        assertThat(175f).isEqualTo(powerActivityInMemoryRepository.findOnePowerActivity(1L,2L).get(1).getPower());

        powerActivityInMemoryRepository.deleteOnePowerActivity(1L,2L);

        assertThat(0).isEqualTo(powerActivityInMemoryRepository.findOnePowerActivity(1L,2L).size());
    }

    @Test
    void findTheMaxIdPowerActivity(){
        PowerActivityInMemoryRepositoryImpl powerActivityInMemoryRepository = new PowerActivityInMemoryRepositoryImpl();

        powerActivityInMemoryRepository.save(new PowerActivityPointOf(1L,1L,1L,180,3,145,1,6,1));
        powerActivityInMemoryRepository.save(new PowerActivityPointOf(2L,1L,1L,185,4,140,2,7,1));
        powerActivityInMemoryRepository.save(new PowerActivityPointOf(3L,1L,1L,175,5,155,3,6,1));
        powerActivityInMemoryRepository.save(new PowerActivityPointOf(4L,2L,4L,170,5,155,1,6,2));
        powerActivityInMemoryRepository.save(new PowerActivityPointOf(5L,2L,4L,175,5,145,2,7,2));
        powerActivityInMemoryRepository.save(new PowerActivityPointOf(6L,1L,3L,178,5,155,1,6,2));
        powerActivityInMemoryRepository.save(new PowerActivityPointOf(7L,1L,3L,172,3,147,2,7,2));

        assertThat(3L).isEqualTo(powerActivityInMemoryRepository.findMaxIdPowerActivity(1L));
    }
 }
