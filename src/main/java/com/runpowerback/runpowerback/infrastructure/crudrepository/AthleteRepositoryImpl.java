package com.runpowerback.runpowerback.infrastructure.crudrepository;

import com.runpowerback.runpowerback.domaine.entity.Athlete;
import com.runpowerback.runpowerback.domaine.repository.AthleteRepository;
import com.runpowerback.runpowerback.domaine.exception.ErrorCodes;
import com.runpowerback.runpowerback.domaine.exception.MyProjectException500;
import com.runpowerback.runpowerback.infrastructure.dao.AthleteDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Profile({"cloud"})
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
    public Athlete findOneAthlete(Long idathlete) {
        if (this.athleteDAO.findOneAthlete(idathlete) == null) {
            throw new MyProjectException500(ErrorCodes.NOT_FOUND);
        } else {
            return this.athleteDAO.findOneAthlete(idathlete);
        }
    }

    @Override
    public Athlete findById(Long id) {
        return this.athleteDAO.findById(id).orElseThrow(()-> new MyProjectException500(ErrorCodes.NOT_FOUND));
    }

    @Override
    public void deleteOneAthlete(Long idathlete) {
        athleteDAO.deleteOneAthlete(idathlete);
    }
}
