package net.nieled.picoplaca.domain;

public class Vehicle {

    private String plateNumber;

    public Vehicle(String plateNumber) {
        setPlateNumber(plateNumber);
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        if (plateNumber.matches("^[A-Za-z]{3}-[0-9]{3,4}$")) {
            this.plateNumber = plateNumber;
        } else {
            throw new IllegalArgumentException("Not a valid plate number");
        }
    }
}
