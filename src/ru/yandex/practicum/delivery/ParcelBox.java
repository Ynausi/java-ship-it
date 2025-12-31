package ru.yandex.practicum.delivery;

import java.util.ArrayList;

public class ParcelBox<T extends Parcel>{
    private ArrayList<T> parcelbox = new ArrayList<>();
    private int maxWeight;

    public ParcelBox(int maxWeight){
        this.maxWeight = maxWeight;
    }

    public void addParcel(T parcel){
        if(!parcelbox.isEmpty()){
            int currentWeight=0;
            for(Parcel a:parcelbox){
                currentWeight+=a.getWeight();
            }
            if(currentWeight+ parcel.getWeight()<=this.maxWeight){
                parcelbox.add(parcel);
            }
            else{
                System.out.println("В эту коробку уже не влезет");
            }
        }
        else{
            parcelbox.add(parcel);
        }
    }
    public void getAllParcels(){
        if(!parcelbox.isEmpty()){
            System.out.println("В коробке" + parcelbox + "находятся следующие посылки:");
            for(Parcel a:parcelbox){
                System.out.println(a.getDesceription());
            }
        }
        else{
            System.out.println("Братишка коробка ещё пустая, откисай");
        }
    }
    public int size(){
        return parcelbox.size();
    }


}
