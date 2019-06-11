package ru.itvitality.otus.optional.excuters.impl;


import ru.itvitality.otus.optional.dto.DoseOfBean;
import ru.itvitality.otus.optional.dto.DoseOfCoffee;
import ru.itvitality.otus.optional.excuters.CofferMill;
import ru.itvitality.otus.optional.storages.CoffeeStorage;

public class CoffeeMillImpl implements CofferMill {
    private CoffeeStorage coffeeStorage;

    @Override
    public DoseOfCoffee getCoffeePowder() {
        DoseOfBean doseOfBean = coffeeStorage.getCoffeeBeans();
        return mill(doseOfBean);
    }

    public void setCoffeeStorage(CoffeeStorage coffeeStorage) {
        this.coffeeStorage = coffeeStorage;
    }

    private DoseOfCoffee mill(DoseOfBean beans) {
        if (beans == null){
            throw new RuntimeException("No beans. I'm crashed");
        }
        return new DoseOfCoffee(beans);
    }
}
