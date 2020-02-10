package com.runpowerback.runpowerback.exposition;

import com.runpowerback.runpowerback.domaine.StatisticsActivity;

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
          statisticsActivityDTO.powerscore
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
          statisticsActivity.getPowerscore()
        );
    }

}
