package com.runpowerback.runpowerback.exposition.controller;

import com.runpowerback.runpowerback.application.service.StatisticsActivityService;
import com.runpowerback.runpowerback.application.dto.statisticsActivity.StatisticsActivityDTO;
import com.runpowerback.runpowerback.application.dto.statisticsActivity.StatisticsActivityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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

    @RequestMapping(method = RequestMethod.DELETE, path = {"/statisticsactivity/delete/athlete/{idathlete}/activity/{idpoweractivity}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOneStatisticsActivity(@PathVariable("idathlete") Long idathlete, @PathVariable("idpoweractivity") Long idpoweractivity ) {
        this.statisticsActivityService.deleteOneStatisticsActivity(idathlete,idpoweractivity);
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/statisticsactivity/last/{idathlete}"})
    public StatisticsActivityDTO findLastStatisticsActivity(@PathVariable("idathlete") Long idathlete) {
        return StatisticsActivityMapper.mapToOneStatisticsActivityDTO(this.statisticsActivityService.findLastStatisticsActivity(idathlete));
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/statisticsactivity/athlete/{idathlete}"})
    public List<StatisticsActivityDTO> findAllStatistcisActivityForOneAthlete(@PathVariable("idathlete") Long idathlete) {
        return StatisticsActivityMapper.mapToListStatisticsActivityDTO(this.statisticsActivityService.findAllStatisticsActivityForOneAthlete(idathlete));
    }

}
