package com.runpowerback.runpowerback.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActivityDAO extends JpaRepository<ActivityJPA, Long> {

    List<ActivityJPA> findByOrderByIdAsc();

}
