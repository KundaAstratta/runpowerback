package com.runpowerback.runpowerback.domaine;

import javax.persistence.*;

@Entity(name="pressuresaturationversustemperature")
public class PressureSaturationVersusTemperature {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Long id;

    @Column(name="temperature")
    private float temperature;

    @Column(name="pressure")
    private float pressure;

}
