package com.runpowerback.runpowerback.application.dto.powerActivity;

import com.runpowerback.runpowerback.domaine.entity.PowerActivity;
import java.util.List;
import java.util.stream.Collectors;

public class PowerActivityMapper {

    public PowerActivityMapper() {}

    public static PowerActivity mapToOnePointOfPowerActivity(PowerActivityDTO powerActivityDTO) {
        return new PowerActivity(null,
                powerActivityDTO.idathlete,
                powerActivityDTO.idpoweractivity,
                powerActivityDTO.power,
                powerActivityDTO.speed,
                powerActivityDTO.hearthrate,
                powerActivityDTO.distance,
                powerActivityDTO.pace,
                powerActivityDTO.timezone
        );
    }

    public static PowerActivityDTO mapToOnePointOfPowerActivityDTO(PowerActivity powerActivity) {
        return new PowerActivityDTO(powerActivity.getId(),
                                    powerActivity.getIdathlete(),
                                    powerActivity.getIdpoweractivity(),
                                    powerActivity.getPower(),
                                    powerActivity.getSpeed(),
                                    powerActivity.getHearthrate(),
                                    powerActivity.getDistance(),
                                    powerActivity.getPace(),
                                    powerActivity.getTimezone());
    }

    public static List<PowerActivityDTO> mapToOnePowerActivity (List<PowerActivity> onePowerActivity) {
        return onePowerActivity.stream().map(PowerActivityMapper::mapToOnePointOfPowerActivityDTO).collect(Collectors.toList());
    }

}