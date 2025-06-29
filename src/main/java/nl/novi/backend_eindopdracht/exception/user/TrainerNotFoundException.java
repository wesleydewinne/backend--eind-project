package nl.novi.backend_eindopdracht.exception.user;

public class TrainerNotFoundException extends RuntimeException {
    public TrainerNotFoundException(Long id) {
        super("Trainer met id " + id + " niet gevonden.");
    }

    public TrainerNotFoundException(String message) {
        super(message);
    }
}
