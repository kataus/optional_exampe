package ru.itvitality.otus.optional.excuters;

import ru.itvitality.otus.optional.dto.DoseOfCoffee;

import java.util.Optional;

public interface CofferMill {
    Optional<DoseOfCoffee> getCoffeePowder();
}
