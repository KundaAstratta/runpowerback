package com.runpowerback.runpowerback;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.concurrent.ExecutionException;

import com.runpowerback.runpowerback.application.service.FromStatisticsToPredictionsService;
import com.runpowerback.runpowerback.application.service.PredictionService;
import com.runpowerback.runpowerback.domaine.entity.Athlete;
import com.runpowerback.runpowerback.domaine.repository.AthleteRepository;
import com.runpowerback.runpowerback.domaine.entity.Prediction;
import com.runpowerback.runpowerback.domaine.repository.PredictionRepository;
import com.runpowerback.runpowerback.domaine.entity.StatisticsActivity;
import com.runpowerback.runpowerback.domaine.repository.StatisticsActivityRepository;

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

        assertThat(1L).isEqualTo(prediction.getId());
        assertThat(2L).isEqualTo(prediction.getIdathlete());
        assertThat(3L).isEqualTo(prediction.getIdpoweractivity());
        assertThat(4.0f).isEqualTo(prediction.getPowerOptimal());
        assertThat(5.0f).isEqualTo(prediction.getSpeedOptimal());
    }

    @Test
    void save_Object_With_Repository() {
        logger.info("save Object with Repository");

        Prediction prediction  = new Prediction(2L,2L,3L,4.0f,5.0f,"3:40","4:45","3:30","3:10","3:05", "5:00","5:30","4h0m0s"
        ,"5:10","1h50m6s","5:00","50m");

        Long idReturned = predictionRepository.save(prediction);

        logger.info(idReturned);

        assertThat(2L).isEqualTo(idReturned);
    }

    @Test
    void save_Object_With_Service() {
        logger.info("save Object with Service");

        Prediction prediction  = new Prediction(3L,2L,3L,4.0f,
                5.0f,"3:40", "4:45","3:30","3:10",
                "6:05", "3:00","5:30","4h0m0s",
                "5:10","1h50m6s","5:00","50m");

        Long idReturned = predictionService.createOnePrediction(prediction);

        logger.info(idReturned);

        assertThat(3L).isEqualTo(idReturned);
        assertThat(4L).isNotEqualTo(idReturned);
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

        assertThat(1L).isEqualTo(predictionService.findOnePrediction(1L, 1L).getId());
        assertThat(2L).isEqualTo(predictionService.findOnePrediction(1L,2L).getId());
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

        assertThat(3).isEqualTo(predictionService.findAllPredictionForOneAthlete(1L).size());
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

        assertThat(3L).isEqualTo(predictionService.findLastPrediction(1L).getId());
    }

    @Test
    void to_Predictions() throws ExecutionException, InterruptedException {
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
        logger.info("lastPrediction with two records {}" , lastEndPrediction);

        List<Prediction> predictionsList = predictionRepository.findAllPredictionForOneAthlete(1L);
        logger.info("List {} " , predictionsList.toString());

        assertThat(5L).isEqualTo(lastEndPrediction.getIdpoweractivity());
        assertThat("7:10").isEqualTo(lastEndPrediction.getPaceEasy());
        assertThat("5:43").isEqualTo(lastEndPrediction.getPaceThreshold());
        assertThat("5:13").isEqualTo(lastEndPrediction.getPaceHard());
        assertThat("8:10").isEqualTo(lastEndPrediction.getPaceMin());
        assertThat("4:48").isEqualTo(lastEndPrediction.getPaceMax());
        assertThat("7:16").isEqualTo(lastEndPrediction.getPaceMarathon());
        assertThat("5h6m46s").isEqualTo(lastEndPrediction.getTimeForMarathon());
        assertThat("5:47").isEqualTo(lastEndPrediction.getPaceHalfMarathon());
        assertThat("2h2m9s").isEqualTo(lastEndPrediction.getTimeForHalfMarathon());
        assertThat("5:13").isEqualTo(lastEndPrediction.getPaceTenKm());
        assertThat("52m18s").isEqualTo(lastEndPrediction.getTimeForTenKm());
    }

    @Test
    void get_Pace_From_Speed () {
        String paceFromSpeed = FromStatisticsToPredictionsService.getPaceFromSpeed(3.0f);
        logger.info(paceFromSpeed);

        assertThat("5:33").isEqualTo(paceFromSpeed);
    }

    @Test
    void get_Speed_Prediction_From_Distance () {
        float speedMin = 3.5f;
        float speedMax = 4.5f;
        float speedPredictionFromDistanceReachMin = FromStatisticsToPredictionsService.getSpeedPredictionFromDistance(50000f, 4f,speedMin, speedMax);
        logger.info("speedPredictionFromDistanceReaachMin {}", speedPredictionFromDistanceReachMin);
        float speedPredictionFromDistanceReachMax = FromStatisticsToPredictionsService.getSpeedPredictionFromDistance(5000f, 4f, speedMin, speedMax);
        logger.info("speedPredictionFromDistanceReaachMax {}", speedPredictionFromDistanceReachMax);

        assertThat(speedMin).isEqualTo(speedPredictionFromDistanceReachMin);
        assertThat(speedMax).isEqualTo(speedPredictionFromDistanceReachMax);
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
