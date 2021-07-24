package com.runpowerback.runpowerback.infrastructure.inmemory;

import com.runpowerback.runpowerback.domaine.entity.ExternalCondition;
import com.runpowerback.runpowerback.domaine.exception.ErrorCodes;
import com.runpowerback.runpowerback.domaine.exception.MyProjectException500;
import com.runpowerback.runpowerback.domaine.repository.ExternalConditionRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Profile({"in-memory"})
@Repository
public class ExternalConditionInMemoryRepositoryImpl implements ExternalConditionRepository {

    List<ExternalCondition> externalConditionList = new ArrayList<>();

    @Override
    public Long save(ExternalCondition externalCondition) {
        externalConditionList.add(externalCondition);
        return externalConditionList.get(externalConditionList.size()-1).getId();
    }

    @Override
    public ExternalCondition findOneExternalCondition(Long idathlete, Long idpoweractivity) {

        ExternalCondition externalConditionFound = externalConditionList.stream()
                .filter(index -> index.getIdathlete().equals(idathlete) && index.getIdpoweractivity().equals(idpoweractivity))
                .findFirst()
                .orElse(null);

        if (externalConditionFound == null) {
            throw new MyProjectException500(ErrorCodes.NOT_FOUND);
        } else {
            return externalConditionFound;
        }
    }

    @Override
    public void deleteOneExternalCondition(Long idathlete, Long idpoweractivity) {
        ExternalCondition externalConditionFound = externalConditionList.stream()
                .filter(index -> index.getIdathlete().equals(idathlete) && index.getIdpoweractivity().equals(idpoweractivity))
                .findFirst()
                .orElse(null);

        externalConditionList.remove(externalConditionFound);
    }

}
