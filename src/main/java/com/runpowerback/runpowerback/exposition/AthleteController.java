package com.runpowerback.runpowerback.exposition;

import com.runpowerback.runpowerback.application.AthleteService;
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
    public Long createOneAthlete (@Valid @RequestBody AthleteDTO athleteDTO) {
        return this.athleteService.createOneAthlete(AthleteMapper.mapToOneAthlete(athleteDTO));
    }

    @RequestMapping(method = RequestMethod.POST, path = {"/fromsavetoupdate"})
    @ResponseStatus(HttpStatus.CREATED)
    public Long createAndUpdate (@Valid @RequestBody AthleteDTO athleteDTO) {
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

}
