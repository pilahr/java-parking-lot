package parkingLot;

public class ParkingSpot {
    private ParkingSpotType type;
    private Vehicle vehicle;
    private boolean free;

    public ParkingSpot(ParkingSpotType parkingSpotType) {
        this.type = parkingSpotType;
    }

    public ParkingSpotType getType() {
        return type;
    }

    public void setType(ParkingSpotType type) {
        this.type = type;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public boolean isFree() {
        return free;
    }

    public boolean setFree(boolean free) {
        this.free = free;
        return free;
    }
}
