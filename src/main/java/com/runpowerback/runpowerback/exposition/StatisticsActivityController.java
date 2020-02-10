package com.runpowerback.runpowerback.exposition;

import com.runpowerback.runpowerback.application.StatisticsActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class StatisticsActivityController {

    @Autowired
    StatisticsActivityService statisticsActivityService;

    @RequestMapping(method = RequestMethod.POST, path = {"/statisticsactivity"})
    @ResponseStatus(HttpStatus.CREATED)
    public Long createOneStatisticsActivity(@Valid @RequestBody StatisticsActivityDTO statisticsActivityDTO) {
        return this.statisticsActivityService.createOneStatisticsActivity(StatisticsActivityMapper.mapToOneStatisticsActivity(statisticsActivityDTO));
    }

   @RequestMapping(method = RequestMethod.GET, path = {"/statisticsactivity/athlete/{idathlete}/activity/{idpoweractivity}"})
    public StatisticsActivityDTO findOneStatisticsActivity(@PathVariable("idathlete") Long idathlete, @PathVariable("idpoweractivity") Long idpoweractivity ) {
       return StatisticsActivityMapper.mapToOneStatisticsActivityDTO(this.statisticsActivityService.findOneStatisticsActivity(idathlete,idpoweractivity));
    }

}
