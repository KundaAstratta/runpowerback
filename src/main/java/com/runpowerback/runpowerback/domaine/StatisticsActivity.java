package com.runpowerback.runpowerback.domaine;

import javax.persistence.*;

@Entity(name="STATISTICSACTIVITY")
public class StatisticsActivity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Long id;

    @Column(name= "IDATHLETE")
    private Long idathlete;

    @Column(name = "IDPOWERACTIVITY")
    private Long idpoweractivity;

    @Column(name="POWERAVERAGE")
    private float poweraverage;

    @Column(name = "POWERMEDIAN")
    private float powermedian;

    @Column(name ="DEVIATION")
    private float deviation;

    @Column(name="POWERSCORE")
    private float powerscore;

    public StatisticsActivity() {}

    public StatisticsActivity(Long id, Long idathlete, Long idpoweractivity, float poweraverage, float powermedian, float deviation, float powerscore) {
        this.id = id;
        this.idathlete = idathlete;
        this.idpoweractivity = idpoweractivity;
        this.poweraverage = poweraverage;
        this.powermedian = powermedian;
        this.deviation = deviation;
        this.powerscore = powerscore;
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

    public float getPowerscore() {
        return powerscore;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("StatisticsActivity{");
        sb.append("id=").append(id);
        sb.append(", idathlete=").append(idathlete);
        sb.append(", idpoweractivity=").append(idpoweractivity);
        sb.append(", poweraverage=").append(poweraverage);
        sb.append(", powermedian=").append(powermedian);
        sb.append(", deviation=").append(deviation);
        sb.append(", powerscore=").append(powerscore);
        sb.append('}');
        return sb.toString();
    }
}
