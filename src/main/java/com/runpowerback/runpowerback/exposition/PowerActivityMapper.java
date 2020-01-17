package com.runpowerback.runpowerback.exposition;

import com.runpowerback.runpowerback.domaine.Activity;
import com.runpowerback.runpowerback.domaine.PowerActivity;

import java.util.List;
import java.util.stream.Collectors;

public class PowerActivityMapper {

    public PowerActivityMapper() {}

    public static PowerActivity mapToOnePointOfPowerActivity(PowerActivityDTO powerActivityDTO) {
        return new PowerActivity(null,
                powerActivityDTO.power,
                powerActivityDTO.speed,
                powerActivityDTO.hearthrate,
                powerActivityDTO.distance,
                powerActivityDTO.timezone
        );
    }

    public static PowerActivityDTO mapToOnePointOfPowerActivityDTO(PowerActivity powerActivity) {
        return new PowerActivityDTO(powerActivity.getId(),
                                    powerActivity.getPower(),
                                    powerActivity.getSpeed(),
                                    powerActivity.getHearthrate(),
                                    powerActivity.getDistance(),
                                    powerActivity.getTimezone());
    }

    public static List<PowerActivityDTO> mapToOnePowerActivity (List<PowerActivity> onePowerActivity) {
        return onePowerActivity.stream().map(PowerActivityMapper::mapToOnePointOfPowerActivityDTO).collect(Collectors.toList());
    }

}
