package com.runpowerback.runpowerback;

import static org.assertj.core.api.Assertions.assertThat;


import com.runpowerback.runpowerback.application.service.FromStatisticsToPredictionsService;
import com.runpowerback.runpowerback.domaine.entity.Prediction;

import com.runpowerback.runpowerback.infrastructure.inmemory.PredictionRepositoryInMemoryImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;


public class PredictionTests {

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
    void create_Object_Prediction () {
        logger.info("Prediction Object");

        Prediction prediction  = new Prediction(1L,2L,3L,4.0f,5.0f,"3:40", "4:45", "3:30", "3:10","3:05", "5:00","5:30","4h0m0s"
        ,"5:10","1h50m6s","5:00","50m");

        logger.info(prediction.toString());

        assertThat(1L).isEqualTo(prediction.getId());
        assertThat(2L).isEqualTo(prediction.getIdathlete());
        assertThat(3L).isEqualTo(prediction.getIdpoweractivity());
        assertThat(4.0f).isEqualTo(prediction.getPowerOptimal());
        assertThat(5.0f).isEqualTo(prediction.getSpeedOptimal());
    }

    @Test
    void save_Object_With_Repository() {
        logger.info("save Object with Repository");

        PredictionRepositoryInMemoryImpl predictionRepository = new PredictionRepositoryInMemoryImpl();

        Prediction prediction  = new Prediction(2L,2L,3L,4.0f,5.0f,"3:40","4:45","3:30","3:10","3:05", "5:00","5:30","4h0m0s"
        ,"5:10","1h50m6s","5:00","50m");

        Long idReturned = predictionRepository.save(prediction);

        logger.info(idReturned);

        assertThat(2L).isEqualTo(idReturned);
    }

    @Test
    void get_Pace_From_Speed () {
        String paceFromSpeed = FromStatisticsToPredictionsService.getPaceFromSpeed(3.0f);
        logger.info(paceFromSpeed);

        assertThat("5:33").isEqualTo(paceFromSpeed);
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
