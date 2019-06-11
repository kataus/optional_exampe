package ru.itvitality.otus.optional.storages.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import ru.itvitality.otus.optional.dto.DoseOfBean;
import ru.itvitality.otus.optional.storages.CoffeeTank;

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
        when(coffeeTank1.getDoseOfBean()).thenReturn(null);
        when(coffeeTank2.getDoseOfBean()).thenReturn(null);
        when(coffeeTank3.getDoseOfBean()).thenReturn(null);

        DoseOfBean doseOfBean = coffeeStorage.getCoffeeBeans();

        assertNull(doseOfBean);
    }

    @Test
    public void allCoffeeStorageIsFull() {
        DoseOfBean doseOfBean1 = new DoseOfBean();
        when(coffeeTank1.getDoseOfBean()).thenReturn(doseOfBean1);


        DoseOfBean doseOfBean = coffeeStorage.getCoffeeBeans();

        assertNotNull(doseOfBean);
        assertEquals(doseOfBean1, doseOfBean);
    }

    @Test
    public void allCoffeeStorageFisrtTankIsEmpty() {

        when(coffeeTank1.getDoseOfBean()).thenReturn(null);
        DoseOfBean doseOfBean2 = new DoseOfBean();
        when(coffeeTank2.getDoseOfBean()).thenReturn(doseOfBean2);


        DoseOfBean doseOfBean = coffeeStorage.getCoffeeBeans();

        assertNotNull(doseOfBean);
        assertEquals(doseOfBean2, doseOfBean);
    }

    @Test
    public void allCoffeeStorageFisrtAndSecondTankIsEmpty() {

        when(coffeeTank1.getDoseOfBean()).thenReturn(null);
        when(coffeeTank2.getDoseOfBean()).thenReturn(null);
        DoseOfBean doseOfBean3 = new DoseOfBean();
        when(coffeeTank3.getDoseOfBean()).thenReturn(doseOfBean3);

        DoseOfBean doseOfBean = coffeeStorage.getCoffeeBeans();

        assertNotNull(doseOfBean);
        assertEquals(doseOfBean3, doseOfBean);
    }
}
