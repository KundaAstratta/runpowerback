package com.runpowerback.runpowerback.domaine.repository;

import com.runpowerback.runpowerback.domaine.entity.PowerActivityPointOf;

import java.util.List;

public interface PowerActivityRepository {

    Long save (PowerActivityPointOf powerActivity);
    List<PowerActivityPointOf> findAll();
    void deleteAll();
    void deleteOnePowerActivity(Long idathlete, Long idpoweractivity);
    List<PowerActivityPointOf> findOnePowerActivity(Long idathlete, Long idpoweractivity);
    Long findMaxIdPowerActivity(Long idathlete);

}
