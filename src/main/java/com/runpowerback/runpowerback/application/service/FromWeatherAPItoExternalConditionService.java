package com.runpowerback.runpowerback.application.service;

import com.runpowerback.runpowerback.domaine.entity.ExternalCondition;
import com.runpowerback.runpowerback.domaine.entity.weather.WeatherCurrentAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;

@Service
@Transactional
public class FromWeatherAPItoExternalConditionService {

    @Value("${runpower.url.weather}")
    private String urlWeatherPath;

    @Value("${runpower.url.weather.key}")
    private String urlWeatherPathKey;

    private static final Logger logger = LogManager.getLogger("File");

    public ExternalCondition toCallWeatherAPI (float latitude , float longitude) {

            StringBuilder url = new StringBuilder(urlWeatherPath);
            url.append("lat=");
            url.append(latitude);
            url.append("&lon=");
            url.append(longitude);
            url.append("&exclude=minutely,hourly,daily,alerts");
            url.append("&appid=");
            url.append(urlWeatherPathKey);
            logger.info("url : {}", url);

            RestTemplate restTemplate = new RestTemplate();

            WeatherCurrentAPI result = restTemplate.getForObject(url.toString(), WeatherCurrentAPI.class);

            ExternalCondition externalCondition = new ExternalCondition();

            externalCondition.setTemperature((int)(result.getCurrent().getTemp()-273.15f));
            externalCondition.setPressureatm(result.getCurrent().getPressure() * 100);
            externalCondition.setHumidity(result.getCurrent().getHumidity());
            externalCondition.setSpeedwind(result.getCurrent().getWindSpeed());

            logger.info("temperature from API Weather {}", result.getCurrent().getTemp());
            logger.info("pressure from API Weather {}", result.getCurrent().getPressure());
            logger.info("humidity from API Weather {}", result.getCurrent().getHumidity());
            logger.info("speed wind from API Weather {}", result.getCurrent().getWindSpeed());

            return externalCondition;
    }

}
