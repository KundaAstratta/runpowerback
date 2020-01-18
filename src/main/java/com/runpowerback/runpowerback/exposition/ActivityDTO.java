package com.runpowerback.runpowerback.exposition;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ActivityDTO {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    public Long id;

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

    public ActivityDTO() {}

    public ActivityDTO(Long id, float latitude, float longitude, float elevation, float hearthrate, String timezone) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.elevation = elevation;
        this.hearthrate = hearthrate;
        this.timezone = timezone;
    }

    public Long getId() {
        return id;
    }

    public float getLatitude() {
        return latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public float getElevation() {
        return elevation;
    }

    public float getHearthrate() {
        return hearthrate;
    }

    public String getTimezone() {
        return timezone;
    }

    @Override
    public String toString() {
        return "ActivityDTO{" +
                "id=" + id +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", elevation='" + elevation + '\'' +
                ", hearthrate='" + hearthrate + '\'' +
                ", timezone='" + timezone + '\'' +
                '}';
    }

}

