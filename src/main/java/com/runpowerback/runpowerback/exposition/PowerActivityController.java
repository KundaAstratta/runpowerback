package com.runpowerback.runpowerback.exposition;

import com.runpowerback.runpowerback.application.PowerActivityService;
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
    public List<PowerActivityDTO> findOnePowerActivity() {
        return PowerActivityMapper.mapToOnePowerActivity(this.powerActivityService.findOnePowerActivity());
    }

}
