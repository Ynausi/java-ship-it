package ru.yandex.practicum.delivery;

public class StandardParcel extends Parcel {

    public StandardParcel(String desceription,double weight,String deliveryAddress, int sendDay){
        super(desceription,weight,deliveryAddress,sendDay);
    }

    @Override
    public void packageItem(){
        packageItemToAll(this.desceription);
    }


    @Override
    public void deliver(){
        deliverToAll(this.desceription,this.deliveryAddress);
    }

    @Override
    public int calculateDeliveryCost(){

        return (int) (this.weight*getStandardCoeff());
    }
}

