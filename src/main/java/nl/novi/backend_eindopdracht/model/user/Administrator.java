package nl.novi.backend_eindopdracht.model.user;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import nl.novi.backend_eindopdracht.model.user.enums.RolType;

@Entity
@DiscriminatorValue("ADMINISTRATOR")
public class Administrator extends User {

    private String roleDescription;

    public Administrator() {
        super();
        this.setRole(RolType.ADMINISTRATOR);  // Stel de rol standaard in
    }

    public Administrator(String firstname, String lastname, String email, String password, String roleDescription) {
        super(firstname, lastname,  email, password, RolType.ADMINISTRATOR);
        this.roleDescription = roleDescription;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }
}

