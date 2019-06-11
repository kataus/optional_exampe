package ru.itvitality.otus.optional.storages.impl;

import ru.itvitality.otus.optional.dto.DoseOfBean;
import ru.itvitality.otus.optional.storages.CoffeeStorage;
import ru.itvitality.otus.optional.storages.CoffeeTank;
import ru.itvitality.otus.optional.storages.impl.CoffeeTankImpl;

public class CoffeeStorageImpl implements CoffeeStorage {
    private CoffeeTank coffeeTank1;
    private CoffeeTank coffeeTank2;
    private CoffeeTank coffeeTank3;

    @Override
    public DoseOfBean getCoffeeBeans() {
        DoseOfBean doseOfBean = coffeeTank1.getDoseOfBean();
        if (doseOfBean == null) {
            doseOfBean = coffeeTank2.getDoseOfBean();
        }
        if (doseOfBean == null) {
            doseOfBean = coffeeTank3.getDoseOfBean();
        }

        return doseOfBean;
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
