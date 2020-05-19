package com.runpowerback.runpowerback.exposition;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StatisticsActivityDTO {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    public Long id;

    @JsonProperty
    public Long idathlete;

    @JsonProperty
    public Long idpoweractivity;

    @JsonProperty
    public float poweraverage;

    @JsonProperty
    public float powermedian;

    @JsonProperty
    public float deviation;

    @JsonProperty
    public float powerscore;

    @JsonProperty
    public int nbrofeasy;

    @JsonProperty
    public int nbrofmarathon;

    @JsonProperty
    public int nbrofthreshold;

    @JsonProperty
    public int nbrofinterval;

    @JsonProperty
    public int nbrofrepetition;

    @JsonProperty
    public String date;

    public StatisticsActivityDTO() {}

    public StatisticsActivityDTO(Long id, Long idathlete, Long idpoweractivity, float poweraverage, float powermedian,
            float deviation, float powerscore, int nbrofeasy, int nbrofmarathon, int nbrofthreshold,
            int nbrofinterval, int nbrofrepetition, String date) {
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
        final StringBuffer sb = new StringBuffer("StatisticsActivityDTO{");
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
        sb.append(", powerscore=").append(powerscore);
        sb.append(", date=").append(date);
        sb.append('}');
        return sb.toString();
    }

   

}
