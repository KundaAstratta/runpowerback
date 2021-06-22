package com.runpowerback.runpowerback.exposition.controller;

import com.runpowerback.runpowerback.application.service.AthleteService;
import com.runpowerback.runpowerback.application.dto.athlete.AthleteDTO;
import com.runpowerback.runpowerback.application.dto.athlete.AthleteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class AthleteController {

    @Autowired
    AthleteService athleteService;

    @RequestMapping(method = RequestMethod.POST, path = {"/athlete"})
    @ResponseStatus(HttpStatus.CREATED)
    public Long createOneAthleteWithGivenBody (@Valid @RequestBody AthleteDTO athleteDTO) {
        return this.athleteService.createOneAthlete(AthleteMapper.mapToOneAthlete(athleteDTO));
    }

    @RequestMapping(method = RequestMethod.POST, path = {"/athlete/newathlete"})
    @ResponseStatus(HttpStatus.CREATED)
    public Long createNewAthleteWithNewIncrementedIdathete (@Valid @RequestBody AthleteDTO athleteDTO) {
        return this.athleteService.createAndUpdate(AthleteMapper.mapToOneAthlete(athleteDTO));
    }

    @RequestMapping(method = RequestMethod.PUT, path = {"/athlete/update/id/{id}"})
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Long updateOneAthlete (@PathVariable("id") Long id, @Valid @RequestBody AthleteDTO athleteDTO) {
        return this.athleteService.updateOneAthlete(id,AthleteMapper.mapToOneAthlete(athleteDTO));
    }

    @RequestMapping(method = RequestMethod.GET,path ={"/athlete/{idathlete}"})
    public AthleteDTO findOneAthlete (@PathVariable("idathlete") Long idathlete) {
        return AthleteMapper.mapToOneAthleteDTO(this.athleteService.findOneAthlete(idathlete));
    }

    @RequestMapping(method = RequestMethod.GET,path ={"/athlete/id/{id}"})
    public AthleteDTO findById (@PathVariable("id") Long id) {
        return AthleteMapper.mapToOneAthleteDTO(this.athleteService.findById(id));
    }

    @RequestMapping(method = RequestMethod.DELETE, path = {"/athlete/delete/{idathlete}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOneAthlete(@PathVariable("idathlete") Long idathlete) {
        this.athleteService.deleteOneAthlete(idathlete);
    }


}
