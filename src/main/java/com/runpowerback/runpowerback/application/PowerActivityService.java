package com.runpowerback.runpowerback.application;

import com.runpowerback.runpowerback.domaine.PowerActivity;
import com.runpowerback.runpowerback.domaine.PowerActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PowerActivityService {

    @Autowired
    PowerActivityRepository powerActivityRepository;

    public Long createOnePointOfPowerActivity(PowerActivity powerActivity) {
        return this.powerActivityRepository.save(powerActivity);
    }

    public List<PowerActivity> findOnePowerActivity() {
        return this.powerActivityRepository.findAll();
    }

}
