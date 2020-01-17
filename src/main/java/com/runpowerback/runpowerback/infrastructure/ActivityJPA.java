package com.runpowerback.runpowerback.infrastructure;

import com.runpowerback.runpowerback.domaine.Activity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="ACTIVITY")
public class ActivityJPA {

    @Id
    @GeneratedValue
    @Column(name="ID")
    private Long id;

    @Column(name="LATITUDE")
    private String latitude;

    @Column(name="LONGITUDE")
    private String longitude;

    @Column(name="ELEVATION")
    private String elevation;

    @Column(name="HEARTHRATE")
    private String hearthrate;

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

    public Activity toActvity() {
        return new Activity(id, latitude,longitude,elevation,hearthrate,timezone);
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


}
