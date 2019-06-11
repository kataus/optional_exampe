package ru.itvitality.otus.optional.excuters;


import ru.itvitality.otus.optional.dto.Coin;

import java.util.Optional;

public class MoneyStogage {
    private Coin coin;

    public Optional<Coin> getPayment() {
        return Optional.ofNullable(coin);
    }

    public void setCoin(Coin coin) {
        this.coin = coin;
    }
}
