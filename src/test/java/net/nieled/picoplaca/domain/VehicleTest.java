package net.nieled.picoplaca.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class VehicleTest {

    @Test
    public void setPlateNumber() {
        // 4 digits
        Vehicle vehicle = new Vehicle("AAA-0000");
        assertEquals("AAA-0000", vehicle.getPlateNumber());

        // 3 digits
        vehicle.setPlateNumber("BBB-111");
        assertEquals("BBB-111", vehicle.getPlateNumber());
    }

    @Test(expected = IllegalArgumentException.class)
    public void setWrongPlateNumber() {
        new Vehicle("123-XXXX");
    }
}