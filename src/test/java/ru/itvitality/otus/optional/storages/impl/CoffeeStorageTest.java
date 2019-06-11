package ru.itvitality.otus.optional.storages.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import ru.itvitality.otus.optional.dto.DoseOfBean;
import ru.itvitality.otus.optional.storages.CoffeeTank;

import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CoffeeStorageTest {

    @Mock
    private CoffeeTank coffeeTank1;
    @Mock
    private CoffeeTank coffeeTank2;
    @Mock
    private CoffeeTank coffeeTank3;

    private CoffeeStorageImpl coffeeStorage;

    @Before
    public void prepareCoffeeStorage() {
        coffeeStorage = new CoffeeStorageImpl();
        coffeeStorage.setCoffeeTank1(coffeeTank1);
        coffeeStorage.setCoffeeTank2(coffeeTank2);
        coffeeStorage.setCoffeeTank3(coffeeTank3);
    }

    @Test
    public void allCoffeeStorageIsEmpty() {
        when(coffeeTank1.getDoseOfBean()).thenReturn(Optional.empty());
        when(coffeeTank2.getDoseOfBean()).thenReturn(Optional.empty());
        when(coffeeTank3.getDoseOfBean()).thenReturn(Optional.empty());

        Optional<DoseOfBean> doseOfBean = coffeeStorage.getCoffeeBeans();

        assertFalse(doseOfBean.isPresent());
    }

    @Test
    public void allCoffeeStorageIsFull() {
        DoseOfBean doseOfBean1 = new DoseOfBean();
        when(coffeeTank1.getDoseOfBean()).thenReturn(java.util.Optional.of(doseOfBean1));

        Optional<DoseOfBean> doseOfBean = coffeeStorage.getCoffeeBeans();

        assertTrue(doseOfBean.isPresent());
        assertEquals(doseOfBean1, doseOfBean.get());
    }

    @Test
    public void allCoffeeStorageFisrtTankIsEmpty() {

        when(coffeeTank1.getDoseOfBean()).thenReturn(Optional.empty());
        Optional<DoseOfBean> doseOfBean2 = Optional.of(new DoseOfBean());

        when(coffeeTank2.getDoseOfBean()).thenReturn(doseOfBean2);

        Optional<DoseOfBean> doseOfBean = coffeeStorage.getCoffeeBeans();

        assertTrue(doseOfBean.isPresent());
        assertEquals(doseOfBean2.get(), doseOfBean.get());
    }

    @Test
    public void allCoffeeStorageFisrtAndSecondTankIsEmpty() {

        when(coffeeTank1.getDoseOfBean()).thenReturn(Optional.empty());
        when(coffeeTank2.getDoseOfBean()).thenReturn(Optional.empty());
        DoseOfBean doseOfBean3 = new DoseOfBean();
        when(coffeeTank3.getDoseOfBean()).thenReturn(java.util.Optional.of(doseOfBean3));

        Optional<DoseOfBean> doseOfBean = coffeeStorage.getCoffeeBeans();

        assertTrue(doseOfBean.isPresent());
        assertEquals(doseOfBean3, doseOfBean.get());
    }
}
