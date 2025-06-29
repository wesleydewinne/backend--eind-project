package nl.novi.backend_eindopdracht.model.user;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("TRAINER")
public class Trainer extends User {

    private String expertise;

    public Trainer() { }

    public Trainer(String username, String email, String password, String expertise) {
        super(username, email, password);
        this.expertise = expertise;
    }

    public String getExpertise() {
        return expertise;
    }

    public void setExpertise(String expertise) {
        this.expertise = expertise;
    }
}
