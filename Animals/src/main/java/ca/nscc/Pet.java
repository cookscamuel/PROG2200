package ca.nscc;

public interface Pet {
    default String beFriendly() {
        return "We're cool man.";
    }

    default String  play() {
        return "Let's play chess.";
    }
}
