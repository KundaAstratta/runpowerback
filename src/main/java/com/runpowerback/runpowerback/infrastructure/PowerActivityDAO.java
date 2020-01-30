package com.runpowerback.runpowerback.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PowerActivityDAO extends JpaRepository<PowerActivityJPA, Long> {

    List<PowerActivityJPA> findByOrderByIdAsc();

    @Modifying
    @Query(value = "DELETE FROM poweractivity WHERE (idathlete = :idathlete AND idpoweractivity = :idpoweractivity)", nativeQuery = true)
    void deleteOnePowerActivity(Long idathlete, Long idpoweractivity);

    @Query(value = "SELECT * FROM poweractivity WHERE (idathlete = :idathlete AND idpoweractivity = :idpoweractivity)", nativeQuery = true)
    List<PowerActivityJPA> findOnePowerActivity(Long idathlete, Long idpoweractivity);

}
