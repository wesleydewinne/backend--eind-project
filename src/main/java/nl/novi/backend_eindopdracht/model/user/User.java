package nl.novi.backend_eindopdracht.model.user;

import jakarta.persistence.*;
import nl.novi.backend_eindopdracht.model.user.enums.RolType;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "user_type")
public abstract class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private RolType role;

    public User() { }

    public User(String name, String email, String password, RolType role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    // Getters en setters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
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

    public RolType getRole() {
        return role;
    }
    public void setRole(RolType role) {
        this.role = role;
    }
}
