package com.runpowerback.runpowerback.domaine.entity;

public class PowerActivityFireBase {

    private String powerActivtyFireBaseIdentity;

    private String date;

    public PowerActivityFireBase(String powerActivtyFireBaseIdentity, String date) {
        this.powerActivtyFireBaseIdentity = powerActivtyFireBaseIdentity;
        this.date = date;
    }

    public String getPowerActivtyFireBaseIdentity() {
        return powerActivtyFireBaseIdentity;
    }

    public String getDate() {
        return date;
    }

}
