package com.runpowerback.runpowerback;

import com.runpowerback.runpowerback.application.FromWeatherAPItoExternalConditionService;
import com.runpowerback.runpowerback.domaine.PressureSaturation;
import com.runpowerback.runpowerback.domaine.PressureSaturationRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PressureSaturationTests {

    private static final Logger logger = LogManager.getLogger("File");

    @Autowired
    PressureSaturationRepository pressureSaturationRepository;

    @Autowired
    FromWeatherAPItoExternalConditionService fromWeatherAPItoExternalConditionService;

    @Value("${runpower.url.weather}")
    private String urlWeatherPath;

    @Value("${runpower.url.weather.key}")
    private String urlWeatherPathKey;

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

        float pressureSaturationValue = toBuckEquation(temperature);
        logger.info("pressure Saturation Value : {}", pressureSaturationValue);

        assertAll(
                () -> assertEquals(2063, this.pressureSaturationRepository.findOnePressureSaturation(temperature).getPressure())
        );
    }


    @Test
    void found_PressureSaturation_for_other_Temperature () {
        logger.info("Pressure saturation");
        PressureSaturation pressureSaturation = new PressureSaturation(1L,-7,370);
        this.pressureSaturationRepository.save(pressureSaturation);
        logger.info(pressureSaturation);
        float temperature = -7;

        float pressureSaturationValue = toBuckEquation(temperature);
        logger.info("pressure Saturation Value : {}", pressureSaturationValue);

        assertAll(
                () -> assertEquals(370, this.pressureSaturationRepository.findOnePressureSaturation(temperature).getPressure())
        );
    }

    @Test
    void call_the_weather_api_with_the_service () {
        float latitude = 48.7915210f;
        float longitude = 2.3369160f;
        fromWeatherAPItoExternalConditionService.toCallWeatherAPI(latitude,longitude);
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
