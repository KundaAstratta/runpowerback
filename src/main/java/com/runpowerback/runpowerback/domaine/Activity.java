package com.runpowerback.runpowerback.domaine;

public class Activity {
    private Long id;
    private float latitude;
    private float longitude;
    private float elevation;
    private float hearthrate;
    private String timezone;

    public Activity() {}

    public Activity(Long id,  float latitude, float longitude, float elevation, float hearthrate, String timezone) {
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
        return "Activity{" +
                "id=" + id +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", elevation='" + elevation + '\'' +
                ", hearthrate='" + hearthrate + '\'' +
                ", timezone='" + timezone + '\'' +
                '}';
    }

}
