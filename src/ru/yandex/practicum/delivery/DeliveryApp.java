package ru.yandex.practicum.delivery;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeliveryApp {

    private static final Scanner scanner = new Scanner(System.in);
    private static List<Parcel> allParcels = new ArrayList<>();
    private static ParcelBox<StandardParcel> standardParcelBox = new ParcelBox<>(14);
    private static ParcelBox<FragileParcel> fragileParcelBox = new ParcelBox<>(15);
    private static ParcelBox<PerishableParcel> perishableParcelBox = new ParcelBox<>(16);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            showMenu();
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addParcel();
                    break;
                case 2:
                    sendParcels();
                    break;
                case 3:
                    calculateCosts();
                    break;
                case 4:
                    reportAllStatus();
                    break;
                case 5:
                    System.out.println("В какую коробку хотите заглянуть?");
                    System.out.println("1 - Стандартная, 2 - Хрупкая, 3 - Скоропотящаяся");
                    int k  = Integer.parseInt(scanner.nextLine());
                    if(k ==1 ) standardParcelBox.getAllParcels();
                    if(k ==2 ) fragileParcelBox.getAllParcels();
                    if(k ==3 ) perishableParcelBox.getAllParcels();
                    else{
                        System.out.println("Неверный выбор.");
                        continue;
                    }
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Неверный выбор.");
            }
        }
    }
    private static void showMenu() {
        System.out.println("Выберите действие:");
        System.out.println("1 — Добавить посылку");
        System.out.println("2 — Отправить все посылки");
        System.out.println("3 — Посчитать стоимость доставки");
        System.out.println("4 - Узнать нахождение всех отслеживаемых посылок");
        System.out.println("5 - Показать содержимое коробки");
        System.out.println("0 — Завершить");
    }

    // реализуйте методы ниже

    private static void addParcel() {
        System.out.println("Введите тип посылки");
        String kindOfPackage = scanner.nextLine();
        System.out.println("Введите: описание, массу, адресс и день отправки ");
        String description = scanner.nextLine();
        int weight = Integer.parseInt(scanner.nextLine());
        String adress = scanner.nextLine();
        int sendDay = Integer.parseInt(scanner.nextLine());
        if(kindOfPackage.equals("Хрупкая")){
            System.out.println("Где посылка находится сейчас?");
            String newLocation = scanner.nextLine();
            FragileParcel parcel = new FragileParcel(description,weight,adress,sendDay,newLocation);
            allParcels.add(parcel);
            Trackable.trackableParcel.add(parcel);
            fragileParcelBox.addParcel(parcel);
        }
        if(kindOfPackage.equals("Стандартная")){
            StandardParcel parcel = new StandardParcel(description,weight,adress,sendDay);
            allParcels.add(parcel);
            standardParcelBox.addParcel(parcel);
        }
        if(kindOfPackage.equals("Портящаяся")){
            System.out.println("Введите через сколько посылка испортится");
            int timeToLive = Integer.parseInt(scanner.nextLine());
            PerishableParcel parcel = new PerishableParcel(description,weight,adress,sendDay,timeToLive);
            allParcels.add(parcel);
            perishableParcelBox.addParcel(parcel);
        }
        // Подсказка: спросите тип посылки и необходимые поля, создайте объект и добавьте в allParcels
    }

    private static void sendParcels() {
        for(Parcel a: allParcels){
            a.packageItem();
            a.deliver();
        }
        // Пройти по allParcels, вызвать packageItem() и deliver()
    }

    private static void calculateCosts() {
        int sum=0;
        for(Parcel a:allParcels){
            sum+=a.calculateDeliveryCost();
        }
        System.out.println("Общая сумма доставки "+ sum);
        // Посчитать общую стоимость всех доставок и вывести на экран
    }
    private static void reportAllStatus(){
        for(Parcel a: allParcels){
            if(a instanceof FragileParcel){
                FragileParcel b = (FragileParcel) a;
                b.reportStatus(b.getNewLocation());
            }
        }
    }

}

