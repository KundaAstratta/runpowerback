package com.runpowerback.runpowerback.domaine;

public class PowerActivity {

    private Long id;
    private float power;
    private float speed;
    private float hearthrate;
    private float distance;
    private float pace;
    private float timezone;

    public PowerActivity() {}

    public PowerActivity(Long id, float power, float speed, float hearthrate, float distance, float pace, float timezone) {
        this.id = id;
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
                ", power='" + power + '\'' +
                ", speed='" + speed + '\'' +
                ", hearthrate='" + hearthrate + '\'' +
                ", distance='" + distance + '\'' +
                ", pace='" + pace + '\'' +
                ", timezone='" + timezone + '\'' +
                '}';
    }

}
