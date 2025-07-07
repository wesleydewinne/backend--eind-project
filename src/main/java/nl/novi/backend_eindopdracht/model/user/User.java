package nl.novi.backend_eindopdracht.model.user;

import jakarta.persistence.*;
import nl.novi.backend_eindopdracht.model.user.enums.RolType;

@MappedSuperclass
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "user_type")
public abstract class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstname;
    private String lastname;
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private RolType role;

    public User() { }

    public User(String firstname, String lastname, String email, String password, RolType role) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    // Getters en setters
    public Long getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() { return lastname; }
    public void setLastname(String lastname) { this.lastname = lastname;}

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

    public RolType getRole() {
        return role;
    }
    public void setRole(RolType role) {
        this.role = role;
    }
}
