package com.runpowerback.runpowerback.application.dto.statisticsActivity;

import com.runpowerback.runpowerback.domaine.entity.StatisticsActivity;

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
          statisticsActivityDTO.nbrofeasy,
          statisticsActivityDTO.nbrofmarathon,
          statisticsActivityDTO.nbrofthreshold,
          statisticsActivityDTO.nbrofinterval,
          statisticsActivityDTO.nbrofrepetition,
          statisticsActivityDTO.date,
          statisticsActivityDTO.powerfirstquartil,
          statisticsActivityDTO.deltafirstquartil,
          statisticsActivityDTO.powerthirdquartil,
          statisticsActivityDTO.deltathirdquartil
        );
    }

    public static StatisticsActivityDTO mapToOneStatisticsActivityDTO (StatisticsActivity statisticsActivity) {
        return new StatisticsActivityDTO(
          statisticsActivity.getIdathlete(),
          statisticsActivity.getIdpoweractivity(),
          statisticsActivity.getPoweraverage(),
          statisticsActivity.getPowermedian(),
          statisticsActivity.getDeviation(),
          statisticsActivity.getPowerscore(),
          statisticsActivity.getNbrofeasy(),
          statisticsActivity.getNbrofmarathon(),
          statisticsActivity.getNbrofthreshold(),
          statisticsActivity.getNbrofinterval(),
          statisticsActivity.getNbrofrepetition(),
          statisticsActivity.getDate(),
          statisticsActivity.getPowerfirstquartil(),
          statisticsActivity.getDeltafirstquartil(),
          statisticsActivity.getPowerthirdquartil(),
          statisticsActivity.getDeltathirdquartil()
        );
    }

    public static List<StatisticsActivityDTO> mapToListStatisticsActivityDTO (List<StatisticsActivity> statisticsActivityList) {
        return statisticsActivityList.stream().map(StatisticsActivityMapper::mapToOneStatisticsActivityDTO).collect(Collectors.toList());
    }

}
