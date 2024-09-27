package ca.nscc;

public interface Animal {
    default String makeSound() {
        return "GRUNT";
    }

    void logActivity();
}
