package ru.itvitality.otus.optional.excuters.impl;


import ru.itvitality.otus.optional.dto.CupOfMilk;
import ru.itvitality.otus.optional.dto.CupOfWater;
import ru.itvitality.otus.optional.dto.DoseOfMilk;
import ru.itvitality.otus.optional.excuters.MilkDispenser;
import ru.itvitality.otus.optional.storages.DryMilkStorage;
import ru.itvitality.otus.optional.storages.MilkTank;
import ru.itvitality.otus.optional.storages.WaterTank;

import java.util.Optional;

public class MilkDispenserImpl implements MilkDispenser {
    @Override
    public Optional<CupOfMilk> getCupOfMilk() {
        Optional<CupOfMilk> cupOfMilk = milkTank.getCupOfMilk();

        if (!cupOfMilk.isPresent()) {
            cupOfMilk = createMilkFromDry();
        }

        return cupOfMilk;
    }

    public void setMilkTank(MilkTank milkTank) {
        this.milkTank = milkTank;
    }

    public void setWaterTank(WaterTank waterTank) {
        this.waterTank = waterTank;
    }

    public void setDryMilkStorage(DryMilkStorage dryMilkStorage) {
        this.dryMilkStorage = dryMilkStorage;
    }

    private Optional<CupOfMilk> createMilkFromDry() {
        DoseOfMilk doseOfMilk = dryMilkStorage.getDoseOfDryMilk();
        CupOfWater cupOfWater = waterTank.getCupOfWater();
        return Optional.ofNullable(mix(doseOfMilk, cupOfWater));
    }

    private CupOfMilk mix(DoseOfMilk doseOfMilk, CupOfWater cupOfWater) {
        if (doseOfMilk == null || cupOfWater == null) {
            throw new RuntimeException("Ou shit... I'm crashed");
        }
        return new CupOfMilk();
    }

    private MilkTank milkTank;
    private WaterTank waterTank;
    private DryMilkStorage dryMilkStorage;

}
