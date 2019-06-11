package ru.itvitality.otus.optional.storages;

import ru.itvitality.otus.optional.dto.DoseOfBean;

import java.util.Optional;

public interface CoffeeStorage {
    Optional<DoseOfBean> getCoffeeBeans();
}
