package com.runpowerback.runpowerback;

import com.runpowerback.runpowerback.domaine.entity.Prediction;
import com.runpowerback.runpowerback.domaine.exception.MyProjectException500;
import com.runpowerback.runpowerback.infrastructure.inmemory.PredictionRepositoryInMemoryImpl;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PredictionRepositoryTests {

    List<Prediction> predictionList = new ArrayList<>();

    @Test
    void createOnePrediction(){
        PredictionRepositoryInMemoryImpl predictionRepositoryInMemory = new PredictionRepositoryInMemoryImpl();

        assertThat(1L).isEqualTo(predictionRepositoryInMemory.save(new Prediction(1L,1L,1L,4.0f,5.0f,"3:40", "4:45", "3:30", "3:10","3:05", "5:00","5:30","4h0m0s"
                ,"5:10","1h50m6s","5:00","50m")));
    }

    @Test
    void findOnePredictionOfAList() {
        PredictionRepositoryInMemoryImpl predictionRepositoryInMemory = new PredictionRepositoryInMemoryImpl();

        predictionRepositoryInMemory.save(new Prediction(1L,1L,1L,124.0f,5.0f,"3:40", "4:45", "3:30", "3:10","3:05", "5:00","5:30","4h0m0s"
                ,"5:10","1h50m6s","5:00","50m"));
        predictionRepositoryInMemory.save(new Prediction(2L,1L,2L,134.0f,6.0f,"3:45", "4:54", "3:35", "3:15","3:05", "5:00","5:40","4h10m0s"
                ,"5:12","1h54m6s","5:10","51m"));
        predictionRepositoryInMemory.save(new Prediction(3L,1L,3L,144.0f,5.0f,"3:40", "4:45", "3:30", "3:10","3:05", "5:00","5:30","4h0m0s"
                ,"5:10","1h50m6s","5:00","50m"));


        assertThat(134.0f).isEqualTo(predictionRepositoryInMemory.findOnePrediction(1L,2L).getPowerOptimal());
    }

    @Test
    void findAllPredictionsForOneGivenAthlete () {
        PredictionRepositoryInMemoryImpl predictionRepositoryInMemory = new PredictionRepositoryInMemoryImpl();

        predictionRepositoryInMemory.save(new Prediction(1L,1L,1L,124.0f,5.0f,"3:40", "4:45", "3:30", "3:10","3:05", "5:00","5:30","4h0m0s"
                ,"5:10","1h50m6s","5:00","50m"));
        predictionRepositoryInMemory.save(new Prediction(2L,1L,2L,134.0f,6.0f,"3:45", "4:54", "3:35", "3:15","3:05", "5:00","5:40","4h10m0s"
                ,"5:12","1h54m6s","5:10","51m"));
        predictionRepositoryInMemory.save(new Prediction(3L,2L,1L,234.0f,7.0f,"4:45", "5:54", "4:35", "4:15","4:05", "6:00","6:40","5h10m0s"
                ,"5:12","2h54m6s","6:10","41m"));
        predictionRepositoryInMemory.save(new Prediction(4L,2L,2L,244.0f,7.0f,"4:40", "5:45", "4:30", "4:10","4:05", "6:00","6:30","5h0m0s"
                ,"5:10","2h50m6s","6:00","40m"));
        predictionRepositoryInMemory.save(new Prediction(5L,1L,3L,144.0f,5.0f,"3:40", "4:45", "3:30", "3:10","3:05", "5:00","5:30","4h0m0s"
                ,"5:10","1h50m6s","5:00","50m"));

        assertThat(1L).isEqualTo(predictionRepositoryInMemory.findAllPredictionForOneAthlete(1L).get(0).getId());
        assertThat(2L).isEqualTo(predictionRepositoryInMemory.findAllPredictionForOneAthlete(1L).get(1).getId());
        assertThat(5L).isEqualTo(predictionRepositoryInMemory.findAllPredictionForOneAthlete(1L).get(2).getId());
        assertThat(3L).isEqualTo(predictionRepositoryInMemory.findAllPredictionForOneAthlete(2L).get(0).getId());
        assertThat(4L).isEqualTo(predictionRepositoryInMemory.findAllPredictionForOneAthlete(2L).get(1).getId());

    }

    @Test
    void findTheLastPredictionForOneGivenAthlete () {
        PredictionRepositoryInMemoryImpl predictionRepositoryInMemory = new PredictionRepositoryInMemoryImpl();

        predictionRepositoryInMemory.save(new Prediction(1L,1L,1L,124.0f,5.0f,"3:40", "4:45", "3:30", "3:10","3:05", "5:00","5:30","4h0m0s"
                ,"5:10","1h50m6s","5:00","50m"));
        predictionRepositoryInMemory.save(new Prediction(2L,1L,2L,134.0f,6.0f,"3:45", "4:54", "3:35", "3:15","3:05", "5:00","5:40","4h10m0s"
                ,"5:12","1h54m6s","5:10","51m"));
        predictionRepositoryInMemory.save(new Prediction(3L,2L,1L,234.0f,7.0f,"4:45", "5:54", "4:35", "4:15","4:05", "6:00","6:40","5h10m0s"
                ,"5:12","2h54m6s","6:10","41m"));
        predictionRepositoryInMemory.save(new Prediction(4L,2L,2L,244.0f,7.0f,"4:40", "5:45", "4:30", "4:10","4:05", "6:00","6:30","5h0m0s"
                ,"5:10","2h50m6s","6:00","40m"));
        predictionRepositoryInMemory.save(new Prediction(5L,1L,3L,144.0f,5.0f,"3:40", "4:45", "3:30", "3:10","3:05", "5:00","5:30","4h0m0s"
                ,"5:10","1h50m6s","5:00","50m"));

        assertThat(2L).isEqualTo(predictionRepositoryInMemory.findLastPrediction(2L).getIdpoweractivity());
    }

    @Test
    void deleteOnePredictionInAList() {
        PredictionRepositoryInMemoryImpl predictionRepositoryInMemory = new PredictionRepositoryInMemoryImpl();

        predictionRepositoryInMemory.save(new Prediction(1L,1L,1L,124.0f,5.0f,"3:40", "4:45", "3:30", "3:10","3:05", "5:00","5:30","4h0m0s"
                ,"5:10","1h50m6s","5:00","50m"));
        predictionRepositoryInMemory.save(new Prediction(2L,1L,2L,134.0f,6.0f,"3:45", "4:54", "3:35", "3:15","3:05", "5:00","5:40","4h10m0s"
                ,"5:12","1h54m6s","5:10","51m"));
        predictionRepositoryInMemory.save(new Prediction(3L,2L,1L,234.0f,7.0f,"4:45", "5:54", "4:35", "4:15","4:05", "6:00","6:40","5h10m0s"
                ,"5:12","2h54m6s","6:10","41m"));
        predictionRepositoryInMemory.save(new Prediction(4L,2L,2L,244.0f,7.0f,"4:40", "5:45", "4:30", "4:10","4:05", "6:00","6:30","5h0m0s"
                ,"5:10","2h50m6s","6:00","40m"));
        predictionRepositoryInMemory.save(new Prediction(5L,1L,3L,144.0f,5.0f,"3:40", "4:45", "3:30", "3:10","3:05", "5:00","5:30","4h0m0s"
                ,"5:10","1h50m6s","5:00","50m"));

        assertThat(244.0f).isEqualTo(predictionRepositoryInMemory.findOnePrediction(2L,2L).getPowerOptimal());

        predictionRepositoryInMemory.deleteOnePrediction(2L,2L);

        try {
            predictionRepositoryInMemory.findOnePrediction(2l, 2L);
        } catch (MyProjectException500 myProjectException500) {
            assertThat("[ERR_0001]").isEqualTo(myProjectException500.getCodeErreurs().toString());
        }

    }

}
