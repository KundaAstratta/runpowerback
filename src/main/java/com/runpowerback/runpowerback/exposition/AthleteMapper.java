package com.runpowerback.runpowerback.exposition;

import com.runpowerback.runpowerback.domaine.Athlete;

public class AthleteMapper {

    public AthleteMapper() {
    }

    public static Athlete mapToOneAthlete (AthleteDTO athleteDTO) {
        return new Athlete(
                null,
                athleteDTO.idathlete,
                athleteDTO.name,
                athleteDTO.surname,
                athleteDTO.mass,
                athleteDTO.hearthmax
        );
    }

    public static AthleteDTO mapToOneAthleteDTO (Athlete athlete) {
        return new AthleteDTO(
                athlete.getId(),
                athlete.getIdathlete(),
                athlete.getName(),
                athlete.getSurname(),
                athlete.getMass(),
                athlete.getHearthmax()
        );
    }

}
