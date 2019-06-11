package ru.itvitality.otus.optional.storages;

import ru.itvitality.otus.optional.dto.CupOfMilk;

import java.util.Optional;

public interface MilkTank {
    Optional<CupOfMilk> getCupOfMilk();
}
