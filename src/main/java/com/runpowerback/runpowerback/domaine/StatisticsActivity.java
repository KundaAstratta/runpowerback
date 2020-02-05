package com.runpowerback.runpowerback.domaine;

import javax.persistence.*;

@Entity(name="STATISTICS_ACTIVITY")
public class StatisticsActivity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Long id;

    @Column(name= "ID_ATHLETE")
    private Long idathlete;

    @Column(name = "ID_POWERACTIVITY")
    private Long idpoweractivity;

    @Column(name="POWERAVERAGE")
    private float poweraverage;

    @Column(name = "POWERMEDIAN")
    private float powermedian;


    @Column(name ="DEVIATION")
    private float deviation;

    public StatisticsActivity() {}

    public StatisticsActivity(Long id, Long idathlete, Long idpoweractivity, float poweraverage, float powermedian, float deviation) {
        this.id = id;
        this.idathlete = idathlete;
        this.idpoweractivity = idpoweractivity;
        this.poweraverage = poweraverage;
        this.powermedian = powermedian;
        this.deviation = deviation;
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

    public float getPoweraverage() {
        return poweraverage;
    }

    public float getPowermedian() {
        return powermedian;
    }

    public float getDeviation() {
        return deviation;
    }

    @Override
    public String toString() {
        return "StatisticsActivity{" +
                "id=" + id +
                ", idathlete=" + idathlete +
                ", idpoweractivity=" + idpoweractivity +
                ", poweraverage=" + poweraverage +
                ", powermedian=" + powermedian +
                ", deviation=" + deviation +
                '}';
    }
}
