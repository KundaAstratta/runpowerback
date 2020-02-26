package com.runpowerback.runpowerback.application;

import com.runpowerback.runpowerback.domaine.ExternalCondition;
import com.runpowerback.runpowerback.domaine.ExternalConditionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.concurrent.ExecutorService;

@Service
@Transactional
public class ExternalConditionService {

    @Autowired
    ExternalConditionRepository externalConditionRepository;

    public Long createOneExternalCondition (ExternalCondition externalCondition) {
        return this.externalConditionRepository.save(externalCondition);
    }

    public ExternalCondition findOneExternalCondition (Long idathlete, Long idpoweractivity) {
        return this.externalConditionRepository.findOneExternalCondition(idathlete,idpoweractivity);
    }

}
