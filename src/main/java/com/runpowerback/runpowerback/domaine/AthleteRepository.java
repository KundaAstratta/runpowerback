package com.runpowerback.runpowerback.domaine;

public interface AthleteRepository {

    Long save(Athlete athlete);
    Athlete findOneAthlete (Long idathlete);

}
