package com.runpowerback.runpowerback.application.service;

import org.springframework.stereotype.Service;

@Service
public class FormulaVDOTService {

    // with time in minutes
    public float percentMax(float time)  {

        float percentMax =
                (float) (0.8f + 0.1894393f * Math.exp(-0.012778f * time)
                              + 0.2989558f * Math.exp(-0.1932605f * time));

        return percentMax;

    }

    // speed meters per minute
    public float VO2 (float speed) {

        float VO2 = -4.6f + 0.182258f * speed
                                   + 0.000104f * (speed * speed);

        return VO2;

    }

    // dist in meters , time in minutes
    public float VO2 (float dist , float time) {

        float VO2 = 4.6f + 0.182258f * (dist/time)
                                        + 0.000104f * (dist/time) * (dist/time);

        return VO2;

    }

    public float VDOT (float VO2, float percentMax) {

        float VDOT = VO2 / percentMax;

        return VDOT;

    }

    // dist in meters , target in minutes
    public float target (float dist, float percent, float vdot) {

        float target = (float) ((dist * 2 * 0.000104f ) / (-0.182258f +
                                Math.sqrt(0.182258f * 0.182258f - 4 * 0.000104f * (-4.6f - percent * vdot))));

        return target;

    }

}
