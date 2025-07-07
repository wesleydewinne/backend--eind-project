package nl.novi.backend_eindopdracht.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class UserInputDto {

    @NotBlank(message = "Voornaam is verplicht")
    private String firstname;

    @NotBlank(message = "Achternaam is verplicht")
    private String lastname;

    @Email(message = "Ongeldig e-mailadres")
    @NotBlank(message = "E-mailadres is verplicht")
    private String email;

    @NotBlank(message = "Wachtwoord is verplicht")
    private String password;

    public UserInputDto() {}

    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}