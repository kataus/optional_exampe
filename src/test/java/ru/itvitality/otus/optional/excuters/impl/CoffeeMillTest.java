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

import java.util.Optional;

import static org.junit.Assert.*;
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
        when(coffeeStorage.getCoffeeBeans()).thenReturn(java.util.Optional.of(doseOfBean));

        Optional<DoseOfCoffee> coffee = cofferMill.getCoffeePowder();

        assertTrue(coffee.isPresent());
    }

    @Test
    public void noCoffeeBeansExists(){

        when(coffeeStorage.getCoffeeBeans()).thenReturn(Optional.empty());

        Optional<DoseOfCoffee> coffee = cofferMill.getCoffeePowder();
        assertFalse(coffee.isPresent());
    }
}
