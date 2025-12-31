package ru.yandex.practicum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import ru.yandex.practicum.delivery.PerishableParcel;

public class IsExpiredTest {
    private  PerishableParcel perishableParcel;

    @Test
    public void IsParcelExpiredBeforeGivenBeforTime(){
        perishableParcel = new PerishableParcel("Холодец",3,"Монино 1",11,5);
        Assertions.assertFalse(perishableParcel.isExpired(14));
    }
    @Test
    public void IsParcelExpiredBeforeGivenInTime(){
        perishableParcel = new PerishableParcel("Холодец",3,"Монино 1",11,5);
        Assertions.assertFalse(perishableParcel.isExpired(16));
    }
    @Test
    public void IsParcelExpiredBeforeGivenAfterTime(){
        perishableParcel = new PerishableParcel("Холодец",3,"Монино 1",11,5);
        Assertions.assertTrue(perishableParcel.isExpired(18));
    }
}
