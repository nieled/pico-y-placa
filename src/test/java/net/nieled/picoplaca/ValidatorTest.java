package net.nieled.picoplaca;

import net.nieled.picoplaca.domain.Vehicle;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.*;

public class ValidatorTest {

    @Test
    public void getDayOfWeek() {
        assertEquals(2, Validator.getDayOfWeek(new Vehicle("ABC-002")));
        assertEquals(3, Validator.getDayOfWeek(new Vehicle("ABC-1233")));
        assertEquals(4, Validator.getDayOfWeek(new Vehicle("ABC-1235")));
        assertEquals(5, Validator.getDayOfWeek(new Vehicle("ABC-1237")));
        assertEquals(6, Validator.getDayOfWeek(new Vehicle("ABC-1239")));
    }

    @Test
    public void isAllowedCalendar() throws ParseException {
        Vehicle vehicle = new Vehicle("AAA-0001");
        Calendar calendar = Calendar.getInstance();

        calendar.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2020-01-20 06:00:00"));
        assertTrue(Validator.isAllowed(vehicle, calendar));

        calendar.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2020-01-20 08:00:00"));
        assertFalse(Validator.isAllowed(vehicle, calendar));

        calendar.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2020-01-20 17:00:00"));
        assertFalse(Validator.isAllowed(vehicle, calendar));

        calendar.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2020-01-20 20:00:00"));
        assertTrue(Validator.isAllowed(vehicle, calendar));
    }

    @Test
    public void isAllowedDate() throws ParseException {
        Vehicle vehicle = new Vehicle("AAA-0001");
        Date time1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2020-01-20 06:50:00");
        Date time2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2020-01-20 09:00:00");
        Date time3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2020-01-20 09:35:00");
        assertTrue(Validator.isAllowed(vehicle, time1));
        assertFalse(Validator.isAllowed(vehicle, time2));
        assertTrue(Validator.isAllowed(vehicle, time3));
    }
}