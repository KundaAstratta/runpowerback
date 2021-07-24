package com.runpowerback.runpowerback.application.dto.athlete;

import com.runpowerback.runpowerback.domaine.entity.Athlete;

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
                athlete.getIdathlete(),
                athlete.getName(),
                athlete.getSurname(),
                athlete.getMass(),
                athlete.getHearthmax()
        );
    }

}
