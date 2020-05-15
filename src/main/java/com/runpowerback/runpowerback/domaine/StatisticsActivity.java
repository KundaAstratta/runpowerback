package com.runpowerback.runpowerback.domaine;

import javax.persistence.*;

@Entity(name="STATISTICSACTIVITY")
public class StatisticsActivity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Long id;

    @Column(name="IDATHLETE")
    private Long idathlete;

    @Column(name="IDPOWERACTIVITY")
    private Long idpoweractivity;

    @Column(name="POWERAVERAGE")
    private float poweraverage;

    @Column(name="POWERMEDIAN")
    private float powermedian;

    @Column(name="DEVIATION")
    private float deviation;

    @Column(name="POWERSCORE")
    private float powerscore;

    @Column(name="NBROFEASY")
    private int nbrofeasy;

    @Column(name="NBROFMARATHON")
    private int nbrofmarathon;

    @Column(name="NBROFTHRESHHOLD")
    private int nbrofthreshold;

    @Column(name="NBROFINTERVAL")
    private int nbrofinterval;

    @Column(name="NBROFREPETITION")
    private int nbrofrepetition;

    @Column(name="DATE")
    private String date;

    public StatisticsActivity() {}

    public StatisticsActivity(Long id, Long idathlete, Long idpoweractivity, float poweraverage, float powermedian, float deviation, float powerscore, int nbrofeasy, int nbrofmarathon, int nbrofthreshold, int nbrofinterval, int nbrofrepetition, String date) {
        this.id = id;
        this.idathlete = idathlete;
        this.idpoweractivity = idpoweractivity;
        this.poweraverage = poweraverage;
        this.powermedian = powermedian;
        this.deviation = deviation;
        this.powerscore = powerscore;
        this.nbrofeasy = nbrofeasy;
        this.nbrofmarathon = nbrofmarathon;
        this.nbrofthreshold = nbrofthreshold;
        this.nbrofinterval = nbrofinterval;
        this.nbrofrepetition = nbrofrepetition;
        this.date = date;
    }

    public StatisticsActivity(Long id, Long idathlete, Long idpoweractivity, float poweraverage, float powermedian, float deviation, float powerscore, String date) {
        this.id = id;
        this.idathlete = idathlete;
        this.idpoweractivity = idpoweractivity;
        this.poweraverage = poweraverage;
        this.powermedian = powermedian;
        this.deviation = deviation;
        this.powerscore = powerscore;
        this.date = date;
    }

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

    public void setIdpoweractivity(Long idpoweractivity) {
        this.idpoweractivity = idpoweractivity;
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

    public int getNbrofeasy() {
        return nbrofeasy;
    }

    public int getNbrofmarathon() {
        return nbrofmarathon;
    }

    public int getNbrofthreshold() {
        return nbrofthreshold;
    }

    public int getNbrofinterval() {
        return nbrofinterval;
    }

    public int getNbrofrepetition() {
        return nbrofrepetition;
    }

    public String getDate() {
        return date;
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
        sb.append(", nbrofeasy=").append(nbrofeasy);
        sb.append(", nbrofmarathon=").append(nbrofmarathon);
        sb.append(", nbrofthreshold=").append(nbrofthreshold);
        sb.append(", nbrofinterval=").append(nbrofinterval);
        sb.append(", nbrofrepetition=").append(nbrofrepetition);
        sb.append(", date='").append(date).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
