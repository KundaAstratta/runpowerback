package com.runpowerback.runpowerback.infrastructure.dao;

import com.runpowerback.runpowerback.domaine.entity.ActivityPointOf;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActivityDAO extends JpaRepository<ActivityPointOf, Long> {

    List<ActivityPointOf> findByOrderByIdAsc();

}
