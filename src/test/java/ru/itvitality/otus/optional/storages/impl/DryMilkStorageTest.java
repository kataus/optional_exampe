package ru.itvitality.otus.optional.storages.impl;

import org.junit.Test;
import ru.itvitality.otus.optional.dto.DoseOfMilk;

import static org.junit.Assert.*;

public class DryMilkStorageTest {

    @Test
    public void testFullDryMilkStorage() {
        DryMilkStorageImpl dryMilkStorage = new DryMilkStorageImpl();
        DoseOfMilk doseOfMilk = new DoseOfMilk();
        dryMilkStorage.setDoseOfMilk(doseOfMilk);
        DoseOfMilk newDoseOfMilk = dryMilkStorage.getDoseOfDryMilk();

        assertNotNull(newDoseOfMilk);
        assertEquals(newDoseOfMilk, doseOfMilk);
    }

    @Test( expected = RuntimeException.class)
    public void testEmptyDryMilkStorage() {
        DryMilkStorageImpl dryMilkStorage = new DryMilkStorageImpl();

        DoseOfMilk doseOfMilk = dryMilkStorage.getDoseOfDryMilk();

        assertNull(doseOfMilk);
    }
}
