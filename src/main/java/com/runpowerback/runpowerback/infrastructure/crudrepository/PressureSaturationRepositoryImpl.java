package com.runpowerback.runpowerback.infrastructure.crudrepository;

import com.runpowerback.runpowerback.domaine.entity.PressureSaturation;
import com.runpowerback.runpowerback.domaine.repository.PressureSaturationRepository;
import com.runpowerback.runpowerback.domaine.exception.ErrorCodes;
import com.runpowerback.runpowerback.domaine.exception.MyProjectException500;
import com.runpowerback.runpowerback.infrastructure.dao.PressureSaturationDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Profile({"local","cloud"})
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
