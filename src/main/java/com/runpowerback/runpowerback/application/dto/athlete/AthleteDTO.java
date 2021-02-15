package com.runpowerback.runpowerback.application.dto.athlete;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AthleteDTO {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    public Long id;

    @JsonProperty
    public Long idathlete;

    @JsonProperty
    public String name;

    @JsonProperty
    public String surname;

    @JsonProperty
    public float mass;

    @JsonProperty
    public float hearthmax;

    public AthleteDTO(Long id, Long idathlete, String name, String surname, float mass, float hearthmax) {
        this.id = id;
        this.idathlete = idathlete;
        this.name = name;
        this.surname = surname;
        this.mass = mass;
        this.hearthmax = hearthmax;
    }

    public Long getId() {
        return id;
    }

    public Long getIdathlete() {
        return idathlete;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("AthleteDTO{");
        sb.append("id=").append(id);
        sb.append(", idathlete=").append(idathlete);
        sb.append(", name='").append(name).append('\'');
        sb.append(", surname='").append(surname).append('\'');
        sb.append(", mass=").append(mass);
        sb.append(", hearthmax=").append(hearthmax);
        sb.append('}');
        return sb.toString();
    }

}
