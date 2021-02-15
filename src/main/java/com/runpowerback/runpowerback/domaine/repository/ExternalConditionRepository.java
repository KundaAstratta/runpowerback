package com.runpowerback.runpowerback.domaine.repository;

import com.runpowerback.runpowerback.domaine.entity.ExternalCondition;

public interface ExternalConditionRepository {

    Long save (ExternalCondition externalCondition);
    ExternalCondition findOneExternalCondition(Long idathlete, Long idpoweractivity);

}
