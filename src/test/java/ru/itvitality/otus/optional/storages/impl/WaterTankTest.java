package ru.itvitality.otus.optional.storages.impl;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import ru.itvitality.otus.optional.dto.CupOfWater;
import ru.itvitality.otus.optional.storages.WaterPipeline;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class WaterTankTest {
    @Mock
    private WaterPipeline waterPipeline;

    @Test
    public void testPipelineNotWorkInternalTankIsEmpty() {
        WaterTankImpl waterTank = new WaterTankImpl();
        waterTank.setCupOfWater(null);

        waterTank.setWaterPipeline(waterPipeline);

        when(waterPipeline.getCupOfWater()).thenReturn(null);

        CupOfWater newCupOfWater = waterTank.getCupOfWater();

        assertNull(newCupOfWater);
    }

    @Test
    public void testPipelineNotWorkInternalTankIsFull() {
        WaterTankImpl waterTank = new WaterTankImpl();
        CupOfWater internalCupOfWater = new CupOfWater();
        waterTank.setCupOfWater(internalCupOfWater);

        waterTank.setWaterPipeline(waterPipeline);

        when(waterPipeline.getCupOfWater()).thenReturn(null);

        CupOfWater newCupOfWater = waterTank.getCupOfWater();

        assertNotNull(newCupOfWater);
        assertEquals(newCupOfWater, internalCupOfWater);
    }

    @Test
    public void testPipelineIsOkInternalTankIsEmpty() {
        WaterTankImpl waterTank = new WaterTankImpl();
        waterTank.setCupOfWater(null);

        waterTank.setWaterPipeline(waterPipeline);

        CupOfWater cupOfWater = new CupOfWater();

        when(waterPipeline.getCupOfWater()).thenReturn(cupOfWater);

        CupOfWater newCupOfWater = waterTank.getCupOfWater();

        assertNotNull(newCupOfWater);
        assertEquals(newCupOfWater, cupOfWater);
    }

    @Test
    public void testPipelineIsOkInternalTankIsFull() {
        WaterTankImpl waterTank = new WaterTankImpl();
        CupOfWater internalCupOfWater = new CupOfWater();
        waterTank.setCupOfWater(internalCupOfWater);

        waterTank.setWaterPipeline(waterPipeline);

        CupOfWater cupOfWater = new CupOfWater();

        when(waterPipeline.getCupOfWater()).thenReturn(cupOfWater);

        CupOfWater newCupOfWater = waterTank.getCupOfWater();

        assertNotNull(newCupOfWater);
        assertEquals(newCupOfWater, cupOfWater);
    }
}
