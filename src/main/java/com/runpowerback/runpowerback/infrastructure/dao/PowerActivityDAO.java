package com.runpowerback.runpowerback.infrastructure.dao;

import com.runpowerback.runpowerback.domaine.entity.PowerActivity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PowerActivityDAO extends JpaRepository<PowerActivity, Long> {

    List<PowerActivity> findByOrderByIdAsc();

    @Modifying
    @Query(value = "DELETE FROM poweractivity WHERE (idathlete = :idathlete AND idpoweractivity = :idpoweractivity) ;", nativeQuery = true)
    void deleteOnePowerActivity(Long idathlete, Long idpoweractivity);

    @Query(value = "SELECT * FROM poweractivity WHERE (idathlete = :idathlete AND idpoweractivity = :idpoweractivity) ;", nativeQuery = true)
    List<PowerActivity> findOnePowerActivity(Long idathlete, Long idpoweractivity);

    @Query(value = "SELECT MAX (idpoweractivity) FROM poweractivity WHERE (idathlete = :idathlete) ;", nativeQuery = true)
    Long findMaxIdPowerActivity(Long idathlete);

}
