package com.runpowerback.runpowerback.infrastructure;

import com.runpowerback.runpowerback.domaine.Athlete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AthleteDAO extends JpaRepository<Athlete, Long> {

    @Query(value="SELECT * FROM athlete WHERE idathlete = :idathlete ;", nativeQuery = true)
    Athlete findOneAthlete (Long idathlete);

}
