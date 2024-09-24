package ca.nscc;

public interface WildAnimal {
    default String hunt() {
        return "I will tear off your skin.";
    }
}
