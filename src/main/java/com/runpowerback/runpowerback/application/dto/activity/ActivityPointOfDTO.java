package com.runpowerback.runpowerback.application.dto.activity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ActivityPointOfDTO {

    @JsonProperty
    public float latitude;

    @JsonProperty
    public float longitude;

    @JsonProperty
    public float elevation;

    @JsonProperty
    public float hearthrate;

    @JsonProperty
    public String timezone;

    public ActivityPointOfDTO(float latitude, float longitude, float elevation, float hearthrate, String timezone) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.elevation = elevation;
        this.hearthrate = hearthrate;
        this.timezone = timezone;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ActivityDTO{");
        sb.append(", latitude=").append(latitude);
        sb.append(", longitude=").append(longitude);
        sb.append(", elevation=").append(elevation);
        sb.append(", hearthrate=").append(hearthrate);
        sb.append(", timezone='").append(timezone).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
