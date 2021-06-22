package com.runpowerback.runpowerback.infrastructure.dao;

import com.runpowerback.runpowerback.domaine.entity.PowerActivityPointOf;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PowerActivityDAO extends JpaRepository<PowerActivityPointOf, Long> {

    List<PowerActivityPointOf> findByOrderByIdAsc();

    @Modifying
    @Query(value = "DELETE FROM poweractivity WHERE (idathlete = :idathlete AND idpoweractivity = :idpoweractivity) ;", nativeQuery = true)
    void deleteOnePowerActivity(Long idathlete, Long idpoweractivity);

    @Query(value = "SELECT * FROM poweractivity WHERE (idathlete = :idathlete AND idpoweractivity = :idpoweractivity) ;", nativeQuery = true)
    List<PowerActivityPointOf> findOnePowerActivity(Long idathlete, Long idpoweractivity);

    @Query(value = "SELECT MAX (idpoweractivity) FROM poweractivity WHERE (idathlete = :idathlete) ;", nativeQuery = true)
    Long findMaxIdPowerActivity(Long idathlete);

}
