package net.nieled.picoplaca;

import net.nieled.picoplaca.domain.Vehicle;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("===Pico y Placa checker===");
        System.out.println("Plate number: [ABC-1234]");
        Vehicle vehicle = new Vehicle(scanner.nextLine());
        System.out.println("Date: [yyyy-MM-dd]");
        String date = scanner.nextLine();
        System.out.println("Time of circulation: [hh:mm]");
        String time = scanner.nextLine();

        try {
            Date inputDate = new SimpleDateFormat("yyyy-MM-dd HH:mm")
                    .parse(date.trim() + " " + time.trim());
            if (Validator.isAllowed(vehicle, inputDate)) {
                System.out.println("Allowed to go on the road :)");
            } else {
                System.out.println("Pico y Placa time! You should not be on the road");
            }

        } catch (ParseException e) {
            System.out.println("Bad input format!");
        }
    }
}
