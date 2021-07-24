package com.runpowerback.runpowerback;

import com.runpowerback.runpowerback.domaine.entity.*;
import com.runpowerback.runpowerback.infrastructure.inmemory.ActivityInMemoryRepositoryImpl;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ActivityRepositoryTests {

   @Test
   void createOneActivity () {
      ActivityInMemoryRepositoryImpl activityInMemoryRepositoryImpl = new ActivityInMemoryRepositoryImpl();

      assertThat(1L).isEqualTo(activityInMemoryRepositoryImpl.save(new ActivityPointOf (1L,48.79152f,2.336916f,51.6f,121,"2020-01-22T05:25:44Z")));

   }

   @Test
   void createTwoActivities () {
      ActivityInMemoryRepositoryImpl activityInMemoryRepositoryImpl = new ActivityInMemoryRepositoryImpl();
      activityInMemoryRepositoryImpl.save( new ActivityPointOf (1L,48.79152f,2.336916f,51.6f,121,"2020-01-22T05:25:44Z"));
      Long IdOfActivity = activityInMemoryRepositoryImpl.save(new ActivityPointOf(2L,48.79155f,2.336947f,51.6f,121,"2020-01-22T05:25:45Z"));

      assertThat(2L).isEqualTo(IdOfActivity);
   }

   @Test
   void ListOfAllPointsOfActivities () {
      ActivityInMemoryRepositoryImpl activityInMemoryRepositoryImpl = new ActivityInMemoryRepositoryImpl();
      activityInMemoryRepositoryImpl.save(new ActivityPointOf (1L,48.79152f,2.336916f,51.6f,121,"2020-01-22T05:25:44Z"));
      activityInMemoryRepositoryImpl.save(new ActivityPointOf(2L,48.79155f,2.336947f,51.6f,121,"2020-01-22T05:25:45Z"));

      List<ActivityPointOf> activityPointOfList = activityInMemoryRepositoryImpl.findAll();

      assertThat(1L).isEqualTo(activityPointOfList.get(0).getId());
      assertThat(2L).isEqualTo(activityPointOfList.get(1).getId());
      assertThat(2).isEqualTo(activityPointOfList.size());
   }

   @Test
   void DeleteListAfterItsCreation() {
      ActivityInMemoryRepositoryImpl activityInMemoryRepositoryImpl = new ActivityInMemoryRepositoryImpl();
      activityInMemoryRepositoryImpl.save(new ActivityPointOf (1L,48.79152f,2.336916f,51.6f,121,"2020-01-22T05:25:44Z"));
      activityInMemoryRepositoryImpl.save(new ActivityPointOf(2L,48.79155f,2.336947f,51.6f,121,"2020-01-22T05:25:45Z"));

      List<ActivityPointOf> activityPointOfList;
      activityPointOfList = activityInMemoryRepositoryImpl.findAll();

      assertThat(2).isEqualTo(activityPointOfList.size());

      activityInMemoryRepositoryImpl.deleteAll();

      activityPointOfList = activityInMemoryRepositoryImpl.findAll();

      assertThat(0).isEqualTo(activityPointOfList.size());
   }

}
