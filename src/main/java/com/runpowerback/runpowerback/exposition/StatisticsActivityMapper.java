package com.runpowerback.runpowerback.exposition;

import com.runpowerback.runpowerback.domaine.StatisticsActivity;

import java.util.List;
import java.util.stream.Collectors;

public class StatisticsActivityMapper {

    public StatisticsActivityMapper() {
    }

    public static StatisticsActivity mapToOneStatisticsActivity (StatisticsActivityDTO statisticsActivityDTO) {
        return new StatisticsActivity(
          null,
          statisticsActivityDTO.idathlete,
          statisticsActivityDTO.idpoweractivity,
          statisticsActivityDTO.poweraverage,
          statisticsActivityDTO.powermedian,
          statisticsActivityDTO.deviation,
          statisticsActivityDTO.powerscore,
          statisticsActivityDTO.date
        );
    }

    public static StatisticsActivityDTO mapToOneStatisticsActivityDTO (StatisticsActivity statisticsActivity) {
        return new StatisticsActivityDTO(
          statisticsActivity.getId(),
          statisticsActivity.getIdathlete(),
          statisticsActivity.getIdpoweractivity(),
          statisticsActivity.getPoweraverage(),
          statisticsActivity.getPowermedian(),
          statisticsActivity.getDeviation(),
          statisticsActivity.getPowerscore(),
          statisticsActivity.getDate()
        );
    }

    public static List<StatisticsActivityDTO> mapToListStatisticsActivityDTO (List<StatisticsActivity> statisticsActivityList) {
        return statisticsActivityList.stream().map(StatisticsActivityMapper::mapToOneStatisticsActivityDTO).collect(Collectors.toList());
    }

}
