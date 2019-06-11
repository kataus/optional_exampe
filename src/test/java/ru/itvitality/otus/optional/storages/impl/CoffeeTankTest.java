package ru.itvitality.otus.optional.storages.impl;

import org.junit.Test;
import ru.itvitality.otus.optional.dto.DoseOfBean;
import ru.itvitality.otus.optional.storages.CoffeeTank;

import static org.junit.Assert.*;

public class CoffeeTankTest {

    @Test
    public void testFullCoffeeTank() {
        CoffeeTankImpl coffeeTank = new CoffeeTankImpl();
        DoseOfBean doseOfBean = new DoseOfBean();
        coffeeTank.setDoseOfBean(doseOfBean);
        DoseOfBean newDoseOfBean = coffeeTank.getDoseOfBean();

        assertNotNull(newDoseOfBean);
        assertEquals(newDoseOfBean, doseOfBean);
    }

    @Test
    public void testEmptyCoffeeTank() {
        CoffeeTank coffeeTank = new CoffeeTankImpl();

        DoseOfBean doseOfBean = coffeeTank.getDoseOfBean();

        assertNull(doseOfBean);
    }
}
