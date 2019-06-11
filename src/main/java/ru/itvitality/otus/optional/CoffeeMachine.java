package ru.itvitality.otus.optional;

import ru.itvitality.otus.optional.dto.*;
import ru.itvitality.otus.optional.excuters.CofferMill;
import ru.itvitality.otus.optional.excuters.Heater;
import ru.itvitality.otus.optional.excuters.MilkDispenser;
import ru.itvitality.otus.optional.excuters.MoneyStogage;
import ru.itvitality.otus.optional.excuters.impl.CoffeeMillImpl;
import ru.itvitality.otus.optional.excuters.impl.HeaterImpl;
import ru.itvitality.otus.optional.excuters.impl.MilkDispenserImpl;
import ru.itvitality.otus.optional.storages.*;
import ru.itvitality.otus.optional.storages.impl.*;

public class CoffeeMachine {
    private MoneyStogage moneyStogage;

    private CofferMill cofferMill;
    private CoffeeStorage coffeeStorage;
    private CoffeeTank coffeeTank1;
    private CoffeeTank coffeeTank2;
    private CoffeeTank coffeeTank3;

    private Heater waterHeater;
    private WaterTank waterTank;
    private WaterPipeline waterPipeline;

    private MilkDispenser milkDispenser;
    private MilkTank milkTank;
    private DryMilkStorage dryMilkStorage;


    {
        moneyStogage = new MoneyStogage();

        cofferMill = new CoffeeMillImpl();
        coffeeStorage = new CoffeeStorageImpl();
        coffeeTank1 = new CoffeeTankImpl();
        ((CoffeeStorageImpl) coffeeStorage).setCoffeeTank1(coffeeTank1);
        coffeeTank2 = new CoffeeTankImpl();
        ((CoffeeStorageImpl) coffeeStorage).setCoffeeTank2(coffeeTank2);
        coffeeTank3 = new CoffeeTankImpl();
        ((CoffeeStorageImpl) coffeeStorage).setCoffeeTank3(coffeeTank3);

        ((CoffeeMillImpl) cofferMill).setCoffeeStorage(coffeeStorage);

        waterHeater = new HeaterImpl();
        waterTank = new WaterTankImpl();
        waterPipeline = new WaterPipelineImpl();
        ((WaterTankImpl) waterTank).setWaterPipeline(waterPipeline);
        ((HeaterImpl) waterHeater).setWaterTank(waterTank);

        milkDispenser = new MilkDispenserImpl();
        milkTank = new MilkTankImpl();
        ((MilkDispenserImpl) milkDispenser).setMilkTank(milkTank);
        ((MilkDispenserImpl) milkDispenser).setWaterTank(waterTank);
        dryMilkStorage = new DryMilkStorageImpl();
        ((MilkDispenserImpl) milkDispenser).setDryMilkStorage(dryMilkStorage);

    }

    public CupOfCoffee boilCupOfCoffee() {
        Coin coin = moneyStogage.getPayment();
        CupOfCoffee cupOfCoffee = null;
        if (coin != null) {
            DoseOfCoffee doseOfCoffee = cofferMill.getCoffeePowder();
            CupOfHotWater cupOfHotWater = waterHeater.getCupOfHotWater();
            CupOfMilk cupOfMilk = milkDispenser.getCupOfMilk();

            cupOfCoffee = createCoffee(doseOfCoffee, cupOfHotWater, cupOfMilk);
        }
        return cupOfCoffee;
    }

    private CupOfCoffee createCoffee(DoseOfCoffee doseOfCoffee, CupOfHotWater cupOfHotWater, CupOfMilk cupOfMilk) {
        CupOfCoffee cupOfCoffee = null;
        if (doseOfCoffee != null && cupOfHotWater != null && cupOfMilk != null) {
            cupOfCoffee = new CupOfLatte();
        } else if (doseOfCoffee != null && cupOfHotWater != null) {
            cupOfCoffee = new CupOfAmericano();
        } else if (cupOfHotWater != null && cupOfMilk != null) {
            cupOfCoffee = new CupOfHotWaterWithMilk();
        }
        return cupOfCoffee;
    }
}
