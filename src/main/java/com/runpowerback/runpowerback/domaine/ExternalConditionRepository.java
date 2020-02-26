package com.runpowerback.runpowerback.domaine;

public interface ExternalConditionRepository {

    Long save (ExternalCondition externalCondition);
    ExternalCondition findOneExternalCondition(Long idathlete, Long idpoweractivity);

}
