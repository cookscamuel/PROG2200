package ca.nscc;

import java.util.ArrayList;
import java.util.concurrent.Callable;

public class Main {
    public static void main(String[] args) {

        System.out.println(" ");

        Dog rover = new Dog("Rover");
        Cat ginger = new Cat("Ginger");
        Lion leo = new Lion("Leo");

        System.out.println("DOG: " + rover);
        System.out.println("CAT: " + ginger);
        System.out.println("LION: " + leo + "\n");

        System.out.println(rover.play());
        System.out.println(rover.beFriendly());
        System.out.println(rover.makeSound() + "\n");

        System.out.println(ginger.play());
        System.out.println(ginger.beFriendly());
        System.out.println(ginger.makeSound() + "\n");

        System.out.println(leo.hunt());
        System.out.println(leo.makeSound() + "\n");


        ginger.logActivity();
        rover.logActivity();
        leo.logActivity();

        String[] dogNames = {"Perry", "Jack", "Danny", "Seth"};

        ArrayList<Dog> Dogs = new ArrayList<>();

        for (int i=0; i<dogNames.length; i++) {
            Dogs.add(new Dog(dogNames[i]));
        }

        for (int i=0; i<Dogs.size(); i++) {
            Dogs.get(i).logActivity();
        }

    }
}