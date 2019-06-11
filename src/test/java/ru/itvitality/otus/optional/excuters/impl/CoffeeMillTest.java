package ru.itvitality.otus.optional.excuters.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import ru.itvitality.otus.optional.dto.DoseOfBean;
import ru.itvitality.otus.optional.dto.DoseOfCoffee;
import ru.itvitality.otus.optional.excuters.CofferMill;
import ru.itvitality.otus.optional.storages.CoffeeStorage;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CoffeeMillTest {
    @Mock
    private CoffeeStorage coffeeStorage;

    private CofferMill cofferMill;

    @Before
    public void before(){
        cofferMill = new CoffeeMillImpl();
        ((CoffeeMillImpl) cofferMill).setCoffeeStorage(coffeeStorage);
    }

    @Test
    public void coffeeBeansExists(){
        DoseOfBean doseOfBean = new DoseOfBean();
        when(coffeeStorage.getCoffeeBeans()).thenReturn(doseOfBean);

        DoseOfCoffee coffee = cofferMill.getCoffeePowder();

        assertNotNull(coffee);
    }

    @Test(expected = RuntimeException.class)
    public void noCoffeeBeansExists(){

        when(coffeeStorage.getCoffeeBeans()).thenReturn(null);

        DoseOfCoffee coffee = cofferMill.getCoffeePowder();
    }
}
