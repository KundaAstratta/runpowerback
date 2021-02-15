package com.runpowerback.runpowerback.infrastructure.dao;

import com.runpowerback.runpowerback.domaine.entity.ExternalCondition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ExternalConditionDAO extends JpaRepository<ExternalCondition, Long> {

    @Query(value ="SELECT * FROM externalcondition WHERE (idathlete = :idathlete AND idpoweractivity = :idpoweractivity) ;", nativeQuery = true)
    ExternalCondition findOneExternalCondition(Long idathlete, Long idpoweractivity);

}
