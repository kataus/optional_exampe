package ru.itvitality.otus.optional.storages.impl;


import ru.itvitality.otus.optional.dto.CupOfMilk;
import ru.itvitality.otus.optional.storages.MilkTank;

import java.util.Optional;

public class MilkTankImpl implements MilkTank {
    private CupOfMilk cupOfMilk;

    @Override
    public Optional<CupOfMilk> getCupOfMilk() {
        return Optional.ofNullable(cupOfMilk);
    }

    public void setCupOfMilk(CupOfMilk cupOfMilk) {
        this.cupOfMilk = cupOfMilk;
    }
}
