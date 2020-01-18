package com.runpowerback.runpowerback.infrastructure;

import com.runpowerback.runpowerback.domaine.PowerActivity;

import javax.persistence.*;

@Entity(name = "POWERACTIVITY")
public class PowerActivityJPA {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    public Long id;

    @Column(name = "POWER")
    private float power;

    @Column(name = "SPEED")
    private float speed;

    @Column(name = "HEARTHRATE")
    private float hearthrate;

    @Column(name = "DISTANCE")
    private float distance;

    @Column(name = "TIMEZONE")
    private float timezone;

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

    public float getPower() {
        return power;
    }

    public float getSpeed() {
        return speed;
    }

    public float getHearthrate() {
        return hearthrate;
    }

    public float getDistance() {
        return distance;
    }

    public float getTimezone() {
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
