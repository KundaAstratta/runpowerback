package com.runpowerback.runpowerback.application.dto.activity;

import com.runpowerback.runpowerback.domaine.entity.ActivityPointOf;

import java.util.List;
import java.util.stream.Collectors;

public class ActivityMapper {

    public ActivityMapper() {
    }

    public static ActivityPointOf mapToOnePointActivity(ActivityPointOfDTO activityDTO) {
        return new ActivityPointOf(null,
                            activityDTO.latitude,
                            activityDTO.longitude,
                            activityDTO.elevation,
                            activityDTO.hearthrate,
                            activityDTO.timezone
        );
    }

    public static ActivityPointOfDTO mapToOnePointActivityDTO(ActivityPointOf activity) {
        return new ActivityPointOfDTO(
                                activity.getLatitude(),
                                activity.getLongitude(),
                                activity.getElevation(),
                                activity.getHearthrate(),
                                activity.getTimezone()
        );
    }

    public static List<ActivityPointOfDTO> mapToOneActivity (List<ActivityPointOf> oneActivity) {
        return oneActivity.stream().map(ActivityMapper::mapToOnePointActivityDTO).collect(Collectors.toList());
    }

}
