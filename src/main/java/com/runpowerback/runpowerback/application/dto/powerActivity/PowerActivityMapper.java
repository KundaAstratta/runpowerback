package com.runpowerback.runpowerback.application.dto.powerActivity;

import com.runpowerback.runpowerback.domaine.entity.PowerActivityPointOf;
import java.util.List;
import java.util.stream.Collectors;

public class PowerActivityMapper {

    public PowerActivityMapper() {}

    public static PowerActivityPointOf mapToOnePointOfPowerActivity(PowerActivityPointOfDTO powerActivityDTO) {
        return new PowerActivityPointOf(null,
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

    public static PowerActivityPointOfDTO mapToOnePointOfPowerActivityDTO(PowerActivityPointOf powerActivity) {
        return new PowerActivityPointOfDTO(
                                    powerActivity.getIdathlete(),
                                    powerActivity.getIdpoweractivity(),
                                    powerActivity.getPower(),
                                    powerActivity.getSpeed(),
                                    powerActivity.getHearthrate(),
                                    powerActivity.getDistance(),
                                    powerActivity.getPace(),
                                    powerActivity.getTimezone());
    }

    public static List<PowerActivityPointOfDTO> mapToOnePowerActivity (List<PowerActivityPointOf> onePowerActivity) {
        return onePowerActivity.stream().map(PowerActivityMapper::mapToOnePointOfPowerActivityDTO).collect(Collectors.toList());
    }

}
