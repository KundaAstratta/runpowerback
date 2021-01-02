package com.runpowerback.runpowerback.domaine;

import javax.persistence.*;

@Entity(name="PREDICTION")
public class Prediction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Long id;

    @Column(name="IDATHLETE")
    private Long idathlete;

    @Column(name="IDPOWERACTIVITY")
    private Long idpoweractivity;

    @Column(name = "POWEROPTIMAL")
    private float powerOptimal;

    @Column(name = "SPEEDOPTIMAL")
    private float speedOptimal;

    @Column(name = "PACEOPTIMAL")
    private String paceOptimal;

    @Column(name = "PACEEASY")
    private String paceEasy;

    @Column(name = "PACETHRESHOLD")
    private String paceThreshold;

    @Column(name = "PACEHARD")
    private String paceHard;

    @Column(name = "PACEMIN")
    private String paceMin;

    @Column(name = "PACEMAX")
    private String paceMax;

    @Column(name = "PACEMARATHON")
    private String paceMarathon;

    @Column(name ="TIMEFORMARATHON")
    private String timeForMarathon;

    @Column(name = "PACEFORHALFMARATHON")
    private String paceHalfMarathon;

    @Column(name = "TIMEFORHALFMARATHON")
    private String timeForHalfMarathon;

    @Column(name = "PACEFORTENKM")
    private String paceTenKm;

    @Column(name = "TIMEFORTENKM")
    private String timeForTenKm;

    public Prediction() {}

    public Prediction(Long id, Long idathlete, Long idpoweractivity, float powerOptimal, float speedOptimal,
                      String paceOptimal, String paceEasy, String paceThreshold, String paceHard, String paceMin, String paceMax,
                      String paceMarathon, String timeForMarathon, String paceHalfMarathon, String timeForHalfMarathon,
                      String paceTenKm, String timeForTenKm) {
        this.id = id;
        this.idathlete = idathlete;
        this.idpoweractivity = idpoweractivity;
        this.powerOptimal = powerOptimal;
        this.speedOptimal = speedOptimal;
        this.paceOptimal = paceOptimal;
        this.paceEasy = paceEasy;
        this.paceThreshold = paceThreshold;
        this.paceHard = paceHard;
        this.paceMin = paceMin;
        this.paceMax = paceMax;
        this.paceMarathon = paceMarathon;
        this.timeForMarathon = timeForMarathon;
        this.paceHalfMarathon = paceHalfMarathon;
        this.timeForHalfMarathon = timeForHalfMarathon;
        this.paceTenKm = paceTenKm;
        this.timeForTenKm = timeForTenKm;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdathlete() {
        return idathlete;
    }

    public void setIdathlete(Long idathlete) {
        this.idathlete = idathlete;
    }

    public Long getIdpoweractivity() {
        return idpoweractivity;
    }

    public void setIdpoweractivity(Long idpoweractivity) {
        this.idpoweractivity = idpoweractivity;
    }

    public float getPowerOptimal() {
        return powerOptimal;
    }

    public void setPowerOptimal(float powerOptimal) {
        this.powerOptimal = powerOptimal;
    }

    public float getSpeedOptimal() {
        return speedOptimal;
    }

    public void setSpeedOptimal(float speedOptimal) {
        this.speedOptimal = speedOptimal;
    }

    public String getPaceOptimal() {
        return paceOptimal;
    }

    public void setPaceOptimal(String paceOptimal) {
        this.paceOptimal = paceOptimal;
    }

    public String getPaceEasy() {
        return paceEasy;
    }

    public void setPaceEasy(String paceEasy) {
        this.paceEasy = paceEasy;
    }

    public String getPaceThreshold() {
        return paceThreshold;
    }

    public void setPaceThreshold(String paceThreshold) {
        this.paceThreshold = paceThreshold;
    }

    public String getPaceHard() {
        return paceHard;
    }

    public void setPaceHard(String paceHard) {
        this.paceHard = paceHard;
    }

    public String getPaceMin() {
        return paceMin;
    }

    public void setPaceMin(String paceMin) {
        this.paceMin = paceMin;
    }

    public String getPaceMax() {
        return paceMax;
    }

    public void setPaceMax(String paceMax) {
        this.paceMax = paceMax;
    }

    public String getPaceMarathon() {
        return paceMarathon;
    }

    public void setPaceMarathon(String paceMarathon) {
        this.paceMarathon = paceMarathon;
    }

    public String getTimeForMarathon() {
        return timeForMarathon;
    }

    public void setTimeForMarathon(String timeForMarathon) {
        this.timeForMarathon = timeForMarathon;
    }

    public String getPaceHalfMarathon() {
        return paceHalfMarathon;
    }

    public void setPaceHalfMarathon(String paceHalfMarathon) {
        this.paceHalfMarathon = paceHalfMarathon;
    }

    public String getTimeForHalfMarathon() {
        return timeForHalfMarathon;
    }

    public void setTimeForHalfMarathon(String timeForHalfMarathon) {
        this.timeForHalfMarathon = timeForHalfMarathon;
    }

    public String getPaceTenKm() {
        return paceTenKm;
    }

    public void setPaceTenKm(String paceTenKm) {
        this.paceTenKm = paceTenKm;
    }

    public String getTimeForTenKm() {
        return timeForTenKm;
    }

    public void setTimeForTenKm(String timeForTenKm) {
        this.timeForTenKm = timeForTenKm;
    }

    @Override
    public String toString() {
        return "Prediction [id=" + id + ", idathlete=" + idathlete + ", idpoweractivity=" + idpoweractivity
                + ", paceEasy=" + paceEasy + ", paceHalfMarathon=" + paceHalfMarathon + ", paceHard=" + paceHard
                + ", paceMarathon=" + paceMarathon + ", paceMax=" + paceMax + ", paceMin=" + paceMin + ", paceOptimal="
                + paceOptimal + ", paceTenKm=" + paceTenKm + ", paceThreshold=" + paceThreshold + ", powerOptimal="
                + powerOptimal + ", speedOptimal=" + speedOptimal + ", timeForHalfMarathon=" + timeForHalfMarathon
                + ", timeForMarathon=" + timeForMarathon + ", timeForTenKm=" + timeForTenKm + "]";
    }


}
