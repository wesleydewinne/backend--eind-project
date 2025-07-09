package nl.novi.backend_eindopdracht.dto.user;

public class TrainerSummaryDto {
    private Long id;
    private String firstname;
    private String lastname;
    private String email;

    // Constructors
    public TrainerSummaryDto() { }

    public TrainerSummaryDto(Long id, String firstname, String lastname, String email) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getFirstname() { return firstname; }
    public void setFirstname(String firstname) { this.firstname = firstname; }

    public String getLastname() { return lastname; }
    public void setLastname(String lastname) { this.lastname = lastname; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
