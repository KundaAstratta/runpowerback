package com.runpowerback.runpowerback;

import com.runpowerback.runpowerback.application.service.FromActivityToPowerActivityService;
import com.runpowerback.runpowerback.domaine.entity.ExternalCondition;
import com.runpowerback.runpowerback.domaine.entity.PressureSaturation;
import com.runpowerback.runpowerback.infrastructure.inmemory.ExternalConditionInMemoryRepositoryImpl;
import com.runpowerback.runpowerback.infrastructure.inmemory.PressureSaturationInMemoryRepositoryImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculateMassVolumicTests {

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
    void calculate_massVolumic_with_one_PressureSaturation_for_one_ExternalCondition () {
        logger.info("Initiate pressure saturation table...");
        PressureSaturationInMemoryRepositoryImpl pressureSaturationRepository = new PressureSaturationInMemoryRepositoryImpl();
        pressureSaturationRepository.save(new PressureSaturation(1L, 18, 2063));

        logger.info("External condition for one day");
        ExternalConditionInMemoryRepositoryImpl externalConditionRepository = new ExternalConditionInMemoryRepositoryImpl();
        externalConditionRepository.save(new ExternalCondition(1L,1l,1L,100000,18,70,10));

        float temperature = externalConditionRepository.findOneExternalCondition(1L,1L).getTemperature();
        float temperatureKelvin = temperature + 273.15f;
        logger.info("temperature Kelvin " + temperatureKelvin);

        float pressureSaturation = pressureSaturationRepository.findOnePressureSaturation(temperature).getPressure();
        logger.info("pressure Saturation " + pressureSaturation);

        float percentHumidity = externalConditionRepository.findOneExternalCondition(1l,1L).getHumidity();
        logger.info("humidty " + percentHumidity);

        float pressureATM = externalConditionRepository.findOneExternalCondition(1l,1L).getPressureatm();
        logger.info("pressure atm " + pressureATM);

        logger.info("calculate ...");
        float massVolumic;

        float Rs = 287.058f;
        massVolumic =  (1.0f - (0.3783f * (percentHumidity / 100)* pressureSaturation) / pressureATM) * pressureATM / (Rs * temperatureKelvin);

        logger.info("mass Volumic " + massVolumic);

        FromActivityToPowerActivityService fromActivityToPowerActivityService = new FromActivityToPowerActivityService();
        float fromActivityToPowerActivityServiceMassVolumic =
                fromActivityToPowerActivityService.toTransformMassVolumic(percentHumidity,pressureSaturation,pressureATM,temperature);

        logger.info("mass Volumic fromActivityToPowerActivityService " + fromActivityToPowerActivityServiceMassVolumic);

        assertThat(massVolumic).isEqualTo(fromActivityToPowerActivityServiceMassVolumic);
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
