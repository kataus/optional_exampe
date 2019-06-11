package ru.itvitality.otus.optional.storages.impl;

import org.junit.Test;
import ru.itvitality.otus.optional.dto.CupOfMilk;

import java.util.Optional;

import static org.junit.Assert.*;

public class MiltTankTest {

    @Test
    public void testFullMilkTank() {
        MilkTankImpl milkTank = new MilkTankImpl();
        CupOfMilk cupOfMilk = new CupOfMilk();
        milkTank.setCupOfMilk(cupOfMilk);
        Optional<CupOfMilk> newCupOfMilk = milkTank.getCupOfMilk();

        assertTrue(newCupOfMilk.isPresent());
        assertEquals(cupOfMilk, newCupOfMilk.get());
    }

    @Test
    public void testEmptyMilkTank() {
        MilkTankImpl milkTank = new MilkTankImpl();

        Optional<CupOfMilk> newCupOfMilk = milkTank.getCupOfMilk();

        assertFalse(newCupOfMilk.isPresent());
    }
}
