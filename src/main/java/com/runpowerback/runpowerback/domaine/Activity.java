package com.runpowerback.runpowerback.domaine;

import javax.persistence.*;

@Entity(name="ACTIVITY")
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Long id;

    @Column(name="LATITUDE")
    private float latitude;

    @Column(name="LONGITUDE")
    private float longitude;

    @Column(name="ELEVATION")
    private float elevation;

    @Column(name="HEARTHRATE")
    private float hearthrate;

    @Column(name="TIMEZONE")
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
        final StringBuffer sb = new StringBuffer("Activity{");
        sb.append("id=").append(id);
        sb.append(", latitude=").append(latitude);
        sb.append(", longitude=").append(longitude);
        sb.append(", elevation=").append(elevation);
        sb.append(", hearthrate=").append(hearthrate);
        sb.append(", timezone='").append(timezone).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
