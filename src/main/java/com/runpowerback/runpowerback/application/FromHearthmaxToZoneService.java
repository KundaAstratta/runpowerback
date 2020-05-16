package com.runpowerback.runpowerback.application;

import com.runpowerback.runpowerback.domaine.Athlete;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class FromHearthmaxToZoneService {

    public void toTransform (Athlete athlete) {
        System.out.println(athlete.getHearthmax() * 65 / 100);
        System.out.println(athlete.getHearthmax() * 79 / 100);
        System.out.println(athlete.getHearthmax() * 80 / 100);
        System.out.println(athlete.getHearthmax() * 90 / 100);
        System.out.println(athlete.getHearthmax() * 88 / 100);
        System.out.println(athlete.getHearthmax() * 92 / 100);
        System.out.println(athlete.getHearthmax() * 98 / 100);
        System.out.println(athlete.getHearthmax());
        athlete.setEasyhearthmin(athlete.getHearthmax() * 65 / 100);
        athlete.setEasyhearthmax(athlete.getHearthmax() * 79 / 100);
        athlete.setMarathonhearthmin(athlete.getHearthmax() * 80 / 100);
        athlete.setMarathonhearthmax(athlete.getHearthmax() *  89 / 100);
        athlete.setThresholdhearthmin(athlete.getHearthmax() * 89.5f / 100);
        athlete.setThresholdhearthmax(athlete.getHearthmax() * 92 / 100);
        athlete.setIntervalhearthmin(athlete.getHearthmax() * 92.5f / 100);
        athlete.setIntervalhearthmax(athlete.getHearthmax() * 97 / 100);
        athlete.setRepetitionhearthmin(athlete.getHearthmax() * 98 / 100);
        athlete.setRepetitionhearthmax(athlete.getHearthmax());








    }

}
