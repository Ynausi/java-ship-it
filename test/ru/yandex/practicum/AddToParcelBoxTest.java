package ru.yandex.practicum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.yandex.practicum.delivery.*;

public class AddToParcelBoxTest {

    private  ParcelBox<StandardParcel> standardParcelBox;
    private  StandardParcel parcelOne;
    private  StandardParcel parcelTwo;
    private  StandardParcel parcelThree;

    @BeforeEach
    public void beforeEach(){
        standardParcelBox = new ParcelBox<>(5);
        parcelOne = new StandardParcel("Ковер",2,"London 2",11);
        parcelTwo = new StandardParcel("Ковер",3,"London 2",11);
        parcelThree = new StandardParcel("Ковер",5,"London 2",11);
    }

    @Test
    public void addToParcelBoxBeforeMaxWeight(){
        standardParcelBox.addParcel(parcelOne);
        Assertions.assertEquals(1,standardParcelBox.size());
    }

    @Test
    public void addToParcelBoxInMaxWeight(){
        standardParcelBox.addParcel(parcelOne);
        standardParcelBox.addParcel(parcelTwo);
        Assertions.assertEquals(2,standardParcelBox.size());
    }

    @Test
    public void addToParcelBoxAfterMaxWeight(){
        standardParcelBox.addParcel(parcelOne);
        standardParcelBox.addParcel(parcelTwo);
        standardParcelBox.addParcel(parcelThree);
        Assertions.assertEquals(2,standardParcelBox.size());
    }
}
