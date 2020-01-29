package com.runpowerback.runpowerback.exposition;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PowerActivityDTO {

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

    public PowerActivityDTO() {}

    public PowerActivityDTO(Long id, Long idathlete, Long idpoweractivity, float power, float speed, float hearthrate, float distance, float pace, float timezone) {
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

    public float getPower() {
        return power;
    }

    public float getSpeed() {
        return speed;
    }

    public float getHearthrate() {
        return hearthrate;
    }

    public float getDistance() {
        return distance;
    }

    public float getPace() {return pace;}

    public float getTimezone() {
        return timezone;
    }

    @Override
    public String toString() {
        return "PowerActivityDTO{" +
                "id=" + id +
                ", idathlete=" + idathlete + '\'' +
                ", idpoweractivity=" + idpoweractivity + '\'' +
                ", power='" + power + '\'' +
                ", speed='" + speed + '\'' +
                ", hearthrate='" + hearthrate + '\'' +
                ", distance='" + distance + '\'' +
                ", pace='" + pace + '\'' +
                ", timezone='" + timezone + '\'' +
                '}';
    }
}
