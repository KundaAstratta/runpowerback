package com.runpowerback.runpowerback.exposition;

import com.runpowerback.runpowerback.domaine.Activity;

import java.util.List;
import java.util.stream.Collectors;

public class ActivityMapper {

    public ActivityMapper() {
    }

    public static Activity mapToOnePointActivity(ActivityDTO activityDTO) {
        return new Activity(null,
                            activityDTO.latitude,
                            activityDTO.longitude,
                            activityDTO.elevation,
                            activityDTO.hearthrate,
                            activityDTO.timezone
        );
    }

    public static ActivityDTO mapToOnePointActivityDTO(Activity activity) {
        return new ActivityDTO(activity.getId(),
                                activity.getLatitude(),
                                activity.getLongitude(),
                                activity.getElevation(),
                                activity.getHearthrate(),
                                activity.getTimezone()
        );
    }

    public static List<ActivityDTO> mapToOneActivity (List<Activity> oneActivity) {
        return oneActivity.stream().map(ActivityMapper::mapToOnePointActivityDTO).collect(Collectors.toList());
    }

}
