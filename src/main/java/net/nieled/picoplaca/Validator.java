package net.nieled.picoplaca;

import net.nieled.picoplaca.domain.Vehicle;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

public class Validator {

    public static int getDayOfWeek(Vehicle vehicle) {
        String plateNumber = vehicle.getPlateNumber();
        switch (Integer.parseInt(plateNumber.substring(plateNumber.length() - 1))) {
            case 1:
            case 2:
                return Calendar.MONDAY;
            case 3:
            case 4:
                return Calendar.TUESDAY;
            case 5:
            case 6:
                return Calendar.WEDNESDAY;
            case 7:
            case 8:
                return Calendar.THURSDAY;
            case 9:
            case 0:
                return Calendar.FRIDAY;
            default:
                return -1;
        }
    }

    public static boolean isAllowed(Vehicle vehicle, Date date) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return isAllowed(vehicle, calendar);
    }

    public static boolean isAllowed(Vehicle vehicle, Calendar calendar) throws ParseException {
        if (calendar.get(Calendar.DAY_OF_WEEK) == getDayOfWeek(vehicle)) {
            Calendar start = (Calendar) calendar.clone();
            Calendar end = (Calendar) calendar.clone();

            // 7:00 to 9:30
            start.set(Calendar.HOUR_OF_DAY, 7);
            start.set(Calendar.MINUTE, 0);
            end.set(Calendar.HOUR_OF_DAY, 9);
            end.set(Calendar.MINUTE, 30);
            if (calendar.after(start) && calendar.before(end)) return false;

            // 7:00 to 9:30
            start.set(Calendar.HOUR_OF_DAY, 16);
            start.set(Calendar.MINUTE, 0);
            end.set(Calendar.HOUR_OF_DAY, 19);
            end.set(Calendar.MINUTE, 30);
            if (calendar.after(start) && calendar.before(end)) return false;
        }
        return true;
    }
}
