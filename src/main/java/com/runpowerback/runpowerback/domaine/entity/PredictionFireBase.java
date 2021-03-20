package com.runpowerback.runpowerback.domaine.entity;


public class PredictionFireBase {

  
    private String predictionFireBaseIdentity;
    
    private String powerOptimal;

    private String speedOptimal;

    private String paceOptimal;

    private String paceEasy;

    private String paceThreshold;

    private String paceHard;

    private String paceMin;

    private String paceMax;

    private String paceMarathon;

    private String timeForMarathon;

    private String paceHalfMarathon;

    private String timeForHalfMarathon;

    private String paceTenKm;

    private String timeForTenKm;

    public PredictionFireBase() {}

    public PredictionFireBase(String predictionFireBaseIdentity, String powerOptimal, String speedOptimal,
            String paceOptimal, String paceEasy, String paceThreshold, String paceHard, String paceMin, String paceMax,
            String paceMarathon, String timeForMarathon, String paceHalfMarathon, String timeForHalfMarathon,
            String paceTenKm, String timeForTenKm) {
        this.predictionFireBaseIdentity = predictionFireBaseIdentity;
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

    public String getPredictionFireBaseIdentity() {
        return predictionFireBaseIdentity;
    }

    public String getPowerOptimal() {
        return powerOptimal;
    }

    public String getSpeedOptimal() {
        return speedOptimal;
    }

    public String getPaceOptimal() {
        return paceOptimal;
    }

    public String getPaceEasy() {
        return paceEasy;
    }

    public String getPaceThreshold() {
        return paceThreshold;
    }
    public String getPaceHard() {
        return paceHard;
    }

    public String getPaceMin() {
        return paceMin;
    }

    public String getPaceMax() {
        return paceMax;
    }

    public String getPaceMarathon() {
        return paceMarathon;
    }

    public String getTimeForMarathon() {
        return timeForMarathon;
    }

    public String getPaceHalfMarathon() {
        return paceHalfMarathon;
    }

    public String getTimeForHalfMarathon() {
        return timeForHalfMarathon;
    }

    public String getPaceTenKm() {
        return paceTenKm;
    }

    public String getTimeForTenKm() {
        return timeForTenKm;
    }
    
}
