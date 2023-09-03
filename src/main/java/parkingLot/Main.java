package parkingLot;

import java.util.Scanner;

public class Main {
    static ParkingLot parkingLot = new ParkingLot(2, 2, 2);

    public static void start() {
        System.out.println("\t\t-------------------------------------");
        System.out.println("\t\t|\tWelcome to the Car Park\t\t\t|");
        System.out.println("\t\t|\tPlease select the valid option\t|");
        System.out.println("\t\t|\t\t\t\t\t\t\t\t\t|");
        System.out.println("\t\t|\t1: Check the availability\t\t|");
        System.out.println("\t\t|\t2: Park your vehicle\t\t\t|");
        System.out.println("\t\t|\t3: Unparking your vehicle\t\t|");
        System.out.println("\t\t|\t4: Exit\t\t\t\t\t\t\t|");
        System.out.println("\t\t-------------------------------------");

        Scanner scanner = new Scanner(System.in);
        String option = scanner.nextLine();

        if (option.equals("1")) {
            parkingLot.spotsAvailable();
            start();
        } else if (option.equals("2")) {
            System.out.println("Please Select the vehicle type you're parking");
            System.out.println("1:Van    |    2:Car    |    3:Motorcycle");
            parkingOption();
            start();

        } else if (option.equals("3")) {
            System.out.println("Please Select the vehicle type that you're unparking");
            System.out.println("1:Van    |    2:Car    |    3:Motorcycle");

            unparkingOption();
            start();

        } else if (option.equals("4")) {
            System.out.println("Exiting the Car Park..");
        } else {
            System.out.println("Please select a valid option");
            start();
        }
    }

    public static void parkingOption() {
        Scanner scanner = new Scanner(System.in);
        String option = scanner.nextLine();

        if (option.equals("1")) {
            Vehicle van = new Vehicle(VehicleType.VAN);
            parkingLot.parkVehicle(van);
        } else if (option.equals("2")) {
            Vehicle car = new Vehicle(VehicleType.CAR);
            parkingLot.parkVehicle(car);
        } else if (option.equals("3")) {
            Vehicle motorcycle = new Vehicle(VehicleType.MOTORCYCLE);
            parkingLot.parkVehicle(motorcycle);
        }
    }

    public static void unparkingOption() {
        Scanner scanner = new Scanner(System.in);
        String option = scanner.nextLine();


        if (option.equals("1")) {
            Vehicle van = new Vehicle(VehicleType.VAN);
            if (parkingLot != null && van != null)
                parkingLot.unParkVehicle(van);
        } else if (option.equals("2")) {
            Vehicle car = new Vehicle(VehicleType.CAR);
            if (parkingLot != null && car != null)
                parkingLot.unParkVehicle(car);
        } else if (option.equals("3")) {
            Vehicle motorcycle = new Vehicle(VehicleType.MOTORCYCLE);
            if (parkingLot != null && motorcycle != null)
                parkingLot.unParkVehicle(motorcycle);
        }

    }


    public static void main(String[] args) {
        start();
    }
}
