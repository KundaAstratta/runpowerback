package com.runpowerback.runpowerback.domaine.repository;

import com.runpowerback.runpowerback.domaine.entity.PressureSaturation;

public interface PressureSaturationRepository {

    Long save (PressureSaturation pressureSaturation);
    PressureSaturation findOnePressureSaturation(float temperature);

}
