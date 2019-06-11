package ru.itvitality.otus.optional.storages.impl;

import org.junit.Test;
import ru.itvitality.otus.optional.dto.CupOfWater;

import static org.junit.Assert.*;

public class WaterPipelineImplTest {

    @Test
    public void allWorks() {
        WaterPipelineImpl waterPipeline = new WaterPipelineImpl();
        CupOfWater cupOfWater = new CupOfWater();

        waterPipeline.setCupOfWater(cupOfWater);
        waterPipeline.setFilterIsActive(true);

        CupOfWater newCupOfWater = waterPipeline.getCupOfWater();

        assertNotNull(newCupOfWater);
        assertEquals(newCupOfWater, cupOfWater);
    }

    @Test
    public void caseNoWater() {
        WaterPipelineImpl waterPipeline = new WaterPipelineImpl();

        waterPipeline.setCupOfWater(null);
        waterPipeline.setFilterIsActive(true);

        CupOfWater newCupOfWater = waterPipeline.getCupOfWater();

        assertNull(newCupOfWater);
    }

    @Test
    public void caseNoFilter() {
        WaterPipelineImpl waterPipeline = new WaterPipelineImpl();
        CupOfWater cupOfWater = new CupOfWater();
        waterPipeline.setCupOfWater(cupOfWater);
        waterPipeline.setFilterIsActive(false);

        CupOfWater newCupOfWater = waterPipeline.getCupOfWater();

        assertNull(newCupOfWater);
    }

    @Test
    public void caseNothing() {
        WaterPipelineImpl waterPipeline = new WaterPipelineImpl();

        waterPipeline.setCupOfWater(null);
        waterPipeline.setFilterIsActive(false);

        CupOfWater newCupOfWater = waterPipeline.getCupOfWater();

        assertNull(newCupOfWater);
    }
}
