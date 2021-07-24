package com.runpowerback.runpowerback;

import com.runpowerback.runpowerback.domaine.entity.PressureSaturation;
import com.runpowerback.runpowerback.infrastructure.inmemory.PressureSaturationInMemoryRepositoryImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;


import static org.assertj.core.api.Assertions.assertThat;


public class PressureSaturationTests {

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
    void found_PressureSaturation_for_one_Temperature () {
        logger.info("Pressure saturation");
        PressureSaturation pressureSaturation = new PressureSaturation(1L,18,2063);
        PressureSaturationInMemoryRepositoryImpl pressureSaturationRepository = new PressureSaturationInMemoryRepositoryImpl();
        pressureSaturationRepository.save(pressureSaturation);
        logger.info(pressureSaturation);
        float temperature = 18;

        float pressureSaturationValue = toBuckEquation(temperature);
        logger.info("pressure Saturation Value : {}", pressureSaturationValue);

        assertThat(2063.0).isEqualTo(pressureSaturationRepository.findOnePressureSaturation(temperature).getPressure());
   }


    @Test
    void found_PressureSaturation_for_other_Temperature () {
        logger.info("Pressure saturation");
        PressureSaturation pressureSaturation = new PressureSaturation(1L,-7,370);
        PressureSaturationInMemoryRepositoryImpl pressureSaturationRepository = new PressureSaturationInMemoryRepositoryImpl();
        pressureSaturationRepository.save(pressureSaturation);
        logger.info(pressureSaturation);
        float temperature = -7;

        float pressureSaturationValue = toBuckEquation(temperature);
        logger.info("pressure Saturation Value : {}", pressureSaturationValue);

        assertThat(370.0).isEqualTo(pressureSaturationRepository.findOnePressureSaturation(temperature).getPressure());
  }

    @AfterEach
    void endoftest() {
        logger.info("@AfterEach - end of test...");
    }

    @AfterAll
    static void done() {
        logger.info("@AfterAll - all tests done");
    }

    // Same as in FromActivityToPowerActivityService
    public float toBuckEquation (float temperature) {
        double forBuckEquation = (18.878f - (temperature / 234.5f)) * (temperature / (257.14f + temperature));
        return (float)(611.21f * Math.exp(forBuckEquation));
    }

}
