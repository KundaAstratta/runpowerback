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

    @JsonProperty
    public float powerscore;

    public StatisticsActivityDTO() {}

    public StatisticsActivityDTO(Long id, Long idathlete, Long idpoweractivity, float poweraverage, float powermedian, float deviation, float powerscore) {
        this.id = id;
        this.idathlete = idathlete;
        this.idpoweractivity = idpoweractivity;
        this.poweraverage = poweraverage;
        this.powermedian = powermedian;
        this.deviation = deviation;
        this.powerscore = powerscore;
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

    public float getPowerscore() {
        return powerscore;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("StatisticsActivityDTO{");
        sb.append("id=").append(id);
        sb.append(", idathlete=").append(idathlete);
        sb.append(", idpoweractivity=").append(idpoweractivity);
        sb.append(", poweraverage=").append(poweraverage);
        sb.append(", powermedian=").append(powermedian);
        sb.append(", deviation=").append(deviation);
        sb.append(", powerscore=").append(powerscore);
        sb.append('}');
        return sb.toString();
    }
}
