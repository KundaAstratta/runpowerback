package com.runpowerback.runpowerback.infrastructure;

import com.runpowerback.runpowerback.domaine.ExternalCondition;
import com.runpowerback.runpowerback.domaine.ExternalConditionRepository;
import com.runpowerback.runpowerback.domaine.exception.ErrorCodes;
import com.runpowerback.runpowerback.domaine.exception.MyProjectException500;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ExternalConditionRepositoryImpl implements ExternalConditionRepository {

    @Autowired
    ExternalConditionDAO externalConditionDAO;

    @Override
    public Long save(ExternalCondition externalCondition) {
        this.externalConditionDAO.save(externalCondition);
        return externalCondition.getId();
    }

    @Override
    public ExternalCondition findOneExternalCondition(Long idathlete, Long idpoweractivity) {
        if (this.externalConditionDAO.findOneExternalCondition(idathlete,idpoweractivity) == null) {
            throw new MyProjectException500(ErrorCodes.NOT_FOUND);
        } else {
            return this.externalConditionDAO.findOneExternalCondition(idathlete,idpoweractivity);
        }
    }

}
