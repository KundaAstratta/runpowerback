package com.runpowerback.runpowerback;

import com.runpowerback.runpowerback.application.FromActivityToPowerActivityService;
import com.runpowerback.runpowerback.domaine.*;
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
    ExternalConditionRepository externalConditionRepository;

    @Autowired
    PressureSaturationRepository pressureSaturationRepository;

    @Autowired
    ActivityRepository activityRepository;

    @Autowired
    FromActivityToPowerActivityService fromActivityToPowerActivityService;

    @Autowired
    PowerActivityRepository powerActivityRepository;

    @Autowired
    AthleteRepository athleteRepository;

    private static final Logger logger = LogManager.getLogger("File");


    @BeforeAll
    static void setup() {
        logger.info("@BeforeAll - one times before all tests" );
    }

    @BeforeEach
    void init() {
        logger.info("@BeforeEach - before each test");
    }

    @Test
    void oneActivityToPowerActivity_fixedIdathlete_fixedIdpoweractivity () {
        logger.info("Initiate pressure saturation table...");
        this.pressureSaturationRepository.save(new PressureSaturation(1L, 18, 2063));

        logger.info("External condition for one day");
        this.externalConditionRepository.save(new ExternalCondition(1L,1l,1L,100000,18,70,0));



        Athlete athlete = new Athlete (1L,1L,"Name","Surname",70,188);
        this.athleteRepository.save(athlete);
        logger.info(athlete);

        Activity activity = new Activity (1L,48.79152f,2.336916f,51.6f,121,"2020-01-22T05:25:44Z");
        this.activityRepository.save(activity);
        activity = new Activity(2L,48.79155f,2.336947f,51.6f,121,"2020-01-22T05:25:45Z");
        this.activityRepository.save(activity);
        activity = new Activity(3L,48.791576f,2.336977f,51.6f,121,"2020-01-22T05:25:46Z");
        this.activityRepository.save(activity);
        List<Activity> run = this.activityRepository.findAll();
        logger.info(run);
        
        float mass = this.athleteRepository.findOneAthlete(1L).getMass();

        this.fromActivityToPowerActivityService.toTransform(1L, 1L,run,mass);
        List<PowerActivity> runpower = this.powerActivityRepository.findOnePowerActivity(1l,1L);
        logger.info(runpower);
        assertAll(
                () -> assertEquals(1L,runpower.get(0).getIdathlete()),
                () -> assertEquals(1L,runpower.get(0).getIdpoweractivity()),
                () -> assertEquals(265.91632080078125,runpower.get(0).getPower()),
                () -> assertEquals(3.69582462310791,runpower.get(0).getSpeed()),
                () -> assertEquals(4.509593963623047,runpower.get(0).getPace()),
                () -> assertEquals(121,runpower.get(0).getHearthrate()),
                () -> assertEquals(7.778759002685547,runpower.get(0).getDistance()),
                () -> assertEquals(2.0,runpower.get(0).getTimezone())
        );

    }


    @Test
    void oneActivityToPowerActivity_fixedIdathlete_fixedIdpoweractivity_same_as_abpve_but_with_windSpeed () {
        logger.info("External condition for other day");
        this.externalConditionRepository.save(new ExternalCondition(2L,1l,2L,100000,18,70,10));

        this.activityRepository.deleteAll();

        Activity activity = new Activity (1L,48.79152f,2.336916f,51.6f,121,"2020-01-22T05:25:44Z");
        this.activityRepository.save(activity);
        activity = new Activity(2L,48.79155f,2.336947f,51.6f,121,"2020-01-22T05:25:45Z");
        this.activityRepository.save(activity);
        activity = new Activity(3L,48.791576f,2.336977f,51.6f,121,"2020-01-22T05:25:46Z");
        this.activityRepository.save(activity);
        List<Activity> run = this.activityRepository.findAll();
        logger.info(run);

        float mass = this.athleteRepository.findOneAthlete(1L).getMass();

        this.fromActivityToPowerActivityService.toTransform(1L, 2L,run,mass);
        List<PowerActivity> runpower = this.powerActivityRepository.findOnePowerActivity(1l,2L);
        logger.info(runpower);
        assertAll(
                () -> assertEquals(1L,runpower.get(0).getIdathlete()),
                () -> assertEquals(2L,runpower.get(0).getIdpoweractivity()),
                () -> assertEquals(357.70050048828125,runpower.get(0).getPower()),
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
