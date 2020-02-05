package com.runpowerback.runpowerback.exposition;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StatisticsActivityDTO {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    public Long id;

    @JsonProperty
    public Long idathlete;

    @JsonProperty
    public Long idpoweractivity;

    @JsonProperty
    public float poweraverage;

    @JsonProperty
    public float powermedian;

    @JsonProperty
    public float deviation;

    public StatisticsActivityDTO() {}

    public StatisticsActivityDTO(Long id, Long idathlete, Long idpoweractivity, float poweraverage, float powermedian, float deviation) {
        this.id = id;
        this.idathlete = idathlete;
        this.idpoweractivity = idpoweractivity;
        this.poweraverage = poweraverage;
        this.powermedian = powermedian;
        this.deviation = deviation;
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

    public float getPoweraverage() {
        return poweraverage;
    }

    public float getPowermedian() {
        return powermedian;
    }

    public float getDeviation() {
        return deviation;
    }

    @Override
    public String toString() {
        return "StatisticsActivityDTO{" +
                "id=" + id +
                ", idathlete=" + idathlete +
                ", idpoweractivity=" + idpoweractivity +
                ", poweraverage=" + poweraverage +
                ", powermedian=" + powermedian +
                ", deviation=" + deviation +
                '}';
    }
}
