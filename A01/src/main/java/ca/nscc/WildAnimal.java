package ca.nscc;

public interface WildAnimal extends Animal {
    default String hunt() {
        return "I will tear off your skin.";
    }
}
