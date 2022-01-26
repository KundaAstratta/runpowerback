package com.runpowerback.runpowerback.infrastructure.crudrepository;

import com.runpowerback.runpowerback.domaine.entity.ExternalCondition;
import com.runpowerback.runpowerback.domaine.repository.ExternalConditionRepository;
import com.runpowerback.runpowerback.domaine.exception.ErrorCodes;
import com.runpowerback.runpowerback.domaine.exception.MyProjectException500;
import com.runpowerback.runpowerback.infrastructure.dao.ExternalConditionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Profile({"local","cloud"})
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

    @Override
    public void deleteOneExternalCondition(Long idathlete, Long idpoweractivity) {
        this.externalConditionDAO.deleteOneExternalCondition(idathlete, idpoweractivity);
    }

}
