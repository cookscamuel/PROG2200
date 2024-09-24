package ca.nscc;

public class Dog implements Animal, Pet {


    private String name;

    public Dog(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public String play() {
        return name + " is having a blast.";
    }

    public String beFriendly() {
        return name + " is friendly.";
    }

    public String makeSound() {
        return name + " is barking.";
    }
}
