package nl.novi.backend_eindopdracht.model.user;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import nl.novi.backend_eindopdracht.model.user.enums.RolType;

@Entity
@DiscriminatorValue("TRAINER")
public class Trainer extends User {

    private String expertise;

    public Trainer() {
        super();
        this.setRole(RolType.TRAINER); // Zet default rol
    }

    public Trainer(String fistname, String lastname, String email, String password, String expertise) {
        super(fistname, lastname, email, password, RolType.TRAINER);
        this.expertise = expertise;
    }

    public String getExpertise() {
        return expertise;
    }

    public void setExpertise(String expertise) {
        this.expertise = expertise;
    }
}

