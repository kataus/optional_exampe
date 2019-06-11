package ru.itvitality.otus.optional.storages.impl;

import ru.itvitality.otus.optional.dto.DoseOfBean;
import ru.itvitality.otus.optional.storages.CoffeeTank;

public class CoffeeTankImpl implements CoffeeTank {
    private DoseOfBean doseOfBean;

    @Override
    public DoseOfBean getDoseOfBean() {
        return doseOfBean;
    }

    public void setDoseOfBean(DoseOfBean doseOfBean) {
        this.doseOfBean = doseOfBean;
    }
}
