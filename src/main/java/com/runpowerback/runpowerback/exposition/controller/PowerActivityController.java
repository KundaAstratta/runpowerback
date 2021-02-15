package com.runpowerback.runpowerback.exposition.controller;

import com.runpowerback.runpowerback.application.service.PowerActivityService;
import com.runpowerback.runpowerback.application.dto.powerActivity.PowerActivityDTO;
import com.runpowerback.runpowerback.application.dto.powerActivity.PowerActivityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class PowerActivityController {

    @Autowired
    PowerActivityService powerActivityService;

    @RequestMapping(method = RequestMethod.POST, path = {"/poweractivity"})
    @ResponseStatus(HttpStatus.CREATED)
    public Long createOnePointOfPowerActivity(@Valid @RequestBody PowerActivityDTO powerActivityDTO) {
        return this.powerActivityService.createOnePointOfPowerActivity(PowerActivityMapper.mapToOnePointOfPowerActivity(powerActivityDTO));
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/poweractivity"})
    public List<PowerActivityDTO> findAll() {
        return PowerActivityMapper.mapToOnePowerActivity(this.powerActivityService.findAll());
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/poweractivity/athlete/{idathlete}/activity/{idpoweractivity}"})
    public List<PowerActivityDTO> findOnePowerActivity(@PathVariable("idathlete") Long idathlete, @PathVariable("idpoweractivity") Long idpoweractivity ) {
        return PowerActivityMapper.mapToOnePowerActivity(this.powerActivityService.findOnePowerActivity(idathlete,idpoweractivity));
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/fromPowerActivityToStatistics/athlete/{idathlete}/activity/{idpoweractivity}"})
    public void fromPowerActivityToStatistics(@PathVariable("idathlete") Long idathlete, @PathVariable("idpoweractivity") Long idpoweractivity) {
        this.powerActivityService.fromPowerActivityToStatistics(idathlete,idpoweractivity);
    }


    @RequestMapping(method = RequestMethod.DELETE, path = {"/poweractivity"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAll() {
        this.powerActivityService.deleteAll();
    }

    @RequestMapping(method = RequestMethod.DELETE, path = {"/poweractivity/delete/athlete/{idathlete}/activity/{idpoweractivity}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOnePowerActivity(@PathVariable("idathlete") Long idathlete, @PathVariable("idpoweractivity") Long idpoweractivity ) {
        this.powerActivityService.deleteOnePowerActivity(idathlete,idpoweractivity);
    }

    @RequestMapping(method = RequestMethod.GET, path = ("/maxidpoweractivity/athlete/{idathlete}"))
    public Long findMaxIdPowerActivity(@PathVariable("idathlete") Long idathlete) {
        return this.powerActivityService.findMaxIdPowerActivity(idathlete);
    }

}
