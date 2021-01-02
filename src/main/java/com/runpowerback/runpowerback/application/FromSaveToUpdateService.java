package com.runpowerback.runpowerback.application;

import com.runpowerback.runpowerback.domaine.Athlete;
import com.runpowerback.runpowerback.domaine.AthleteRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class FromSaveToUpdateService {

    @Autowired
    AthleteRepository athleteRepository;

    private static final Logger logger = LogManager.getLogger();

    public Long toCreate(Athlete athlete) {
        Long id = this.athleteRepository.save(athlete);
        return this.athleteRepository.update(id,athlete);
    }

}
