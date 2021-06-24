package com.runpowerback.runpowerback.application.dto.powerActivity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PowerActivityPointOfDTO {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    public Long id;

    @JsonProperty
    public Long idathlete;

    @JsonProperty
    public Long idpoweractivity;

    @JsonProperty
    public float power;

    @JsonProperty
    public float speed;

    @JsonProperty
    public float hearthrate;

    @JsonProperty
    public float distance;

    @JsonProperty
    public float pace;

    @JsonProperty
    public float timezone;

    public PowerActivityPointOfDTO(Long id, Long idathlete, Long idpoweractivity, float power, float speed, float hearthrate, float distance, float pace, float timezone) {
        this.id = id;
        this.idathlete = idathlete;
        this.idpoweractivity = idpoweractivity;
        this.power = power;
        this.speed = speed;
        this.hearthrate = hearthrate;
        this.distance = distance;
        this.pace = pace;
        this.timezone = timezone;
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

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("PowerActivityDTO{");
        sb.append("id=").append(id);
        sb.append(", idathlete=").append(idathlete);
        sb.append(", idpoweractivity=").append(idpoweractivity);
        sb.append(", power=").append(power);
        sb.append(", speed=").append(speed);
        sb.append(", hearthrate=").append(hearthrate);
        sb.append(", distance=").append(distance);
        sb.append(", pace=").append(pace);
        sb.append(", timezone=").append(timezone);
        sb.append('}');
        return sb.toString();
    }
}