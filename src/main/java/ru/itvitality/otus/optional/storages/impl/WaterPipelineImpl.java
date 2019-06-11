package ru.itvitality.otus.optional.storages.impl;

import ru.itvitality.otus.optional.dto.CupOfWater;
import ru.itvitality.otus.optional.storages.WaterPipeline;

public class WaterPipelineImpl implements WaterPipeline {
    private CupOfWater cupOfWater;
    private boolean filterIsActive = false;

    @Override
    public CupOfWater getCupOfWater() {
        CupOfWater cupOfWater = this.cupOfWater;

        return isClean(cupOfWater) ? cupOfWater : null;
    }

    private boolean isClean(CupOfWater cupOfWater) {
        return filterIsActive;
    }

    public void setFilterIsActive(boolean filterIsActive) {
        this.filterIsActive = filterIsActive;
    }

    public void setCupOfWater(CupOfWater cupOfWater) {
        this.cupOfWater = cupOfWater;
    }
}
