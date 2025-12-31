package ru.yandex.practicum.delivery;

public abstract class Parcel {
    final int standardCoeff = 2;
    final int perishableCoeff = 3;
    final int fragileCoeff = 4;

    protected String desceription;
    protected double weight;
    protected String deliveryAddress;
    protected int sendDay;
    public Parcel(String desceription,double weight,String deliveryAddress, int sendDay){
        this.desceription = desceription;
        this.weight = weight;
        this.deliveryAddress = deliveryAddress;
        this.sendDay = sendDay;
    }

    public abstract void packageItem();

    public abstract void deliver();

    public abstract int calculateDeliveryCost();

    protected void packageItemToAll(String desceription){
        System.out.println("Посылка "+ desceription + " упакована");
    }

    protected void deliverToAll(String desceription, String deliveryAddress){
        System.out.println("Посылка " + desceription + " доставлена по адресу " + deliveryAddress);
    }

    public String getDesceription() {
        return desceription;
    }

    public double getWeight() {
        return weight;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public int getSendDay() {
        return sendDay;
    }

    public int getStandardCoeff() {
        return standardCoeff;
    }

    public int getFragileCoeff() {
        return fragileCoeff;
    }

    public int getPerishableCoeff() {
        return perishableCoeff;
    }
}
