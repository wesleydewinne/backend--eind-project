package nl.novi.backend_eindopdracht.model.user;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("ADMINISTRATOR")
public class Administrator extends User {

    private String roleDescription;

    public Administrator() { }

    public Administrator(String username, String email, String password, String roleDescription) {
        super(username, email, password);
        this.roleDescription = roleDescription;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }
}
