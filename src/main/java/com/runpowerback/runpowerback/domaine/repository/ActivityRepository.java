package com.runpowerback.runpowerback.domaine.repository;

import com.runpowerback.runpowerback.domaine.entity.Activity;

import java.util.List;

public interface ActivityRepository {

    Long save (Activity activity);
    List<Activity> findAll();
    void deleteAll();

}
