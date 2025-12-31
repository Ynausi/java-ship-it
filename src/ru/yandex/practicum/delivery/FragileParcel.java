package ru.yandex.practicum.delivery;

public class FragileParcel extends Parcel implements  Trackable{
    private String newLocation;

    public String getNewLocation() {
        return newLocation;
    }

    public FragileParcel(String desceription, double weight, String deliveryAddress, int sendDay, String newLocation){
        super(desceription,weight,deliveryAddress,sendDay);
        this.newLocation = newLocation;
    }

    @Override
    public void packageItem(){
        System.out.println("Посылка "+ this.desceription + " обёрнута в защитную плёнку");
        packageItemToAll(this.desceription);
    }

    @Override
    public void deliver(){
        deliverToAll(this.desceription,this.deliveryAddress);
    }

    @Override
    public int calculateDeliveryCost(){
        return (int)this.weight*getFragileCoeff();
    }

    @Override
    public void reportStatus(String newLocation) {
        System.out.println("Хрупкая посылка " + this.desceription +" изменила местоположение на "+newLocation);
    }
}
