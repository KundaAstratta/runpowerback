package com.runpowerback.runpowerback.domaine.repository;

import com.runpowerback.runpowerback.domaine.entity.PowerActivity;

import java.util.List;

public interface PowerActivityRepository {

    Long save (PowerActivity powerActivity);
    List<PowerActivity> findAll();
    void deleteAll();
    void deleteOnePowerActivity(Long idathlete, Long idpoweractivity);
    List<PowerActivity> findOnePowerActivity(Long idathlete, Long idpoweractivity);
    Long findMaxIdPowerActivity(Long idathlete);

}
