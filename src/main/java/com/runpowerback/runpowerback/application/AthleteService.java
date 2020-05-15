package com.runpowerback.runpowerback.application;

import com.runpowerback.runpowerback.domaine.Athlete;
import com.runpowerback.runpowerback.domaine.AthleteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class AthleteService {

    @Autowired
    AthleteRepository athleteRepository;

    @Autowired
    FromHearthmaxToZoneService fromHearthmaxToZoneService;

    public Long createOneAthlete(Athlete athlete) {
        this.fromHearthmaxToZoneService.toTransform(athlete);
        return this.athleteRepository.save(athlete);
    }

    public Athlete findOneAthlete(Long idathlete) {
        return this.athleteRepository.findOneAthlete(idathlete);
    }
 }
