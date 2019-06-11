package ru.itvitality.otus.optional.storages.impl;

import ru.itvitality.otus.optional.dto.CupOfWater;
import ru.itvitality.otus.optional.storages.WaterPipeline;

import java.util.Optional;

public class WaterPipelineImpl implements WaterPipeline {
    private CupOfWater cupOfWater;
    private boolean filterIsActive = false;

    @Override
    public Optional<CupOfWater> getCupOfWater() {
        CupOfWater cupOfWater = this.cupOfWater;
        return Optional.ofNullable(cupOfWater).filter(this::isClean);
//        return cupOfWater != null & isClean() ? Optional.of(cupOfWater) : Optional.empty();
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
