package ca.nscc;

public class Lion implements WildAnimal {

    private String name;

    Logger logger = Logger.getInstance();

    public Lion(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }

    public String hunt() {
        return name + " uses proper table manners and politely eats his lunch.";
    }

    public String makeSound() {
        return name + " roars.";
    }

    @Override
    public void logActivity() {
        logger.log(LogLevel.DEBUG, getName() + " is alive and well.");
    }

}
