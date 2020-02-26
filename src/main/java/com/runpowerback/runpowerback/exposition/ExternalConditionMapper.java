package com.runpowerback.runpowerback.exposition;

import com.runpowerback.runpowerback.domaine.ExternalCondition;

public class ExternalConditionMapper {

    public ExternalConditionMapper() {
    }

    public static ExternalCondition mapToOneExternalCondition (ExternalConditionDTO externalConditionDTO) {
       return new ExternalCondition(
               null,
               externalConditionDTO.idathlete,
               externalConditionDTO.idpoweractivity,
               externalConditionDTO.pressureatm,
               externalConditionDTO.temperature,
               externalConditionDTO.humidity,
               externalConditionDTO.speedwind
        );
    }

    public static ExternalConditionDTO mapToExternalConditionDTO (ExternalCondition externalCondition) {
        return new ExternalConditionDTO(
                externalCondition.getId(),
                externalCondition.getIdathlete(),
                externalCondition.getIdpoweractivity(),
                externalCondition.getPressureatm(),
                externalCondition.getTemperature(),
                externalCondition.getHumidity(),
                externalCondition.getSpeedwind()
                );
    }

}
