package com.runpowerback.runpowerback.infrastructure;

import com.runpowerback.runpowerback.domaine.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActivityDAO extends JpaRepository<Activity, Long> {

    List<Activity> findByOrderByIdAsc();

}
