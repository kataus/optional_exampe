package ru.itvitality.otus.optional.excuters;

import ru.itvitality.otus.optional.dto.CupOfMilk;

import java.util.Optional;

public interface MilkDispenser {
    Optional<CupOfMilk> getCupOfMilk();
}
