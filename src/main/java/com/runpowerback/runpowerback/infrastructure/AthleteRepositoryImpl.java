package com.runpowerback.runpowerback.infrastructure;

import com.runpowerback.runpowerback.domaine.Athlete;
import com.runpowerback.runpowerback.domaine.AthleteRepository;
import com.runpowerback.runpowerback.domaine.exception.ErrorCodes;
import com.runpowerback.runpowerback.domaine.exception.MyProjectException500;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AthleteRepositoryImpl implements AthleteRepository {

    @Autowired
    AthleteDAO athleteDAO;

    @Override
    public Long save(Athlete athlete) {
        this.athleteDAO.save(athlete);
        return athlete.getId();
    }

    @Override
    public Athlete findOneAthlete(Long idthlete) {
        if (this.athleteDAO.findOneAthlete(idthlete) == null) {
            throw new MyProjectException500(ErrorCodes.NOT_FOUND);
        } else {
            return this.athleteDAO.findOneAthlete(idthlete);
        }
    }
}
