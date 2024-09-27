package ca.nscc;

public class Dog implements Animal, Pet {


    private String name;

    Logger logger = Logger.getInstance();

    public Dog(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public String getName() {
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

    @Override
    public void logActivity() {
        logger.log(LogLevel.DEBUG, getName() + " is alive and well.");
    }

}
