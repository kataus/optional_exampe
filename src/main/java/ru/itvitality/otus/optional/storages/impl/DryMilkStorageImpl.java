package ru.itvitality.otus.optional.storages.impl;


import ru.itvitality.otus.optional.dto.DoseOfMilk;
import ru.itvitality.otus.optional.storages.DryMilkStorage;

public class DryMilkStorageImpl implements DryMilkStorage {
    private DoseOfMilk doseOfMilk;

    @Override
    public DoseOfMilk getDoseOfDryMilk() {
        return doseOfMilk;
    }

    public void setDoseOfMilk(DoseOfMilk doseOfMilk) {
        this.doseOfMilk = doseOfMilk;
    }
}
