package com.runpowerback.runpowerback;

import com.runpowerback.runpowerback.application.service.FromActivityToPowerActivityService;
import com.runpowerback.runpowerback.domaine.entity.ExternalCondition;
import com.runpowerback.runpowerback.domaine.repository.ExternalConditionRepository;
import com.runpowerback.runpowerback.domaine.entity.PressureSaturation;
import com.runpowerback.runpowerback.domaine.repository.PressureSaturationRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class CalculateMassVolumicTests {

    private static final Logger logger = LogManager.getLogger("File");

    @Autowired
    ExternalConditionRepository externalConditionRepository;

    @Autowired
    PressureSaturationRepository pressureSaturationRepository;

    @Autowired
    FromActivityToPowerActivityService fromActivityToPowerActivityService;

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
        this.pressureSaturationRepository.save(new PressureSaturation(1L, 18, 2063));

        logger.info("External condition for one day");
        this.externalConditionRepository.save(new ExternalCondition(1L,1l,1L,100000,18,70,10));

        float temperature = this.externalConditionRepository.findOneExternalCondition(1L,1L).getTemperature();
        float temperatureKelvin = temperature + 273.15f;
        logger.info("temperature Kelvin " + temperatureKelvin);

        float pressureSaturation = this.pressureSaturationRepository.findOnePressureSaturation(temperature).getPressure();
        logger.info("pressure Saturation " + pressureSaturation);

        float percentHumidity = this.externalConditionRepository.findOneExternalCondition(1l,1L).getHumidity();
        logger.info("humidty " + percentHumidity);

        float pressureATM = this.externalConditionRepository.findOneExternalCondition(1l,1L).getPressureatm();
        logger.info("pressure atm " + pressureATM);

        logger.info("calculate ...");
        float massVolumic;

        float Rs = 287.058f;
        massVolumic =  (1.0f - (0.3783f * (percentHumidity / 100)* pressureSaturation) / pressureATM) * pressureATM / (Rs * temperatureKelvin);

        logger.info("mass Volumic " + massVolumic);

        float fromActivityToPowerActivityServiceMassVolumic =
                this.fromActivityToPowerActivityService.toTransformMassVolumic(percentHumidity,pressureSaturation,pressureATM,temperature);

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
