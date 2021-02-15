package com.runpowerback.runpowerback.application.service;

import com.runpowerback.runpowerback.domaine.entity.Athlete;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class FromHearthmaxToZoneService {

    private static final Logger logger = LogManager.getLogger();

    public void toTransform (Athlete athlete) {
        logger.info(athlete.getHearthmax() * 65 / 100);
        logger.info(athlete.getHearthmax() * 79 / 100);
        logger.info(athlete.getHearthmax() * 80 / 100);
        logger.info(athlete.getHearthmax() * 90 / 100);
        logger.info(athlete.getHearthmax() * 88 / 100);
        logger.info(athlete.getHearthmax() * 92 / 100);
        logger.info(athlete.getHearthmax() * 98 / 100);
        logger.info(athlete.getHearthmax());
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
