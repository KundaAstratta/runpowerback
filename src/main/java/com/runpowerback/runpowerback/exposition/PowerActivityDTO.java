package com.runpowerback.runpowerback.exposition;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PowerActivityDTO {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    public Long id;

    @JsonProperty
    public String power;

    @JsonProperty
    public String speed;

    @JsonProperty
    public String hearthrate;

    @JsonProperty
    public String distance;

    @JsonProperty
    public String timezone;

    public PowerActivityDTO() {}

    public PowerActivityDTO(Long id, String power, String speed, String hearthrate, String distance, String timezone) {
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

    public String getPower() {
        return power;
    }

    public String getSpeed() {
        return speed;
    }

    public String getHearthrate() {
        return hearthrate;
    }

    public String getDistance() {
        return distance;
    }

    public String getTimezone() {
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
