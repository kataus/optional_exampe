package ru.itvitality.otus.optional.excuters.impl;


import ru.itvitality.otus.optional.dto.CupOfHotWater;
import ru.itvitality.otus.optional.dto.CupOfWater;
import ru.itvitality.otus.optional.excuters.Heater;
import ru.itvitality.otus.optional.storages.WaterTank;

public class HeaterImpl implements Heater {
    @Override
    public CupOfHotWater getCupOfHotWater() {
        CupOfWater cupOfWater = waterTank.getCupOfWater();
        return heat(cupOfWater);
    }

    private CupOfHotWater heat(CupOfWater w) {
        if (w == null){
            throw new RuntimeException("No water. I'm crashed");
        }
        return new CupOfHotWater() ;
    }

    private WaterTank waterTank;

    public void setWaterTank(WaterTank waterTank) {
        this.waterTank = waterTank;
    }
}
