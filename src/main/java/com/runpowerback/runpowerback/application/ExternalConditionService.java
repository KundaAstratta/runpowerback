package com.runpowerback.runpowerback.application;

import com.runpowerback.runpowerback.domaine.ExternalCondition;
import com.runpowerback.runpowerback.domaine.ExternalConditionRepository;
import com.runpowerback.runpowerback.domaine.PowerActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ExternalConditionService {

    @Autowired
    ExternalConditionRepository externalConditionRepository;

    @Autowired
    PowerActivityRepository powerActivityRepository;


    public Long createOneExternalCondition (ExternalCondition externalCondition) {
        Long idathlete = externalCondition.getIdathlete();
        Long idpoweractivity = this.powerActivityRepository.findMaxIdPowerActivity(idathlete);
        externalCondition.setIdpoweractivity(idpoweractivity+1);
        return this.externalConditionRepository.save(externalCondition);
    }

    public ExternalCondition findOneExternalCondition (Long idathlete, Long idpoweractivity) {
        return this.externalConditionRepository.findOneExternalCondition(idathlete,idpoweractivity);
    }

}
