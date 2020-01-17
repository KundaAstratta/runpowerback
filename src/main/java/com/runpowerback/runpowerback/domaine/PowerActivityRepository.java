package com.runpowerback.runpowerback.domaine;

import java.util.List;

public interface PowerActivityRepository {

    Long save (PowerActivity powerActivity);
    List<PowerActivity> findAll();

}
