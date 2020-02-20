package com.runpowerback.runpowerback.domaine;

public interface PressureSaturationRepository {

    Long save (PressureSaturation pressureSaturation);
    PressureSaturation findOnePressureSaturation(float temperature);

}
