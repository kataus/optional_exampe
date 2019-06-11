package ru.itvitality.otus.optional.storages.impl;


import ru.itvitality.otus.optional.dto.DoseOfMilk;
import ru.itvitality.otus.optional.storages.DryMilkStorage;

import java.util.Optional;

public class DryMilkStorageImpl implements DryMilkStorage {
    private DoseOfMilk doseOfMilk;

    @Override
    public DoseOfMilk getDoseOfDryMilk() {
        return Optional.ofNullable(doseOfMilk).orElseThrow(() -> new RuntimeException("I haven't milk"));
    }

    public void setDoseOfMilk(DoseOfMilk doseOfMilk) {
        this.doseOfMilk = doseOfMilk;
    }
}
