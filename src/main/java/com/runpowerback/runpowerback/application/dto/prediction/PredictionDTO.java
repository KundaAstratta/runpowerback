package com.runpowerback.runpowerback.application.dto.prediction;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PredictionDTO {

    @JsonProperty
    public Long idathlete;

    @JsonProperty
    public Long idpoweractivity;

    @JsonProperty
    public float powerOptimal;

    @JsonProperty
    public float speedOptimal;

    @JsonProperty
    public String paceOptimal;

    @JsonProperty
    public String paceEasy;

    @JsonProperty
    public String paceThreshold;

    @JsonProperty
    public String paceHard;

    @JsonProperty
    public String paceMin;

    @JsonProperty
    public String paceMax;

    @JsonProperty
    public String paceMarathon;

    @JsonProperty
    public String timeForMarathon;

    @JsonProperty
    public String paceHalfMarathon;

    @JsonProperty
    public String timeForHalfMarathon;

    @JsonProperty
    public String paceTenKm;

    @JsonProperty
    public String timeForTenKm;

    public PredictionDTO(Long idathlete, Long idpoweractivity, float powerOptimal, float speedOptimal,
                         String paceOptimal, String paceEasy, String paceThreshold, String paceHard, String paceMin, String paceMax,
                         String paceMarathon, String timeForMarathon, String paceHalfMarathon, String timeForHalfMarathon,
                         String paceTenKm, String timeForTenKm) {
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

    @Override
    public String toString() {
        return "PredictionDTO [idathlete=" + idathlete + ", idpoweractivity=" + idpoweractivity
                + ", paceEasy=" + paceEasy + ", paceHalfMarathon=" + paceHalfMarathon + ", paceHard=" + paceHard
                + ", paceMarathon=" + paceMarathon + ", paceMax=" + paceMax + ", paceMin=" + paceMin + ", paceOptimal="
                + paceOptimal + ", paceTenKm=" + paceTenKm + ", paceThreshold=" + paceThreshold + ", powerOptimal="
                + powerOptimal + ", speedOptimal=" + speedOptimal + ", timeForHalfMarathon=" + timeForHalfMarathon
                + ", timeForMarathon=" + timeForMarathon + ", timeForTenKm=" + timeForTenKm + "]";
    }

}

