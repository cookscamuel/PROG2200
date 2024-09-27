package ca.nscc;

public class Cat implements Animal, Pet  {

    private String name;

    Logger logger = Logger.getInstance();

    public Cat(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    public String play() {
        return name + " is playing.";
    }

    public String beFriendly() {
        return name + " is laying in the sun.";
    }

    public String makeSound() {
        return name + " meows.";
    }

    @Override
    public void logActivity() {
        logger.log(LogLevel.DEBUG, getName() + " is alive and well.");
    }
}
