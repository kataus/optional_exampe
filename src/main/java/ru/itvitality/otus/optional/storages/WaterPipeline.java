package ru.itvitality.otus.optional.storages;

import ru.itvitality.otus.optional.dto.CupOfWater;

import java.util.Optional;

public interface WaterPipeline {
    Optional<CupOfWater> getCupOfWater();
}
