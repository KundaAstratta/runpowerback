package com.runpowerback.runpowerback.infrastructure.inmemory;

import com.runpowerback.runpowerback.domaine.entity.ActivityPointOf;
import com.runpowerback.runpowerback.domaine.repository.ActivityRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Profile({"in-memory"})
@Repository
public class ActivityInMemoryRepositoryImpl implements ActivityRepository {

    List<ActivityPointOf> activityPointOfList = new ArrayList<>();

    @Override
    public Long save(ActivityPointOf activity) {
        activityPointOfList.add(activity);
        return activityPointOfList.get(activityPointOfList.size()-1).getId();
    }

    @Override
    public List<ActivityPointOf> findAll () {
        return activityPointOfList.stream().collect(Collectors.toList());
    }

    @Override
    public void deleteAll() {
        activityPointOfList.clear();
    }

}
