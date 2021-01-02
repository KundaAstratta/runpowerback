package com.runpowerback.runpowerback.domaine;

public interface AthleteRepository {

    Long save(Athlete athlete);

    Long update(Long id, Athlete athlete);

    Athlete findOneAthlete (Long idathlete);

    Athlete findById(Long id);

}
