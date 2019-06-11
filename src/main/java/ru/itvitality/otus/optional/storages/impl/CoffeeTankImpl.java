package ru.itvitality.otus.optional.storages.impl;

import ru.itvitality.otus.optional.dto.DoseOfBean;
import ru.itvitality.otus.optional.storages.CoffeeTank;

import java.util.Optional;

public class CoffeeTankImpl implements CoffeeTank {
    private DoseOfBean doseOfBean;

    @Override
    public Optional<DoseOfBean> getDoseOfBean() {
        return Optional.ofNullable(doseOfBean);
    }

    public void setDoseOfBean(DoseOfBean doseOfBean) {
        this.doseOfBean = doseOfBean;
    }
}
