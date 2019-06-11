package ru.itvitality.otus.optional.storages.impl;

import ru.itvitality.otus.optional.dto.DoseOfBean;
import ru.itvitality.otus.optional.storages.CoffeeStorage;
import ru.itvitality.otus.optional.storages.CoffeeTank;

import java.util.Optional;

public class CoffeeStorageImpl implements CoffeeStorage {
    private CoffeeTank coffeeTank1;
    private CoffeeTank coffeeTank2;
    private CoffeeTank coffeeTank3;

    @Override
    public Optional<DoseOfBean> getCoffeeBeans() {
        return coffeeTank1.getDoseOfBean()
                .or(() -> coffeeTank2.getDoseOfBean())
                .or(() -> coffeeTank3.getDoseOfBean());
    }

    public void setCoffeeTank1(CoffeeTank coffeeTank1) {
        this.coffeeTank1 = coffeeTank1;
    }

    public void setCoffeeTank2(CoffeeTank coffeeTank2) {
        this.coffeeTank2 = coffeeTank2;
    }

    public void setCoffeeTank3(CoffeeTank coffeeTank3) {
        this.coffeeTank3 = coffeeTank3;
    }
}
