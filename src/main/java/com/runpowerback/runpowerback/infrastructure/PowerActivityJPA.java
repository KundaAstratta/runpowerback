package com.runpowerback.runpowerback.infrastructure;

import com.runpowerback.runpowerback.domaine.PowerActivity;

import javax.persistence.*;

@Entity(name = "POWERACTIVITY")
public class PowerActivityJPA {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    public Long id;

    @Column(name= "IDATHLETE")
    public Long idathlete;

    @Column(name = "IDPOWERACTIVITY")
    public Long idpoweractivity;

    @Column(name = "POWER")
    private float power;

    @Column(name = "SPEED")
    private float speed;

    @Column(name = "HEARTHRATE")
    private float hearthrate;

    @Column(name = "DISTANCE")
    private float distance;

    @Column(name= "PACE")
    private float pace;

    @Column(name = "TIMEZONE")
    private float timezone;

    public PowerActivityJPA() {}

    public PowerActivityJPA(PowerActivity powerActivity) {
        this.id = powerActivity.getId();
        this.idathlete = powerActivity.getIdathlete();
        this.idpoweractivity = powerActivity.getIdpoweractivity();
        this.power = powerActivity.getPower();
        this.speed = powerActivity.getSpeed();
        this.hearthrate = powerActivity.getHearthrate();
        this.distance = powerActivity.getDistance();
        this.pace = powerActivity.getPace();
        this.timezone = powerActivity.getTimezone();
    }

    public Long getId() {
        return id;
    }

    public float getPower() {
        return power;
    }

    public Long getIdathlete() {
        return idathlete;
    }

    public Long getIdpoweractivity() {
        return idpoweractivity;
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

    public float getPace() {return pace;}

    public float getTimezone() {
        return timezone;
    }

    @Override
    public String toString() {
        return "PowerActivityJPA{" +
                "id=" + id +
                ", idathlete='" + idathlete + '\'' +
                ", idpoweractivity='" + idpoweractivity + '\'' +
                ", power='" + power + '\'' +
                ", speed='" + speed + '\'' +
                ", hearthrate='" + hearthrate + '\'' +
                ", distance='" + distance + '\'' +
                ", pace='" + pace + '\'' +
                ", timezone='" + timezone + '\'' +
                '}';
    }

    public PowerActivity toPowerActivity() {return new PowerActivity(id,idathlete, idpoweractivity,power,speed,hearthrate,distance,pace,timezone);}

}
