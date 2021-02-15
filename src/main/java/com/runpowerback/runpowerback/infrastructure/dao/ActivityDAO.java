package com.runpowerback.runpowerback.infrastructure.dao;

import com.runpowerback.runpowerback.domaine.entity.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActivityDAO extends JpaRepository<Activity, Long> {

    List<Activity> findByOrderByIdAsc();

}
