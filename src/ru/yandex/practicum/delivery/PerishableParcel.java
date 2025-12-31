package ru.yandex.practicum.delivery;

public class PerishableParcel extends Parcel{
    private int timeToLive;

    public PerishableParcel(String desceription,double weight,String deliveryAddress, int sendDay,int timeToLive){
        super(desceription,weight,deliveryAddress,sendDay);
        this.timeToLive = timeToLive;
    }

    public boolean isExpired(int currentDay){
        boolean b = false;
        if(this.sendDay+this.timeToLive>=currentDay){
            b =  false;
        }
        else{
            b =  true;
        }
        return b;
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
        return (int) this.weight*getPerishableCoeff();
    }

    public int getTimeToLive() {
        return timeToLive;
    }
}
