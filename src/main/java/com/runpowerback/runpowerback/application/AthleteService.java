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

    @Autowired
    FromSaveToUpdateService fromSaveToUpdateService;

    public Long createOneAthlete(Athlete athlete) {
        this.fromHearthmaxToZoneService.toTransform(athlete);
        return this.athleteRepository.save(athlete);
    }

    public Long createAndUpdate(Athlete athlete) {
        this.fromHearthmaxToZoneService.toTransform(athlete);
        return this.fromSaveToUpdateService.toCreate(athlete);
    }

    public Long updateOneAthlete(Long id, Athlete athlete) {
        return this.athleteRepository.update(id,athlete);
    }

    public Athlete findOneAthlete(Long idathlete) {
        return this.athleteRepository.findOneAthlete(idathlete);
    }

    public Athlete findById(Long id) {
        return this.athleteRepository.findById(id);
    }


 }
