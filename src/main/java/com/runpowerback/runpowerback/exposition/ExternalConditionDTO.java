package com.runpowerback.runpowerback.exposition;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ExternalConditionDTO {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    public Long id;

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

    public ExternalConditionDTO() {
    }

    public ExternalConditionDTO(Long id, Long idathlete, Long idpoweractivity, float pressureatm, float temperature, float humidity, float speedwind) {
        this.id = id;
        this.idathlete = idathlete;
        this.idpoweractivity = idpoweractivity;
        this.pressureatm = pressureatm;
        this.temperature = temperature;
        this.humidity = humidity;
        this.speedwind = speedwind;
    }

    public Long getId() {
        return id;
    }

    public Long getIdathlete() {
        return idathlete;
    }

    public Long getIdpoweractivity() {
        return idpoweractivity;
    }

    public float getPressureatm() {
        return pressureatm;
    }

    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getSpeedwind() {
        return speedwind;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ExternalConditionDTO{");
        sb.append("id=").append(id);
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
