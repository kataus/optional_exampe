package ru.itvitality.otus.optional.excuters.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import ru.itvitality.otus.optional.dto.CupOfHotWater;
import ru.itvitality.otus.optional.dto.CupOfWater;
import ru.itvitality.otus.optional.excuters.Heater;
import ru.itvitality.otus.optional.storages.WaterTank;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class HeaterTest {
    @Mock
    private WaterTank waterTank;

    private Heater heater;

    @Before
    public void before() {
        heater = new HeaterImpl();
        ((HeaterImpl) heater).setWaterTank(waterTank);
    }

    @Test
    public void heatWater() {
        when(waterTank.getCupOfWater()).thenReturn(new CupOfWater());

        CupOfHotWater cupOfHotWater = heater.getCupOfHotWater();

        assertNotNull(cupOfHotWater);
    }

    @Test(expected = RuntimeException.class)
    public void heatNoWater() {
        when(waterTank.getCupOfWater()).thenReturn(null);

        CupOfHotWater cupOfHotWater = heater.getCupOfHotWater();
    }
}
