package com.runpowerback.runpowerback.domaine;

public class Activity {
    private Long id;
    private String latitude;
    private String longitude;
    private String elevation;
    private String hearthrate;
    private String timezone;

    public Activity() {}

    public Activity(Long id,  String latitude, String longitude, String elevation, String hearthrate, String timezone) {
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

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getElevation() {
        return elevation;
    }

    public String getHearthrate() {
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
