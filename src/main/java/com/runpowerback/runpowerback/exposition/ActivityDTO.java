package com.runpowerback.runpowerback.exposition;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ActivityDTO {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    public Long id;

    @JsonProperty
    public String latitude;

    @JsonProperty
    public String longitude;

    @JsonProperty
    public String elevation;

    @JsonProperty
    public String hearthrate;

    @JsonProperty
    public String timezone;

    public ActivityDTO() {}

    public ActivityDTO(Long id, String latitude, String longitude, String elevation, String hearthrate, String timezone) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.elevation = elevation;
        this.hearthrate = hearthrate;
        this.timezone = timezone;
    }
    
}
