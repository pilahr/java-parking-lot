package parkingLot;

//### Assumptions
//- The parking lot can hold motorcycles, cars and vans
//- The parking lot has motorcycle spots, car spots and large spots
//- A motorcycle can park in any spot
//- A car can park in a single compact spot, or a regular spot
//- A van can park, but it will take up 3 regular spots
//- These are just a few assumptions. Feel free to ask your interviewer about more assumptions as needed

//### Specifications
//Here are a few methods that you should be able to run:

//- Tell us how many spots are remaining
//- Tell us how many total spots are in the parking lot
//- Tell us when the parking lot is full
//- Tell us when the parking lot is empty
//- Tell us when certain spots are full e.g. when all motorcycle spots are taken
//- Tell us how many spots vans are taking up

import parkingLot.spots.BikeSpot;
import parkingLot.spots.CompactSpot;
import parkingLot.spots.LargeSpot;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    List<CompactSpot> compactSpotList = new ArrayList<>();
    List<LargeSpot> largeSpotList = new ArrayList<>();
    List<BikeSpot> bikeSpotList = new ArrayList<>();


    int freeCompactSpots;
    int freeLargeSpots;
    int freeBikeSpots;


    public ParkingLot(int freeCompactSpots, int freeLargeSpots, int freeBikeSpots) {
        this.freeCompactSpots = freeCompactSpots;
        this.freeLargeSpots = freeLargeSpots;
        this.freeBikeSpots = freeBikeSpots;
    }

    // park vehicle
    public void parkVehicle(Vehicle vehicle) {
        System.out.println("Checking for a parking space for your " + vehicle.getVehicleType());

        if (vehicle.getVehicleType().equals(VehicleType.VAN)) {
            if (freeLargeSpots > 0) {
                parkYourLargeVehicle(vehicle);
            } else {
                System.out.println("Sorry all large spots are full");
            }

        } else if (vehicle.getVehicleType().equals(VehicleType.CAR)) {
            if (freeCompactSpots > 0) {
                parkYourCompactVehicle(vehicle);
            } else if (freeLargeSpots > 0) {
                parkYourLargeVehicle(vehicle);
            } else {
                System.out.println("Sorry neither large or compact spots available");
            }

        } else if (vehicle.getVehicleType().equals(VehicleType.MOTORCYCLE)) {
            if (freeBikeSpots > 0) {
                parkYourBikeVehicle(vehicle);
            } else if (freeCompactSpots > 0) {
                parkYourCompactVehicle(vehicle);
            } else if (freeLargeSpots > 0) {
                parkYourLargeVehicle(vehicle);
            } else {
                System.out.println("Sorry neither large, compact or bike spots available");
                System.out.println("***** CAR PARK IS FULL *****");
            }
        }
    }

    public void parkYourLargeVehicle(Vehicle vehicle) {
        LargeSpot largeSpot = new LargeSpot(ParkingSpotType.LARGE);
        largeSpot.setFree(false);
        largeSpot.setVehicle(vehicle);
        vehicle.setParkingSpot(largeSpot);

        largeSpotList.add(largeSpot);
        System.out.println("We have successfully parked your " + vehicle.getVehicleType());
        freeLargeSpots--;
        spotsAvailable();
    }

    public void parkYourCompactVehicle(Vehicle vehicle) {
        CompactSpot compactSpot = new CompactSpot(ParkingSpotType.COMPACT);
        compactSpot.setFree(false);
        compactSpot.setVehicle(vehicle);
        vehicle.setParkingSpot(compactSpot);

        compactSpotList.add(compactSpot);
        System.out.println("We have successfully parked your " + vehicle.getVehicleType());
        freeCompactSpots--;
        spotsAvailable();
    }

    public void parkYourBikeVehicle(Vehicle vehicle) {
        BikeSpot bikeSpot = new BikeSpot(ParkingSpotType.BIKE);
        bikeSpot.setFree(false);
        bikeSpot.setVehicle(vehicle);
        vehicle.setParkingSpot(bikeSpot);

        bikeSpotList.add(bikeSpot);
        System.out.println("We have successfully parked your " + vehicle.getVehicleType());
        freeBikeSpots--;
        spotsAvailable();
    }

    public void spotsAvailable() {
        int totalSpots = freeLargeSpots + freeCompactSpots + freeBikeSpots;

        System.out.println();
        System.out.println("================================================");
        isEmpty();
        isFull();
        System.out.println();
        System.out.println("** There are totally " + (totalSpots) + " parking spots available **");
        System.out.println();
        System.out.println("Large Spots available: " + freeLargeSpots);
        System.out.println("Compact Spots available: " + freeCompactSpots);
        System.out.println("Bike Spots available: " + freeBikeSpots);
        System.out.println();


        System.out.println();
        System.out.println("Vans are taking up: " + (largeSpotList.size()) + " spots");
        System.out.println("Cars are taking up: " + (compactSpotList.size()) + " spots");
        System.out.println("Motorcycles are taking up: " + (bikeSpotList.size()) + " spots");
        System.out.println("================================================");
    }

    public void isEmpty() {
        int totalSpots = freeLargeSpots + freeCompactSpots + freeBikeSpots;

        if (totalSpots == (freeLargeSpots + freeCompactSpots + freeBikeSpots) && (largeSpotList.size() + compactSpotList.size() + bikeSpotList.size()) == 0) {
            System.out.println("***** CAR PARK IS EMPTY *****");
        }
    }

    public void isFull() {
        int totalSpots = freeLargeSpots + freeCompactSpots + freeBikeSpots;

        if (totalSpots == 0) {
            System.out.println("***** CAR PARK IS FULL *****");
        }
    }

    // un park vehicle
    public void unParkVehicle(Vehicle vehicle) {
        System.out.println("We are about to unpark or remove your vehicle of type " + vehicle.getVehicleType());

        // empty the parking spot
        ParkingSpot parkingSpot = vehicle.getParkingSpot();
        parkingSpot.setFree(true);


        if (vehicle.getVehicleType().equals(VehicleType.VAN)) {
            if (largeSpotList.remove(parkingSpot)) {
                System.out.println("We have successfully removed your vehicle");
                freeLargeSpots++;
            } else {
                System.out.println("You don't have your vehicle parked at this parking lot");
            }
            spotsAvailable();

        } else if (vehicle.getVehicleType().equals(VehicleType.CAR)) {
            if (compactSpotList.remove(parkingSpot)) {
                System.out.println("We have successfully removed your vehicle");
                freeCompactSpots++;
            } else {
                System.out.println("You don't have your vehicle parked at this parking lot");
            }
            spotsAvailable();

        } else if (vehicle.getVehicleType().equals(VehicleType.MOTORCYCLE)) {
            if (bikeSpotList.remove(parkingSpot)) {
                System.out.println("We have successfully removed your vehicle");
                freeBikeSpots++;
            } else {
                System.out.println("You don't have your vehicle parked at this parking lot");
            }
            spotsAvailable();
        }
    }
}
