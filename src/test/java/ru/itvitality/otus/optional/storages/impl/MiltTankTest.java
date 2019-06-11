package ru.itvitality.otus.optional.storages.impl;

import org.junit.Test;
import ru.itvitality.otus.optional.dto.CupOfMilk;

import static org.junit.Assert.*;

public class MiltTankTest {

    @Test
    public void testFullMilkTank() {
        MilkTankImpl milkTank = new MilkTankImpl();
        CupOfMilk cupOfMilk = new CupOfMilk();
        milkTank.setCupOfMilk(cupOfMilk);
        CupOfMilk newCupOfMilk = milkTank.getCupOfMilk();

        assertNotNull(newCupOfMilk);
        assertEquals(cupOfMilk, newCupOfMilk);
    }

    @Test
    public void testEmptyMilkTank() {
        MilkTankImpl milkTank = new MilkTankImpl();

        CupOfMilk newCupOfMilk = milkTank.getCupOfMilk();

        assertNull(newCupOfMilk);
    }
}
