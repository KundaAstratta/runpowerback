package com.runpowerback.runpowerback.domaine;

public class PowerActivity {

    private Long id;
    private String power;
    private String speed;
    private String hearthrate;
    private String distance;
    private String timezone;

    public PowerActivity() {}

    public PowerActivity(Long id, String power, String speed, String hearthrate, String distance, String timezone) {
        this.id = id;
        this.power = power;
        this.speed = speed;
        this.hearthrate = hearthrate;
        this.distance = distance;
        this.timezone = timezone;
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
        return "PowerActivity{" +
                "id=" + id +
                ", power='" + power + '\'' +
                ", speed='" + speed + '\'' +
                ", hearthrate='" + hearthrate + '\'' +
                ", distance='" + distance + '\'' +
                ", timezone='" + timezone + '\'' +
                '}';
    }

}
