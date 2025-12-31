package ru.yandex.practicum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.yandex.practicum.delivery.FragileParcel;
import ru.yandex.practicum.delivery.PerishableParcel;
import ru.yandex.practicum.delivery.StandardParcel;

public class DeliveryCostTest {

    private static PerishableParcel perishableParcel;
    private static StandardParcel standardParcel;
    private static FragileParcel fragileParcel;

    @BeforeAll
    public static void beforeAll(){
        perishableParcel = new PerishableParcel("Холодец",3,"Монино 1",11,5);
        standardParcel = new StandardParcel("Ковёр",18,"Париж 1",2);
        fragileParcel = new FragileParcel("Графин",3,"Аллуа 2", 5,"London");
    }


    @Test
    public void PerishableIfAmountPriceIsRight(){
        int expectedSum = 3*3;
        Assertions.assertEquals(expectedSum,perishableParcel.calculateDeliveryCost());
    }
    @Test
    public void FragileIfAmountPriceIsRight(){
        int expectedSum = 3*4;
        Assertions.assertEquals(expectedSum,fragileParcel.calculateDeliveryCost());
    }
    @Test
    public void StandardIfAmountPriceIsRight(){
        int expectedSum = 18*2;
        Assertions.assertEquals(expectedSum,standardParcel.calculateDeliveryCost());
    }




}
