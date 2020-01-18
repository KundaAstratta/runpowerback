package com.runpowerback.runpowerback.infrastructure;

import com.runpowerback.runpowerback.domaine.Activity;

import javax.persistence.*;

@Entity(name="ACTIVITY")
public class ActivityJPA {

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

    public ActivityJPA() {}

    public ActivityJPA(Activity activity) {
        this.id = activity.getId();
        this.latitude = activity.getLatitude();
        this.longitude = activity.getLongitude();
        this.elevation = activity.getElevation();
        this.hearthrate = activity.getHearthrate();
        this.timezone = activity.getTimezone();
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
        return "ActivityJPA{" +
                "id=" + id +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", elevation='" + elevation + '\'' +
                ", hearthrate='" + hearthrate + '\'' +
                ", timezone='" + timezone + '\'' +
                '}';
    }

    public Activity toActvity() {
        return new Activity(id, latitude,longitude,elevation,hearthrate,timezone);
    }

}
