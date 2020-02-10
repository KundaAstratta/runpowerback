package com.runpowerback.runpowerback;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RunpowerbackApplicationTests {

	private static final Logger logger = LogManager.getLogger(RunpowerbackApplication.class);

	@BeforeAll
	static void setup() {
		logger.info("@BeforeAll - one times before all tests");
	}

	@BeforeEach
	void init() {
		logger.info("@BeforeEach - before each test");
	}

	@DisplayName("test of class test...")
	@Test
	void contextLoads() {
		logger.info("test of class test...");
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
