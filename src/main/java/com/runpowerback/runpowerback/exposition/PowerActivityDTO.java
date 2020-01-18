package com.runpowerback.runpowerback.exposition;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PowerActivityDTO {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    public Long id;

    @JsonProperty
    public float power;

    @JsonProperty
    public float speed;

    @JsonProperty
    public float hearthrate;

    @JsonProperty
    public float distance;

    @JsonProperty
    public float timezone;

    public PowerActivityDTO() {}

    public PowerActivityDTO(Long id, float power, float speed, float hearthrate, float distance, float timezone) {
        this.id = id;
        this.power = power;
        this.speed = speed;
        this.hearthrate = hearthrate;
        this.distance = distance;
        this.timezone = timezone;
    }

    public Long getId() {
        return id;
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

    public float getTimezone() {
        return timezone;
    }

    @Override
    public String toString() {
        return "PowerActivityDTO{" +
                "id=" + id +
                ", power='" + power + '\'' +
                ", speed='" + speed + '\'' +
                ", hearthrate='" + hearthrate + '\'' +
                ", distance='" + distance + '\'' +
                ", timezone='" + timezone + '\'' +
                '}';
    }
}
