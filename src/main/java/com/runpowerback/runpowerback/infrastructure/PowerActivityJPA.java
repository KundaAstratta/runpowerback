package com.runpowerback.runpowerback.infrastructure;

import com.runpowerback.runpowerback.domaine.PowerActivity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "POWERACTIVITY")
public class PowerActivityJPA {

    @Id
    @GeneratedValue
    @Column(name="ID")
    public Long id;

    @Column(name = "POWER")
    private String power;

    @Column(name = "SPEED")
    private String speed;

    @Column(name = "HEARTHRATE")
    private String hearthrate;

    @Column(name = "DISTANCE")
    private String distance;

    @Column(name = "TIMEZONE")
    private String timezone;

    public PowerActivityJPA() {}

    public PowerActivityJPA(PowerActivity powerActivity) {
        this.id = powerActivity.getId();
        this.power = powerActivity.getPower();
        this.speed = powerActivity.getSpeed();
        this.hearthrate = powerActivity.getHearthrate();
        this.distance = powerActivity.getDistance();
        this.timezone = powerActivity.getTimezone();
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
        return "PowerActivityJPA{" +
                "id=" + id +
                ", power='" + power + '\'' +
                ", speed='" + speed + '\'' +
                ", hearthrate='" + hearthrate + '\'' +
                ", distance='" + distance + '\'' +
                ", timezone='" + timezone + '\'' +
                '}';
    }

    public PowerActivity toPowerActivity() {return new PowerActivity(id,power,speed,hearthrate,distance,timezone);}

}
