package com.runpowerback.runpowerback.domaine.repository;

import com.runpowerback.runpowerback.domaine.entity.ActivityPointOf;

import java.util.List;

public interface ActivityRepository {

    Long save (ActivityPointOf activity);
    List<ActivityPointOf> findAll();
    void deleteAll();

}
