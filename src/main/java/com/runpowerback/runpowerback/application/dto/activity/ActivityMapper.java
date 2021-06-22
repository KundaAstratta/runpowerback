package com.runpowerback.runpowerback.application.dto.activity;

import com.runpowerback.runpowerback.domaine.entity.ActivityPointOf;

import java.util.List;
import java.util.stream.Collectors;

public class ActivityMapper {

    public ActivityMapper() {
    }

    public static ActivityPointOf mapToOnePointActivity(ActivityPoinfOfDTO activityDTO) {
        return new ActivityPointOf(null,
                            activityDTO.latitude,
                            activityDTO.longitude,
                            activityDTO.elevation,
                            activityDTO.hearthrate,
                            activityDTO.timezone
        );
    }

    public static ActivityPoinfOfDTO mapToOnePointActivityDTO(ActivityPointOf activity) {
        return new ActivityPoinfOfDTO(activity.getId(),
                                activity.getLatitude(),
                                activity.getLongitude(),
                                activity.getElevation(),
                                activity.getHearthrate(),
                                activity.getTimezone()
        );
    }

    public static List<ActivityPoinfOfDTO> mapToOneActivity (List<ActivityPointOf> oneActivity) {
        return oneActivity.stream().map(ActivityMapper::mapToOnePointActivityDTO).collect(Collectors.toList());
    }

}
