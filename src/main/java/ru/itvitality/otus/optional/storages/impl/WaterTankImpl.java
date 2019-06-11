package ru.itvitality.otus.optional.storages.impl;

import ru.itvitality.otus.optional.dto.CupOfWater;
import ru.itvitality.otus.optional.storages.WaterPipeline;
import ru.itvitality.otus.optional.storages.WaterTank;


public class WaterTankImpl implements WaterTank {
    private CupOfWater cupOfWater;
    private WaterPipeline waterPipeline = new WaterPipelineImpl();

    @Override
    public CupOfWater getCupOfWater() {
        return waterPipeline.getCupOfWater().orElse(this.cupOfWater);
    }

    public void setCupOfWater(CupOfWater cupOfWater) {
        this.cupOfWater = cupOfWater;
    }

    public void setWaterPipeline(WaterPipeline waterPipeline) {
        this.waterPipeline = waterPipeline;
    }
}
