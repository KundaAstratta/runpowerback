package com.runpowerback.runpowerback.domaine.entity;

import javax.persistence.*;

@Entity(name = "ATHLETE")
public class Athlete {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Long id;

    @Column(name="IDATHLETE")
    private Long idathlete;

    @Column(name="NAME")
    private String name;

    @Column(name="SURNAME")
    private String surname;

    @Column(name="MASS")
    private float mass;

    @Column(name="HEARTHMAX")
    private float hearthmax;

    @Column(name="EASYHEARTHMIN")
    private float easyhearthmin;

    @Column(name="EASYHEARTHMAX")
    private float easyhearthmax;

    @Column(name="MARATHONHEARTHMIN")
    private float marathonhearthmin;

    @Column(name="MARATHONHEARTHMAX")
    private float marathonhearthmax;

    @Column(name="THRESHOLDHEARTHMIN")
    private float thresholdhearthmin;

    @Column(name="THRESHOLDHEARTHMAX")
    private float thresholdhearthmax;

    @Column(name="INTERVALHEARTHMIN")
    private float intervalhearthmin;

    @Column(name="INTERVALHEARTHMAX")
    private float intervalhearthmax;

    @Column(name="REPETITIONHEARTHMIN")
    private float repetitionhearthmin;

    @Column(name="REPETITIONHEARTHMAX")
    private float repetitionhearthmax;

    public Athlete() {}

    public Athlete(Long id, Long idathlete, String name, String surname, float mass, float hearthmax) {
        this.id = id;
        this.idathlete = idathlete;
        this.name = name;
        this.surname = surname;
        this.mass = mass;
        this.hearthmax = hearthmax;
    }

    public Athlete(Long id, Long idathlete, String name, String surname, float mass, float hearthmax, float easyhearthmin, float easyhearthmax, float marathonhearthmin, float marathonhearthmax, float thresholdhearthmin, float thresholdhearthmax, float intervalhearthmin, float intervalhearthmax, float repetitionhearthmin, float repetitionhearthmax) {
        this.id = id;
        this.idathlete = idathlete;
        this.name = name;
        this.surname = surname;
        this.mass = mass;
        this.hearthmax = hearthmax;
        this.easyhearthmin = easyhearthmin;
        this.easyhearthmax = easyhearthmax;
        this.marathonhearthmin = marathonhearthmin;
        this.marathonhearthmax = marathonhearthmax;
        this.thresholdhearthmin = thresholdhearthmin;
        this.thresholdhearthmax = thresholdhearthmax;
        this.intervalhearthmin = intervalhearthmin;
        this.intervalhearthmax = intervalhearthmax;
        this.repetitionhearthmin = repetitionhearthmin;
        this.repetitionhearthmax = repetitionhearthmax;
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

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public float getMass() {
        return mass;
    }

    public float getHearthmax() {
        return hearthmax;
    }

    public float getEasyhearthmin() {
        return easyhearthmin;
    }

    public float getEasyhearthmax() {
        return easyhearthmax;
    }

    public float getMarathonhearthmin() {
        return marathonhearthmin;
    }

    public float getMarathonhearthmax() {
        return marathonhearthmax;
    }

    public float getThresholdhearthmin() {
        return thresholdhearthmin;
    }

    public float getThresholdhearthmax() {
        return thresholdhearthmax;
    }

    public float getIntervalhearthmin() {
        return intervalhearthmin;
    }

    public float getIntervalhearthmax() {
        return intervalhearthmax;
    }

    public float getRepetitionhearthmin() {
        return repetitionhearthmin;
    }

    public float getRepetitionhearthmax() {
        return repetitionhearthmax;
    }

    public void setEasyhearthmin(float easyhearthmin) {
        this.easyhearthmin = easyhearthmin;
    }

    public void setEasyhearthmax(float easyhearthmax) {
        this.easyhearthmax = easyhearthmax;
    }

    public void setMarathonhearthmin(float marathonhearthmin) {
        this.marathonhearthmin = marathonhearthmin;
    }

    public void setMarathonhearthmax(float marathonhearthmax) {
        this.marathonhearthmax = marathonhearthmax;
    }

    public void setThresholdhearthmin(float thresholdhearthmin) {
        this.thresholdhearthmin = thresholdhearthmin;
    }

    public void setThresholdhearthmax(float thresholdhearthmax) {
        this.thresholdhearthmax = thresholdhearthmax;
    }

    public void setIntervalhearthmin(float intervalhearthmin) {
        this.intervalhearthmin = intervalhearthmin;
    }

    public void setIntervalhearthmax(float intervalhearthmax) {
        this.intervalhearthmax = intervalhearthmax;
    }

    public void setRepetitionhearthmin(float repetitionhearthmin) {
        this.repetitionhearthmin = repetitionhearthmin;
    }

    public void setRepetitionhearthmax(float repetitionhearthmax) {
        this.repetitionhearthmax = repetitionhearthmax;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Athlete{");
        sb.append("id=").append(id);
        sb.append(", idathlete=").append(idathlete);
        sb.append(", name='").append(name).append('\'');
        sb.append(", surname='").append(surname).append('\'');
        sb.append(", mass=").append(mass);
        sb.append(", hearthmax=").append(hearthmax);
        sb.append(", easyhearthmin=").append(easyhearthmin);
        sb.append(", easyhearthmax=").append(easyhearthmax);
        sb.append(", marathonhearthmin=").append(marathonhearthmin);
        sb.append(", marathonhearthmax=").append(marathonhearthmax);
        sb.append(", thresholdhearthmin=").append(thresholdhearthmin);
        sb.append(", thresholdhearthmax=").append(thresholdhearthmax);
        sb.append(", repetitionhearthmin=").append(repetitionhearthmin);
        sb.append(", repetitionhearthmax=").append(repetitionhearthmax);
        sb.append(", intervalhearthmin=").append(intervalhearthmin);
        sb.append(", intervalhearthmax=").append(intervalhearthmax);
        sb.append('}');
        return sb.toString();
    }

}
