package com.runpowerback.runpowerback.infrastructure.dao;

import com.runpowerback.runpowerback.domaine.entity.Athlete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AthleteDAO extends JpaRepository<Athlete, Long> {

    @Query(value="SELECT * FROM athlete WHERE idathlete = :idathlete ;", nativeQuery = true)
    Athlete findOneAthlete (Long idathlete);

}
