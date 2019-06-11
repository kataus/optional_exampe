package ru.itvitality.otus.optional.storages.impl;


import ru.itvitality.otus.optional.dto.CupOfMilk;
import ru.itvitality.otus.optional.storages.MilkTank;

public class MilkTankImpl implements MilkTank {
    private CupOfMilk cupOfMilk;

    @Override
    public CupOfMilk getCupOfMilk() {
        return cupOfMilk;
    }

    public void setCupOfMilk(CupOfMilk cupOfMilk) {
        this.cupOfMilk = cupOfMilk;
    }
}
