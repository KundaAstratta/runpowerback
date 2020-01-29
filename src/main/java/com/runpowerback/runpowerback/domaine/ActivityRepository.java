package com.runpowerback.runpowerback.domaine;

import java.util.List;

public interface ActivityRepository {

    Long save (Activity activity);
    List<Activity> findAll();
    void deleteAll();

}
