package ru.itvitality.otus.optional.excuters;


import ru.itvitality.otus.optional.dto.Coin;

public class MoneyStogage {
    private Coin coin;

    public Coin getPayment() {
        return coin;
    }

    public void setCoin(Coin coin) {
        this.coin = coin;
    }
}
