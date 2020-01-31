package com.runpowerback.runpowerback.domaine;

import javax.persistence.*;

@Entity(name = "POWERACTIVITY")
public class PowerActivity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Long id;

    @Column(name= "IDATHLETE")
    private Long idathlete;

    @Column(name = "IDPOWERACTIVITY")
    private Long idpoweractivity;

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

    public PowerActivity() {}

    public PowerActivity(Long id, Long idathlete, Long idpoweractivity, float power, float speed, float hearthrate, float distance, float pace, float timezone) {
        this.id = id;
        this.idathlete = idathlete;
        this.idpoweractivity = idpoweractivity;
        this.power = power;
        this.speed = speed;
        this.hearthrate = hearthrate;
        this.distance = distance;
        this.pace = pace;
        this.timezone = timezone;
    }

    public Long getId() {
        return id;
    }

    public Long getIdathlete() {
        return idathlete;
    }

    public Long getIdpoweractivity() {
        return idpoweractivity;
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

    public float getPace() { return pace;}

    public float getTimezone() {
        return timezone;
    }

    @Override
    public String toString() {
        return "PowerActivity{" +
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

}
