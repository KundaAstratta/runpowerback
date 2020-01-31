package com.runpowerback.runpowerback.infrastructure;

import com.runpowerback.runpowerback.domaine.Activity;
import com.runpowerback.runpowerback.domaine.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ActivityRepositoryImp implements ActivityRepository {

    @Autowired
    ActivityDAO activityDAO;

    @Override
    public Long save(Activity activity) {
     //   ActivityJPA activityJPA = activityDAO.save(new ActivityJPA((activity)));
        this.activityDAO.save(activity);
        return activity.getId();
    }

    @Override
    public List<Activity> findAll () {
    //    return activityDAO.findByOrderByIdAsc().stream().map(ActivityJPA::toActvity).collect(Collectors.toList());
      return  this.activityDAO.findByOrderByIdAsc().stream().collect(Collectors.toList());
    }

    @Override
    public void deleteAll() {
        activityDAO.deleteAll();
    }

}
