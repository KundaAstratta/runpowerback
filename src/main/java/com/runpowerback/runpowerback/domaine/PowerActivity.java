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
        final StringBuffer sb = new StringBuffer("PowerActivity{");
        sb.append("id=").append(id);
        sb.append(", idathlete=").append(idathlete);
        sb.append(", idpoweractivity=").append(idpoweractivity);
        sb.append(", power=").append(power);
        sb.append(", speed=").append(speed);
        sb.append(", hearthrate=").append(hearthrate);
        sb.append(", distance=").append(distance);
        sb.append(", pace=").append(pace);
        sb.append(", timezone=").append(timezone);
        sb.append('}');
        return sb.toString();
    }
}
