package com.runpowerback.runpowerback.application.dto.externalCondition;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ExternalConditionDTO {

    @JsonProperty
    public Long idathlete;

    @JsonProperty
    public Long idpoweractivity;

    @JsonProperty
    public float pressureatm;

    @JsonProperty
    public float temperature;

    @JsonProperty
    public float humidity;

    @JsonProperty
    public float speedwind;

    public ExternalConditionDTO(Long idathlete, Long idpoweractivity, float pressureatm, float temperature, float humidity, float speedwind) {
        this.idathlete = idathlete;
        this.idpoweractivity = idpoweractivity;
        this.pressureatm = pressureatm;
        this.temperature = temperature;
        this.humidity = humidity;
        this.speedwind = speedwind;
    }

    public Long getIdathlete() {
        return idathlete;
    }

    public Long getIdpoweractivity() {
        return idpoweractivity;
    }

    public float getTemperature() {
        return temperature;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ExternalConditionDTO{");
        sb.append(", idathlete=").append(idathlete);
        sb.append(", idpoweractivity=").append(idpoweractivity);
        sb.append(", pressureatm=").append(pressureatm);
        sb.append(", temperature=").append(temperature);
        sb.append(", humidity=").append(humidity);
        sb.append(", speedwind=").append(speedwind);
        sb.append('}');
        return sb.toString();
    }
}
