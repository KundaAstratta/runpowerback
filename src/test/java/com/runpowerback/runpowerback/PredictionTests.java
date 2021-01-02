package com.runpowerback.runpowerback;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import com.runpowerback.runpowerback.application.FromStatisticsToPredictionsService;
import com.runpowerback.runpowerback.application.PredictionService;
import com.runpowerback.runpowerback.domaine.Athlete;
import com.runpowerback.runpowerback.domaine.AthleteRepository;
import com.runpowerback.runpowerback.domaine.Prediction;
import com.runpowerback.runpowerback.domaine.PredictionRepository;
import com.runpowerback.runpowerback.domaine.StatisticsActivity;
import com.runpowerback.runpowerback.domaine.StatisticsActivityRepository;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class PredictionTests {

    private static final Logger logger = LogManager.getLogger("File");

    @Autowired
    PredictionRepository predictionRepository;

    @Autowired
    PredictionService predictionService;

    @Autowired
    StatisticsActivityRepository statisticsActivityRepository;

    @Autowired
    FromStatisticsToPredictionsService fromStatisticsToPredictionsService;

    @Autowired
    AthleteRepository athleteRepository;

   
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

        assertAll(
            () -> assertEquals(1L, prediction.getId()),
            () -> assertEquals(2L,prediction.getIdathlete()),
            () -> assertEquals(3L,prediction.getIdpoweractivity()),
            () -> assertEquals(4.0f, prediction.getPowerOptimal()),
            () -> assertEquals(5.0f,prediction.getSpeedOptimal())
        );
    }

    @Test
    void save_Object_With_Repository() {
        logger.info("save Object with Repository");

        Prediction prediction  = new Prediction(2L,2L,3L,4.0f,5.0f,"3:40","4:45","3:30","3:10","3:05", "5:00","5:30","4h0m0s"
        ,"5:10","1h50m6s","5:00","50m");

        Long idReturned = predictionRepository.save(prediction);

        logger.info(idReturned);

        assertAll(
            () -> assertEquals(2L,idReturned)
        );

    }

   

    @Test
    void save_Object_With_Service() {
        logger.info("save Object with Service");

        Prediction prediction  = new Prediction(3L,2L,3L,4.0f,5.0f,"3:40", "4:45","3:30","3:10","6:05", "3:00","5:30","4h0m0s"
        ,"5:10","1h50m6s","5:00","50m");

        Long idReturned = predictionService.createOnePrediction(prediction);

        logger.info(idReturned);

        assertAll(
            () -> assertEquals(3L, idReturned),
            () -> assertNotEquals(2L,idReturned)
        );

    }

    @Test
    void find_One_Prediction_With_Service () {
        logger.info("find one Prediction with Service");

        Prediction prediction  = new Prediction(1L,1L,1L,4.0f,5.0f,"3:40", "4:45","3:30","3:10","6:05", "3:00","5:30","4h0m0s"
        ,"5:10","1h50m6s","5:00","50m");
        predictionService.createOnePrediction(prediction);
        prediction  = new Prediction(2L,1L,2L,4.0f,5.0f,"4:40", "5:45","4:30","4:10","7:05", "4:00","6:30","5h0m0s"
        ,"6:10","2h50m6s","6:00","60m");
        predictionService.createOnePrediction(prediction);

        assertAll(
            () -> assertEquals(1L, predictionService.findOnePrediction(1L, 1L).getId()),
            () -> assertEquals(2L, predictionService.findOnePrediction(1L,2L).getId())
        );        
    }

    @Test
    void find_All_Predictons_With_Service () {

        Prediction prediction  = new Prediction(1L,1L,1L,4.0f,5.0f,"3:40", "4:45","3:30","3:10","6:05", "3:00","5:30","4h0m0s"
        ,"5:10","1h50m6s","5:00","50m");
        predictionService.createOnePrediction(prediction);
        prediction  = new Prediction(2L,1L,2L,4.0f,5.0f,"4:40", "5:45","4:30","4:10","7:05", "4:00","6:30","5h0m0s"
        ,"6:10","2h50m6s","6:00","60m");
        predictionService.createOnePrediction(prediction);
        prediction  = new Prediction(3L,1L,3L,4.0f,5.0f,"4:50", "5:55","4:40","4:20","7:15", "4:10","6:340","5h10m0s"
        ,"6:20","2h50m6s","6:00","60m");
        predictionService.createOnePrediction(prediction);

        logger.info("All Prediction {}", predictionService.findAllPredictionForOneAthlete(1L));

        assertEquals(3, predictionService.findAllPredictionForOneAthlete(1L).size());

    }


    @Test
    void find_Last_Predicton_With_Service () {

        Prediction prediction  = new Prediction(1L,1L,1L,4.0f,5.0f,"3:40", "4:45","3:30","3:10","6:05", "3:00","5:30","4h0m0s"
        ,"5:10","1h50m6s","5:00","50m");
        predictionService.createOnePrediction(prediction);
        prediction  = new Prediction(2L,1L,2L,4.0f,5.0f,"4:40", "5:45","4:30","4:10","7:05", "4:00","6:30","5h0m0s"
        ,"6:10","2h50m6s","6:00","60m");
        predictionService.createOnePrediction(prediction);
        prediction  = new Prediction(3L,1L,3L,4.0f,5.0f,"4:50", "5:55","4:40","4:20","7:15", "4:10","6:340","5h10m0s"
        ,"6:20","2h50m6s","6:00","60m");
        predictionService.createOnePrediction(prediction);

        logger.info("Last Prediction {}", predictionService.findLastPrediction(1L));

        assertEquals(3L, predictionService.findLastPrediction(1L).getId());

    }

    @Test
    void to_Predictions() {
        StatisticsActivity statisticsActivity = new StatisticsActivity(1L,1L,1L, 0, 180, 20, 0, 0, 0, 0, 0, 0, null, 0, 0, 0, 0);
        statisticsActivityRepository.save(statisticsActivity);
        statisticsActivity = new StatisticsActivity(2L,1L,2L, 0, 185, 25, 0, 0, 0, 0, 0, 0, null, 0, 0, 0, 0);
        statisticsActivityRepository.save(statisticsActivity);
        statisticsActivity = new StatisticsActivity(3L,1L,3L, 0, 183, 21, 0, 0, 0, 0, 0, 0, null, 0, 0, 0, 0);
        statisticsActivityRepository.save(statisticsActivity);
        statisticsActivity = new StatisticsActivity(4L,1L,4L, 0, 189, 25, 0, 0, 0, 0, 0, 0, null, 0, 0, 0, 0);
        statisticsActivityRepository.save(statisticsActivity);
        
        List<StatisticsActivity> statisticsActivityList = statisticsActivityRepository.findAllStatisticsActivityForOneAthlete(1L);

        logger.info(statisticsActivityList.toString());

        Athlete athleteTest = new Athlete(1L, 1L, "name", "surname", 70f, 188f, 110f, 120f, 130f, 140f, 150f, 160f, 170f, 180f, 190f, 200f);
        
        athleteRepository.save(athleteTest);

        fromStatisticsToPredictionsService.toPredictions(statisticsActivityList, 1L);

        Prediction onePrediction = predictionRepository.findOnePrediction(1L,4L);
        logger.info("onePrediction {}" , onePrediction);

        Prediction lastPrediction = predictionRepository.findLastPrediction(1L);
        logger.info("lastPrediction {}" , lastPrediction);


        statisticsActivity = new StatisticsActivity(5L,1L,5L, 0, 183, 28, 0, 0, 0, 0, 0, 0, null, 0, 0, 0, 0);
        statisticsActivityRepository.save(statisticsActivity);
        
        statisticsActivityList = statisticsActivityRepository.findAllStatisticsActivityForOneAthlete(1L);
        logger.info("newStatisticsList {}" , statisticsActivityList.toString());

        fromStatisticsToPredictionsService.toPredictions(statisticsActivityList, 1L);

        onePrediction = predictionRepository.findOnePrediction(1L,5L);
        logger.info("onePrediction with two records {}" , onePrediction);

        Prediction lastEndPrediction = predictionRepository.findLastPrediction(1L);
   //     Long idReturnedLastPrediction = lastPrediction.getIdpoweractivity();
        logger.info("lastPrediction with two records {}" , lastEndPrediction);

        List<Prediction> predictionsList = predictionRepository.findAllPredictionForOneAthlete(1L);
        logger.info("List {} " , predictionsList.toString());

        assertAll(
            () -> assertEquals(5L, lastEndPrediction.getIdpoweractivity()),
            () -> assertEquals("7:10", lastEndPrediction.getPaceEasy()),
            () -> assertEquals("5:43", lastEndPrediction.getPaceThreshold()),
            () -> assertEquals("5:13", lastEndPrediction.getPaceHard()),
            () -> assertEquals("8:10", lastEndPrediction.getPaceMin()),
            () -> assertEquals("4:48", lastEndPrediction.getPaceMax()),
            () -> assertEquals("7:16", lastEndPrediction.getPaceMarathon()),
            () -> assertEquals("5h6m46s", lastEndPrediction.getTimeForMarathon()),
            () -> assertEquals("5:47", lastEndPrediction.getPaceHalfMarathon()),
            () -> assertEquals("2h2m9s", lastEndPrediction.getTimeForHalfMarathon()),
            () -> assertEquals("5:13", lastEndPrediction.getPaceTenKm()),
            () -> assertEquals("57m54s", lastEndPrediction.getTimeForTenKm())

         );

    }

    @Test
    void get_Pace_From_Speed () {
        String paceFromSpeed = FromStatisticsToPredictionsService.getPaceFromSpeed(3.0f);
        logger.info(paceFromSpeed);
        assertEquals("5:33", paceFromSpeed);
    }

    @Test
    void get_Speed_Prediction_From_Distance () {
        float speedMin = 3.5f;
        float speedMax = 4.5f;
        float speedPredictionFromDistanceReachMin = FromStatisticsToPredictionsService.getSpeedPredictionFromDistance(50000f, 4f,speedMin, speedMax);
        logger.info("speedPredictionFromDistanceReaachMin {}", speedPredictionFromDistanceReachMin);
        float speedPredictionFromDistanceReachMax = FromStatisticsToPredictionsService.getSpeedPredictionFromDistance(5000f, 4f, speedMin, speedMax);
        logger.info("speedPredictionFromDistanceReaachMax {}", speedPredictionFromDistanceReachMax);
        assertAll(
            () -> assertEquals(speedMin, speedPredictionFromDistanceReachMin),
            () -> assertEquals(speedMax, speedPredictionFromDistanceReachMax)
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
