package com.runpowerback.runpowerback.exposition;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AthleteDTO {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    public Long id;

    @JsonProperty
    public Long idathete;

    @JsonProperty
    public String name;

    @JsonProperty
    public String surname;

    @JsonProperty
    public float mass;

    @JsonProperty
    public float hearthmax;

    public AthleteDTO() {}

    public AthleteDTO(Long id, Long idathete, String name, String surname, float mass, float hearthmax) {
        this.id = id;
        this.idathete = idathete;
        this.name = name;
        this.surname = surname;
        this.mass = mass;
        this.hearthmax = hearthmax;
    }

    public Long getId() {
        return id;
    }

    public Long getIdathete() {
        return idathete;
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

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("AthleteDTO{");
        sb.append("id=").append(id);
        sb.append(", idathete=").append(idathete);
        sb.append(", name='").append(name).append('\'');
        sb.append(", surname='").append(surname).append('\'');
        sb.append(", mass=").append(mass);
        sb.append(", hearthmax=").append(hearthmax);
        sb.append('}');
        return sb.toString();
    }

}
