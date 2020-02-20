package com.runpowerback.runpowerback;

import com.runpowerback.runpowerback.domaine.PressureSaturation;
import com.runpowerback.runpowerback.domaine.PressureSaturationRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PressureSaturationTests {

    private static final Logger logger = LogManager.getLogger("File");

    @Autowired
    PressureSaturationRepository pressureSaturationRepository;

    @BeforeAll
    static void setup() {
        logger.info("@BeforeAll - one times before all tests");
    }

    @BeforeEach
    void init() {
        logger.info("@BeforeEach - before each test");
    }

    @Test
    void found_PressureSaturation_for_one_Temperature () {
        logger.info("Pressure saturation");
        PressureSaturation pressureSaturation = new PressureSaturation(1L,18,2063);
        this.pressureSaturationRepository.save(pressureSaturation);
        logger.info(pressureSaturation);
        float temperature = 18;
        assertAll(
                () -> assertEquals(2063, this.pressureSaturationRepository.findOnePressureSaturation(temperature).getPressure())
        );
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
