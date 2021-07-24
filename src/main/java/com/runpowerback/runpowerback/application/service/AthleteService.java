package com.runpowerback.runpowerback.application.service;

import com.runpowerback.runpowerback.domaine.entity.Athlete;
import com.runpowerback.runpowerback.domaine.repository.AthleteRepository;
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

    public Long updateOneAthlete(Athlete athlete) {
        this.athleteRepository.deleteOneAthlete(athlete.getIdathlete());
        this.fromHearthmaxToZoneService.toTransform(athlete);
        return this.athleteRepository.save(athlete);
    }

    public Athlete findOneAthlete(Long idathlete) {
        return this.athleteRepository.findOneAthlete(idathlete);
    }

    public Athlete findById(Long id) {
        return this.athleteRepository.findById(id);
    }

    public void deleteOneAthlete(Long idathlete) {
        this.athleteRepository.deleteOneAthlete(idathlete);
    }

 }
