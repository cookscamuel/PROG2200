/*
    Author: Samuel Cook
    Date: October 3, 2024
    Filename: CarHashMap.java
    Purpose: Utilize hash maps and organize car information.
 */

package ca.nscc;

import java.util.*;

class Car {

    // I just made all of them String. Obviously, this makes no sense if this was going to be a
    // real program that utilized this data, I just didn't want to make a bunch of error handling statements
    // for the user being "stu[pi]d."

    private String model;

    private String year;

    private String color;

    private String price;

    public Car(String model, String year, String color, String price) {
        this.model = model;
        this.year = year;
        this.color = color;
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public String getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public String getPrice() {
        return price;
    }

}


public class CarHashMap {
    public static void main(String[] args) {

        HashMap<Integer, Car> carHashMap = new HashMap<>();
        // create a hash map to store all the cars

        System.out.println("Please enter the number of cars you have rusting away in your backyard: ");
        Scanner scanner = new Scanner(System.in);
        // ask for the number of cars the user wants to enter stats for

        try { // this is to check for the user entering something other than an integer
            int numCars = scanner.nextInt();
            for (int i = 0; i < numCars; i++) {

                System.out.println("Please enter the model of Car #" + (i + 1) + ": ");
                String model = scanner.next();
                System.out.println("Please enter the year of Car #" + (i + 1) + ": ");
                String year = scanner.next();
                System.out.println("Please enter the color of Car #" + (i + 1) + ": ");
                String color = scanner.next();
                System.out.println("Please enter the price of Car #" + (i + 1) + ": ");
                String price = scanner.next();
                // prompt for car stats

                Car car = new Car(model, year, color, price);
                // create a new car object using the most recently entered information

                carHashMap.put(i, car);
                // add the car object to the hashmap with the current count variable as the PK.

                System.out.println("\n=== CAR ADDED SUCCESSFULLY ===\n");

            }

            for (int i = 0; i < numCars; i++) {

                System.out.println("\n=== CAR #" + (i + 1) + " ===");
                System.out.println("MODEL: " + carHashMap.get(i).getModel());
                System.out.println("YEAR: " + carHashMap.get(i).getYear());
                System.out.println("COLOR: " + carHashMap.get(i).getColor());
                System.out.println("PRICE: $" + carHashMap.get(i).getPrice() + "\n");
                // this will print all car information that was entered, using the hashmap index.
            }
        }

        catch (Exception e) {
            System.out.println("Invalid Input.\nExiting...");
        }
        // simply end the program rather than let it crash
    }
}