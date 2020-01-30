package com.runpowerback.runpowerback.domaine;

import java.util.List;

public interface PowerActivityRepository {

    Long save (PowerActivity powerActivity);
    List<PowerActivity> findAll();
    void deleteAll();
    void deleteOnePowerActivity(Long idathlete, Long idpoweractivity);
    List<PowerActivity> findOnePowerActivity(Long idathlete, Long idpoweractivity);
}
