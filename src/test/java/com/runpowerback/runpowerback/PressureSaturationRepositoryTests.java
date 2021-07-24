package com.runpowerback.runpowerback;

import com.runpowerback.runpowerback.domaine.entity.PressureSaturation;
import com.runpowerback.runpowerback.infrastructure.inmemory.PressureSaturationInMemoryRepositoryImpl;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class PressureSaturationRepositoryTests {

    @Test
    void createOneLine () {
        PressureSaturationInMemoryRepositoryImpl pressureSatuationInMemoryRepository = new PressureSaturationInMemoryRepositoryImpl();

        assertThat(1L).isEqualTo(pressureSatuationInMemoryRepository.save(new PressureSaturation(1L,-20f,103f)));
    }

    @Test
    void findOnePressureSaturationForAGivenTemperature() {
        PressureSaturationInMemoryRepositoryImpl pressureSatuationInMemoryRepository = new PressureSaturationInMemoryRepositoryImpl();

        pressureSatuationInMemoryRepository.save(new PressureSaturation(1L,-20f,103f));
        pressureSatuationInMemoryRepository.save(new PressureSaturation(2L,-18f,150f));
        pressureSatuationInMemoryRepository.save(new PressureSaturation(3L,-15f,190f));
        pressureSatuationInMemoryRepository.save(new PressureSaturation(4L,-12f,240f));
        pressureSatuationInMemoryRepository.save(new PressureSaturation(5L,-10f,260f));
        pressureSatuationInMemoryRepository.save(new PressureSaturation(6L,-9f,330f));

        assertThat(240f).isEqualTo(pressureSatuationInMemoryRepository.findOnePressureSaturation(-12f).getPressure());
    }
}
