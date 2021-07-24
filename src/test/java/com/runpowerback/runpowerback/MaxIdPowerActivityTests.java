package com.runpowerback.runpowerback;

import com.runpowerback.runpowerback.domaine.entity.PowerActivityPointOf;
import com.runpowerback.runpowerback.infrastructure.inmemory.PowerActivityInMemoryRepositoryImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;

public class MaxIdPowerActivityTests {

    private static final Logger logger = LogManager.getLogger("File");

    @BeforeAll
    static void setup() {
        logger.info("@BeforeAll - one times before all tests");
    }

    @BeforeEach
    void init() {
        logger.info("@BeforeEach - before each test");
    }

    @Test
    void find_the_max_of_mixed_idpoweractivity () {
        PowerActivityInMemoryRepositoryImpl powerActivityRepository = new PowerActivityInMemoryRepositoryImpl();

        PowerActivityPointOf powerActivity = new PowerActivityPointOf(1L,1L,1L,180,3,145,1,6,1);
        powerActivityRepository.save(powerActivity);
        powerActivity = new PowerActivityPointOf(2L,1L,4L,170,11,141,2,3,2);
        powerActivityRepository.save(powerActivity);
        powerActivity = new PowerActivityPointOf(3L,1L,3L,170,10,143,3,2,3);
        powerActivityRepository.save(powerActivity);
        powerActivity = new PowerActivityPointOf(4L,1L,2L,185,10,142,4,2,4);
        powerActivityRepository.save(powerActivity);

        assertThat(4L).isEqualTo(powerActivityRepository.findMaxIdPowerActivity(1L));
    }


    @AfterEach
    void endoftest() {
        logger.info("@AfterEach - end of test...");
    }

    @AfterAll
    static void done() {
        logger.info("@AfterAll - all tests done");
    }


}
