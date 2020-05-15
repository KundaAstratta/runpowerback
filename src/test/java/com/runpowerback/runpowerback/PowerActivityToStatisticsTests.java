package com.runpowerback.runpowerback;

import com.runpowerback.runpowerback.application.FromPowerActivityToStatisticsService;
import com.runpowerback.runpowerback.domaine.PowerActivity;
import com.runpowerback.runpowerback.domaine.PowerActivityRepository;
import com.runpowerback.runpowerback.domaine.StatisticsActivity;
import com.runpowerback.runpowerback.domaine.StatisticsActivityRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;


import java.util.List;

@SpringBootTest
class PowerActivityToStatisticsTests {

	private static final Logger logger = LogManager.getLogger("File");

	@Autowired
	PowerActivityRepository powerActivityRepository;

	@Autowired
	FromPowerActivityToStatisticsService fromPowerActivityToStatisticsService;

	@Autowired
	StatisticsActivityRepository statisticsActivityRepository;

	@BeforeAll
	static void setup() {
		logger.info("@BeforeAll - one times before all tests");
	}

	@BeforeEach
	void init() {
		logger.info("@BeforeEach - before each test");
	}

	@Test
	void with_seven_powerActvityElementsOrdered() {
		logger.info("create data for PoxerActivity with seven ...");
		PowerActivity powerActivity = new PowerActivity(1L,1L,1L,180,3,145,1,6,1);
		this.powerActivityRepository.save(powerActivity);
		powerActivity = new PowerActivity(2L,1L,1L,181,4,145,2,6,2);
		this.powerActivityRepository.save(powerActivity);
		powerActivity = new PowerActivity(3L,1L,1L,182,3,144,3,6,3);
		this.powerActivityRepository.save(powerActivity);
		powerActivity = new PowerActivity(4L,1L,1L,183,4,145,4,6,4);
		this.powerActivityRepository.save(powerActivity);
		powerActivity = new PowerActivity(5L,1L,1L,184,4,143,5,6,5);
		this.powerActivityRepository.save(powerActivity);
		powerActivity = new PowerActivity(6L,1L,1L,185,3,144,6,6,6);
		this.powerActivityRepository.save(powerActivity);
		powerActivity = new PowerActivity(7L,1L,1L,186,3,145,7,6,7);
		this.powerActivityRepository.save(powerActivity);
		List<PowerActivity> runpower = this.powerActivityRepository.findOnePowerActivity(1L,1L);
		logger.info(runpower);
		this.fromPowerActivityToStatisticsService.toStatistics(runpower,1L);
		StatisticsActivity statisticsActivity = this.statisticsActivityRepository.findOneStatisticsActivity(1l,1L);
		logger.info(statisticsActivity);
		assertAll(
				() -> assertEquals(1L,statisticsActivity.getIdathlete()),
				() -> assertEquals(1L,statisticsActivity.getIdpoweractivity()),
 				() -> assertEquals(183.5,statisticsActivity.getPoweraverage()),
				() -> assertEquals(183.0,statisticsActivity.getPowermedian()),
				() -> assertEquals(1.7078251838684082,statisticsActivity.getDeviation()),
				() -> assertEquals(0.42695629596710205,statisticsActivity.getPowerscore())
		);
	}

	@Test
	void with_eight_powerActvityElementsUnOrdered() {
		logger.info("create data for PoxerActivity with eight elements...");
		PowerActivity powerActivity = new PowerActivity(8L,1L,2L,180,3,145,1,6,1);
		this.powerActivityRepository.save(powerActivity);
		powerActivity = new PowerActivity(9L,1L,2L,186,4,145,2,6,2);
		this.powerActivityRepository.save(powerActivity);
		powerActivity = new PowerActivity(10L,1L,2L,185,3,144,3,6,3);
		this.powerActivityRepository.save(powerActivity);
		powerActivity = new PowerActivity(11L,1L,2L,183,4,145,4,6,4);
		this.powerActivityRepository.save(powerActivity);
		powerActivity = new PowerActivity(12L,1L,2L,182,4,143,5,6,5);
		this.powerActivityRepository.save(powerActivity);
		powerActivity = new PowerActivity(13L,1L,2L,181,3,144,6,6,6);
		this.powerActivityRepository.save(powerActivity);
		powerActivity = new PowerActivity(14L,1L,2L,184,3,145,7,6,7);
		this.powerActivityRepository.save(powerActivity);
		powerActivity = new PowerActivity(15L,1L,2L,187,3,145,8,6,8);
		this.powerActivityRepository.save(powerActivity);
		List<PowerActivity> runpower = this.powerActivityRepository.findOnePowerActivity(1L,2L);
		logger.info(runpower);
		this.fromPowerActivityToStatisticsService.toStatistics(runpower,1L);
		StatisticsActivity statisticsActivity = this.statisticsActivityRepository.findOneStatisticsActivity(1L,2L);
		logger.info(statisticsActivity);
		assertAll(
				() -> assertEquals(1L,statisticsActivity.getIdathlete()),
				() -> assertEquals(2L,statisticsActivity.getIdpoweractivity()),
				() -> assertEquals(184.0,statisticsActivity.getPoweraverage()),
				() -> assertEquals(184.0,statisticsActivity.getPowermedian()),
				() -> assertEquals(2.0,statisticsActivity.getDeviation()),
				() -> assertEquals(0,statisticsActivity.getPowerscore())
		);
	}

	@AfterEach
	void endoftest() {
		logger.info("@AfterEach - end of test...");
	}

	@AfterAll
	static void done() {
		logger.info("@AfterAll - all tests done");
	}

}
