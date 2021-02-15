package com.runpowerback.runpowerback.domaine.entity;

import javax.persistence.*;

@Entity(name="pressuresaturation")
public class PressureSaturation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Long id;

    @Column(name="temperature")
    private float temperature;

    @Column(name="pressure")
    private float pressure;

    public PressureSaturation() {}

    public PressureSaturation(Long id, float temperature, float pressure) {
        this.id = id;
        this.temperature = temperature;
        this.pressure = pressure;
    }

    public Long getId() {
        return id;
    }

    public float getTemperature() {
        return temperature;
    }

    public float getPressure() {
        return pressure;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("PressureSaturation{");
        sb.append("id=").append(id);
        sb.append(", temperature=").append(temperature);
        sb.append(", pressure=").append(pressure);
        sb.append('}');
        return sb.toString();
    }
}
