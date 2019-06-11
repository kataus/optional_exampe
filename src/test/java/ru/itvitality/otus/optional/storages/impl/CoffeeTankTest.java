package ru.itvitality.otus.optional.storages.impl;

import org.junit.Test;
import ru.itvitality.otus.optional.dto.DoseOfBean;
import ru.itvitality.otus.optional.storages.CoffeeTank;

import java.util.Optional;

import static org.junit.Assert.*;

public class CoffeeTankTest {

    @Test
    public void testFullCoffeeTank() {
        CoffeeTankImpl coffeeTank = new CoffeeTankImpl();
        DoseOfBean doseOfBean = new DoseOfBean();
        coffeeTank.setDoseOfBean(doseOfBean);
        Optional<DoseOfBean> newDoseOfBean = coffeeTank.getDoseOfBean();

        assertTrue(newDoseOfBean.isPresent());
        assertEquals(newDoseOfBean.get(), doseOfBean);
    }

    @Test
    public void testEmptyCoffeeTank() {
        CoffeeTank coffeeTank = new CoffeeTankImpl();

        Optional<DoseOfBean> doseOfBean = coffeeTank.getDoseOfBean();

        assertFalse(doseOfBean.isPresent());
    }
}
