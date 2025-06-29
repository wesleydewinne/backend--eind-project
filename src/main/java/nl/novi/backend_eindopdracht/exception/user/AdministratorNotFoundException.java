package nl.novi.backend_eindopdracht.exception.user;

public class AdministratorNotFoundException extends RuntimeException {
    public AdministratorNotFoundException(Long id) {
        super("Administrator met id " + id + " niet gevonden.");
    }

    public AdministratorNotFoundException(String message) {
        super(message);
    }
}
