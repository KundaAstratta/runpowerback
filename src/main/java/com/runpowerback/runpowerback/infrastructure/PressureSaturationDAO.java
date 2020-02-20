package com.runpowerback.runpowerback.infrastructure;

import com.runpowerback.runpowerback.domaine.PressureSaturation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PressureSaturationDAO extends JpaRepository<PressureSaturation, Long> {

    @Query(value ="SELECT * FROM pressuresaturation WHERE temperature = :temperature ;", nativeQuery = true)
    PressureSaturation findOnePressureSaturation(float temperature);

}
