package com.runpowerback.runpowerback.exposition.controller;

import com.runpowerback.runpowerback.domaine.entity.PowerActivityFireBase;
import com.runpowerback.runpowerback.domaine.entity.StatisticsActivityFireBase;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

import com.runpowerback.runpowerback.application.service.FireBaseService;
import com.runpowerback.runpowerback.domaine.entity.PredictionFireBase;


@RestController
public class FireBaseController {
    
 //   @Autowired
 //   FireBaseService fireBaseService;

    private final FireBaseService fireBaseService;

    public FireBaseController(FireBaseService fireBaseService) {
        this.fireBaseService = fireBaseService;
    }

    @PostMapping("/createPrediction")
    public String createPrediction(@RequestBody PredictionFireBase predictionFireBase ) throws InterruptedException, ExecutionException {
        return fireBaseService.savePredictionDetailsToFirebase(predictionFireBase);
    }

    @PostMapping("/createStatistic")
    public String createStatistic(@RequestBody StatisticsActivityFireBase statisticsActivityFireBase) throws  InterruptedException, ExecutionException {
        return fireBaseService.saveStatisticsDetailsToFirebase(statisticsActivityFireBase);
    }

    @PostMapping("/createPowerActivity")
    public String createPowerActivity(@RequestBody PowerActivityFireBase powerActivityFireBase) throws InterruptedException, ExecutionException {
        return fireBaseService.savePowerActivityDetailsToFireBase(powerActivityFireBase);
    }

    
}
