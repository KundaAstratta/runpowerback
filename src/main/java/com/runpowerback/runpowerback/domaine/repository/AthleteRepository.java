package com.runpowerback.runpowerback.domaine.repository;

import com.runpowerback.runpowerback.domaine.entity.Athlete;

public interface AthleteRepository {

    Long save(Athlete athlete);
    Athlete findOneAthlete (Long idathlete);
    Athlete findById(Long id);
    void deleteOneAthlete (Long idathlete);
}
