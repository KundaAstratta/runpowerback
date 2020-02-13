package com.runpowerback.runpowerback;

import com.runpowerback.runpowerback.application.FromActivityToPowerActivityService;
import com.runpowerback.runpowerback.domaine.Activity;
import com.runpowerback.runpowerback.domaine.ActivityRepository;
import com.runpowerback.runpowerback.domaine.PowerActivity;
import com.runpowerback.runpowerback.domaine.PowerActivityRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

@SpringBootTest
public class ActivityToPowerActivityTests {

    @Autowired
    ActivityRepository activityRepository;

    @Autowired
    FromActivityToPowerActivityService fromActivityToPowerActivityService;

    @Autowired
    PowerActivityRepository powerActivityRepository;

    private static final Logger logger = LogManager.getLogger(RunpowerbackApplication.class);

    @BeforeAll
    static void setup() {
        logger.info("@BeforeAll - one times before all tests");
    }

    @BeforeEach
    void init() {
        logger.info("@BeforeEach - before each test");
    }

    @Test
    void oneActivityToPowerActivity_fixedIdathlete_fixedIdpoweractivity () {
        Activity activity = new Activity (1L,48.79152f,2.336916f,51.6f,121,"2020-01-22T05:25:44Z");
        this.activityRepository.save(activity);
        activity = new Activity(2L,48.79155f,2.336947f,51.6f,121,"2020-01-22T05:25:45Z");
        this.activityRepository.save(activity);
        activity = new Activity(3L,48.791576f,2.336977f,51.6f,121,"2020-01-22T05:25:46Z");
        this.activityRepository.save(activity);
        List<Activity> run = this.activityRepository.findAll();
        logger.info(run);
        this.fromActivityToPowerActivityService.toTransform(run);
        List<PowerActivity> runpower = this.powerActivityRepository.findOnePowerActivity(1l,1L);
        logger.info(runpower);
        assertAll(
                () -> assertEquals(1L,runpower.get(0).getIdathlete()),
                () -> assertEquals(1L,runpower.get(0).getIdpoweractivity()),
                () -> assertEquals(265.97711181640625,runpower.get(0).getPower()),
                () -> assertEquals(3.69582462310791,runpower.get(0).getSpeed()),
                () -> assertEquals(4.509593963623047,runpower.get(0).getPace()),
                () -> assertEquals(121,runpower.get(0).getHearthrate()),
                () -> assertEquals(7.778759002685547,runpower.get(0).getDistance()),
                () -> assertEquals(2.0,runpower.get(0).getTimezone())
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
