package com.runpowerback.runpowerback.application.service;

import com.runpowerback.runpowerback.domaine.entity.*;
import com.runpowerback.runpowerback.domaine.repository.ExternalConditionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ExternalConditionService {

    @Autowired
    ExternalConditionRepository externalConditionRepository;

    public Long createOneExternalCondition (ExternalCondition externalCondition) {
        return this.externalConditionRepository.save(externalCondition);
    }

    public void deleteOneExternalCondition(Long idathlete, Long idpoweractivity) {
        this.externalConditionRepository.deleteOneExternalCondition(idathlete,idpoweractivity);
    }

    public ExternalCondition findOneExternalCondition (Long idathlete, Long idpoweractivity) {
        return this.externalConditionRepository.findOneExternalCondition(idathlete,idpoweractivity);
    }

}
