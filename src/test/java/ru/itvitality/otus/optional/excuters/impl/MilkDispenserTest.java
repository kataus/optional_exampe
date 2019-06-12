package ru.itvitality.otus.optional.excuters.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import ru.itvitality.otus.optional.dto.CupOfMilk;
import ru.itvitality.otus.optional.dto.CupOfWater;
import ru.itvitality.otus.optional.dto.DoseOfMilk;
import ru.itvitality.otus.optional.storages.DryMilkStorage;
import ru.itvitality.otus.optional.storages.MilkTank;
import ru.itvitality.otus.optional.storages.WaterTank;

import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MilkDispenserTest {

    @Mock
    private MilkTank milkTank;

    @Mock
    private WaterTank waterTank;

    @Mock
    private DryMilkStorage dryMilkStorage;

    private MilkDispenserImpl milkDispenser;

    @Before
    public void before(){
        milkDispenser = new MilkDispenserImpl();

        milkDispenser.setMilkTank(milkTank);
        milkDispenser.setWaterTank(waterTank);
        milkDispenser.setDryMilkStorage(dryMilkStorage);
    }

    @Test
    public void weHaveFreshMilk(){
        Optional<CupOfMilk> cupOfMilk = Optional.of(new CupOfMilk());
        when(milkTank.getCupOfMilk()).thenReturn(cupOfMilk);

        Optional<CupOfMilk> newCupOfMilk = milkDispenser.getCupOfMilk();

        assertTrue(newCupOfMilk.isPresent());
        assertEquals(newCupOfMilk.get(), cupOfMilk.get());
    }

    @Test
    public void noFreshCanCreateFromDry(){
        when(milkTank.getCupOfMilk()).thenReturn(Optional.empty());
        when(waterTank.getCupOfWater()).thenReturn(new CupOfWater());
        when(dryMilkStorage.getDoseOfDryMilk()).thenReturn(new DoseOfMilk());

        Optional<CupOfMilk> cupOfMilk = milkDispenser.getCupOfMilk();

        assertTrue(cupOfMilk.isPresent());
    }

    @Test(expected = RuntimeException.class)
    public void noFreshNoDryNoWater(){
        when(milkTank.getCupOfMilk()).thenReturn(Optional.empty());
        when(waterTank.getCupOfWater()).thenReturn(null);
        when(dryMilkStorage.getDoseOfDryMilk()).thenReturn(null);

        Optional<CupOfMilk> cupOfMilk = milkDispenser.getCupOfMilk();
    }

    @Test(expected = RuntimeException.class)
    public void noFreshExistDryNoWater(){
        when(milkTank.getCupOfMilk()).thenReturn(Optional.empty());
        when(waterTank.getCupOfWater()).thenReturn(null);
        when(dryMilkStorage.getDoseOfDryMilk()).thenReturn(new DoseOfMilk());

        Optional<CupOfMilk> cupOfMilk = milkDispenser.getCupOfMilk();
    }

    @Test(expected = RuntimeException.class)
    public void noFreshNoDryExistsWater(){
        when(milkTank.getCupOfMilk()).thenReturn(Optional.empty());
        when(waterTank.getCupOfWater()).thenReturn(new CupOfWater());
        when(dryMilkStorage.getDoseOfDryMilk()).thenReturn(null);

        Optional<CupOfMilk> cupOfMilk = milkDispenser.getCupOfMilk();
    }
}
