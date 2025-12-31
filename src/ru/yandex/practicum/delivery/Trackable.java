package ru.yandex.practicum.delivery;

import java.util.ArrayList;

public interface Trackable{


    ArrayList<Parcel> trackableParcel = new ArrayList<>();
    void reportStatus(String newLocation);





}
