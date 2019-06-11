package ru.itvitality.otus.optional.storages.impl;

import org.junit.Test;
import ru.itvitality.otus.optional.dto.CupOfWater;

import java.util.Optional;

import static org.junit.Assert.*;

public class WaterPipelineImplTest {

    @Test
    public void allWorks() {
        WaterPipelineImpl waterPipeline = new WaterPipelineImpl();
        CupOfWater cupOfWater = new CupOfWater();

        waterPipeline.setCupOfWater(cupOfWater);
        waterPipeline.setFilterIsActive(true);

        Optional<CupOfWater> newCupOfWater = waterPipeline.getCupOfWater();

        assertTrue(newCupOfWater.isPresent());
        assertEquals(newCupOfWater.get(), cupOfWater);
    }

    @Test
    public void caseNoWater() {
        WaterPipelineImpl waterPipeline = new WaterPipelineImpl();

        waterPipeline.setCupOfWater(null);
        waterPipeline.setFilterIsActive(true);

        Optional<CupOfWater> newCupOfWater = waterPipeline.getCupOfWater();

        assertFalse(newCupOfWater.isPresent());
    }

    @Test
    public void caseNoFilter() {
        WaterPipelineImpl waterPipeline = new WaterPipelineImpl();
        CupOfWater cupOfWater = new CupOfWater();
        waterPipeline.setCupOfWater(cupOfWater);
        waterPipeline.setFilterIsActive(false);

        Optional<CupOfWater> newCupOfWater = waterPipeline.getCupOfWater();

        assertFalse(newCupOfWater.isPresent());
    }

    @Test
    public void caseNothing() {
        WaterPipelineImpl waterPipeline = new WaterPipelineImpl();

        waterPipeline.setCupOfWater(null);
        waterPipeline.setFilterIsActive(false);

        Optional<CupOfWater> newCupOfWater = waterPipeline.getCupOfWater();

        assertFalse(newCupOfWater.isPresent());
    }
}
