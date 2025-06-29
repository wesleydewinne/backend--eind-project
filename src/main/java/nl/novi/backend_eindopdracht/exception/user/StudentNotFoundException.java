package nl.novi.backend_eindopdracht.exception.user;

public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException(Long id) {
        super("Student met id " + id + " niet gevonden.");
    }

    public StudentNotFoundException(String message) {
        super(message);
    }
}
