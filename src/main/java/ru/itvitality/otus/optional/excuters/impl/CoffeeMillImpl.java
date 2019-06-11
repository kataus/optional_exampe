package ru.itvitality.otus.optional.excuters.impl;


import ru.itvitality.otus.optional.dto.DoseOfBean;
import ru.itvitality.otus.optional.dto.DoseOfCoffee;
import ru.itvitality.otus.optional.excuters.CofferMill;
import ru.itvitality.otus.optional.storages.CoffeeStorage;

import java.util.Optional;

public class CoffeeMillImpl implements CofferMill {
    private CoffeeStorage coffeeStorage;

    @Override
    public Optional<DoseOfCoffee> getCoffeePowder() {
        return coffeeStorage.getCoffeeBeans().map(this::mill);
    }

    public void setCoffeeStorage(CoffeeStorage coffeeStorage) {
        this.coffeeStorage = coffeeStorage;
    }

    private DoseOfCoffee mill(DoseOfBean beans) {
        return new DoseOfCoffee(beans);
    }
}
