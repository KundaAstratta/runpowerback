package com.runpowerback.runpowerback.infrastructure;

import com.runpowerback.runpowerback.domaine.PressureSaturation;
import com.runpowerback.runpowerback.domaine.PressureSaturationRepository;
import com.runpowerback.runpowerback.domaine.exception.ErrorCodes;
import com.runpowerback.runpowerback.domaine.exception.MyProjectException500;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PressureSaturationRepositoryImpl implements PressureSaturationRepository {

    @Autowired
    PressureSaturationDAO pressureSaturationDAO;

    @Override
    public Long save(PressureSaturation pressureSaturation) {
        this.pressureSaturationDAO.save(pressureSaturation);
        return pressureSaturation.getId();
    }

    @Override
    public PressureSaturation findOnePressureSaturation(float temperature) {
        if (this.pressureSaturationDAO.findOnePressureSaturation(temperature) == null) {
            throw new MyProjectException500(ErrorCodes.NOT_FOUND);
        } else {
            return this.pressureSaturationDAO.findOnePressureSaturation(temperature);
        }
    }
}
