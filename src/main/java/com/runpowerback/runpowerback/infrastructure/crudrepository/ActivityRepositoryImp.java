package com.runpowerback.runpowerback.infrastructure.crudrepository;

import com.runpowerback.runpowerback.domaine.entity.ActivityPointOf;
import com.runpowerback.runpowerback.domaine.repository.ActivityRepository;
import com.runpowerback.runpowerback.infrastructure.dao.ActivityDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ActivityRepositoryImp implements ActivityRepository {

    @Autowired
    ActivityDAO activityDAO;

    @Override
    public Long save(ActivityPointOf activity) {
        this.activityDAO.save(activity);
        return activity.getId();
    }

    @Override
    public List<ActivityPointOf> findAll () {
      return  this.activityDAO.findByOrderByIdAsc().stream().collect(Collectors.toList());
    }

    @Override
    public void deleteAll() {
        activityDAO.deleteAll();
    }

}
