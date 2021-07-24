package com.runpowerback.runpowerback;

import com.runpowerback.runpowerback.domaine.entity.ExternalCondition;
import com.runpowerback.runpowerback.domaine.exception.MyProjectException500;
import com.runpowerback.runpowerback.infrastructure.inmemory.ExternalConditionInMemoryRepositoryImpl;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ExternalConditionRepositoryTests {

    @Test
    void createOneExternalCondition() {
        ExternalConditionInMemoryRepositoryImpl externalConditionInMemoryRepository = new ExternalConditionInMemoryRepositoryImpl();

        assertThat(1L).isEqualTo(externalConditionInMemoryRepository.save(new ExternalCondition(1L,1L,1L,10000f,15f,60f,10)));
    }

    @Test
    void createThreeExternalConditionAndFindTheSecond() {
        ExternalConditionInMemoryRepositoryImpl externalConditionInMemoryRepository = new ExternalConditionInMemoryRepositoryImpl();

        externalConditionInMemoryRepository.save(new ExternalCondition(1L,1L,1L,10000f,15f,60f,10f));
        externalConditionInMemoryRepository.save(new ExternalCondition(2L,1L,2L,10000f,16f,50f,0f));
        externalConditionInMemoryRepository.save(new ExternalCondition(3L,1L,3L,10000f,14f,40f,5f));

        assertThat(16f).isEqualTo(externalConditionInMemoryRepository.findOneExternalCondition(1L,2L).getTemperature());

    }

    @Test
    void deleteOneExternalConditionOfAList() {
        ExternalConditionInMemoryRepositoryImpl externalConditionInMemoryRepository = new ExternalConditionInMemoryRepositoryImpl();

        externalConditionInMemoryRepository.save(new ExternalCondition(1L,1L,1L,10000f,15f,60f,10f));
        externalConditionInMemoryRepository.save(new ExternalCondition(2L,1L,2L,10000f,16f,50f,0f));
        externalConditionInMemoryRepository.save(new ExternalCondition(3L,1L,3L,10000f,14f,40f,5f));

        assertThat(16f).isEqualTo(externalConditionInMemoryRepository.findOneExternalCondition(1L,2L).getTemperature());

        externalConditionInMemoryRepository.deleteOneExternalCondition(1L,2L);

        try {
            externalConditionInMemoryRepository.findOneExternalCondition(1l, 2L);
        } catch (MyProjectException500 exception500) {
            assertThat("[ERR_0001]").isEqualTo(exception500.getCodeErreurs().toString());
        }

    }

}
