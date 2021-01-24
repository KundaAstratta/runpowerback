package com.runpowerback.runpowerback.domaine;

import javax.persistence.*;

@Entity(name="EXTERNALCONDITION")
public class ExternalCondition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Long id;

    @Column(name="IDATHLETE")
    private Long idathlete;

    @Column(name="IDPOWERACTIVITY")
    private Long idpoweractivity;

    @Column(name="PRESSUREATM")
    private float pressureatm;

    @Column(name="TEMPERATURE")
    private float temperature;

    @Column(name="HUMIDITY")
    private float humidity;

    @Column(name="SPEEDWIND")
    private float speedwind;

    public ExternalCondition() {
    }

    public ExternalCondition(Long id, Long idathlete, Long idpoweractivity, float pressureatm, float temperature, float humidity, float speedwind) {
        this.id = id;
        this.idathlete = idathlete;
        this.idpoweractivity = idpoweractivity;
        this.pressureatm = pressureatm;
        this.temperature = temperature;
        this.humidity = humidity;
        this.speedwind = speedwind;
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

    public float getPressureatm() {
        return pressureatm;
    }

    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getSpeedwind() {
        return speedwind;
    }

    public void setIdpoweractivity(Long idpoweractivity) {
        this.idpoweractivity = idpoweractivity;
    }

    public void setPressureatm(float pressureatm) {
        this.pressureatm = pressureatm;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    public void setSpeedwind(float speedwind) {
        this.speedwind = speedwind;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ExternalCondition{");
        sb.append("id=").append(id);
        sb.append(", idathlete=").append(idathlete);
        sb.append(", idpoweractivity=").append(idpoweractivity);
        sb.append(", pressureatm=").append(pressureatm);
        sb.append(", temperature=").append(temperature);
        sb.append(", humidity=").append(humidity);
        sb.append(", speedwind=").append(speedwind);
        sb.append('}');
        return sb.toString();
    }

}
