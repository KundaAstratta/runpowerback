package com.runpowerback.runpowerback.infrastructure.inmemory;


import com.runpowerback.runpowerback.domaine.entity.PressureSaturation;
import com.runpowerback.runpowerback.domaine.exception.ErrorCodes;
import com.runpowerback.runpowerback.domaine.exception.MyProjectException500;
import com.runpowerback.runpowerback.domaine.repository.PressureSaturationRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Profile({"in-memory"})
@Repository
public class PressureSaturationInMemoryRepositoryImpl implements PressureSaturationRepository {

    List<PressureSaturation> pressureSaturationList = new ArrayList<>();

    @Override
    public Long save(PressureSaturation pressureSaturation) {
        pressureSaturationList.add(pressureSaturation);
        return pressureSaturationList.get(pressureSaturationList.size()-1).getId();
    }

    @Override
    public PressureSaturation findOnePressureSaturation(float temperature) {
        PressureSaturation pressureSaturationFound =   pressureSaturationList.stream()
                .filter(index -> index.getTemperature() == temperature)
                .findFirst()
                .orElse(null);

        if (pressureSaturationFound == null) {
            throw new MyProjectException500(ErrorCodes.NOT_FOUND);
        } else {
            return pressureSaturationFound;
        }
    }
}
