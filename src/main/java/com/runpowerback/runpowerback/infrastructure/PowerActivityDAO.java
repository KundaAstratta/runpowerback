package com.runpowerback.runpowerback.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PowerActivityDAO extends JpaRepository<PowerActivityJPA, Long> {

    List<PowerActivityJPA> findByOrderByIdAsc();

}
