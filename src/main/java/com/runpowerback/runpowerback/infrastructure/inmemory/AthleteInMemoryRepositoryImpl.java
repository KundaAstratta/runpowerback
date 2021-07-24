package com.runpowerback.runpowerback.infrastructure.inmemory;

import com.runpowerback.runpowerback.domaine.entity.Athlete;
import com.runpowerback.runpowerback.domaine.exception.ErrorCodes;
import com.runpowerback.runpowerback.domaine.exception.MyProjectException500;
import com.runpowerback.runpowerback.domaine.repository.AthleteRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Profile({"in-memory"})
@Repository
public class AthleteInMemoryRepositoryImpl implements AthleteRepository {

    List<Athlete> athleteList = new ArrayList<>();

    @Override
    public Long save(Athlete athlete) {
        athleteList.add(athlete);
        return athleteList.get(athleteList.size()-1).getId();
    }

    @Override
    public Athlete findOneAthlete(Long idathlete) {
        Athlete athleteFound = null;

        athleteFound = athleteList.stream().filter(index -> index.getIdathlete().equals(idathlete)).findFirst().orElse(null);

        if (athleteFound == null) {
            throw new MyProjectException500(ErrorCodes.NOT_FOUND);
        } else {
            return athleteFound;
        }
    }

    @Override
    public Athlete findById(Long id) {
        int index = Math.toIntExact(id)-1;
        if (athleteList.get(index) == null) {
            throw new MyProjectException500(ErrorCodes.NOT_FOUND);
        } else {
            return athleteList.get(index);
        }
    }

    @Override
    public void deleteOneAthlete(Long idathlete) {
        Athlete athleteFound = null;

        athleteFound = athleteList.stream().filter(ind -> ind.getIdathlete().equals(idathlete)).findFirst().orElse(null);

        athleteList.remove(athleteFound);
    }

}
