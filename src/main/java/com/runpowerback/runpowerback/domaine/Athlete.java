package com.runpowerback.runpowerback.domaine;

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

    public Athlete() {}

    public Athlete(Long id, Long idathlete, String name, String surname, float mass, float hearthmax) {
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
        final StringBuffer sb = new StringBuffer("Athlete{");
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
