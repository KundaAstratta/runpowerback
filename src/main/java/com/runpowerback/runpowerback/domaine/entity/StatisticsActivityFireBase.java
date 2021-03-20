package com.runpowerback.runpowerback.domaine.entity;

public class StatisticsActivityFireBase {

    private String statisticActivityFireBaseIdentity;

    private String nbrOfEasy;

    private String nbrOfMarathon;

    private String nbrOfThreshold;

    private String nbrOfInterval;

    private String nbrOfRepetition;

    public StatisticsActivityFireBase(String statisticActivityFireBaseIdentity, String nbrOfEasy, String nbrOfMarathon, String nbrOfThreshold, String nbrOfInterval, String nbrOfRepetition) {
        this.statisticActivityFireBaseIdentity = statisticActivityFireBaseIdentity;
        this.nbrOfEasy = nbrOfEasy;
        this.nbrOfMarathon = nbrOfMarathon;
        this.nbrOfThreshold = nbrOfThreshold;
        this.nbrOfInterval = nbrOfInterval;
        this.nbrOfRepetition = nbrOfRepetition;
    }

    public String getStatisticActivityFireBaseIdentity() {
        return statisticActivityFireBaseIdentity;
    }

    public String getNbrOfEasy() {
        return nbrOfEasy;
    }

    public String getNbrOfMarathon() {
        return nbrOfMarathon;
    }

    public String getNbrOfThreshold() {
        return nbrOfThreshold;
    }

    public String getNbrOfInterval() {
        return nbrOfInterval;
    }

    public String getNbrOfRepetition() {
        return nbrOfRepetition;
    }
}
