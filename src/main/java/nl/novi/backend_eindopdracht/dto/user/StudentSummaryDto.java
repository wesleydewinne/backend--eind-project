package nl.novi.backend_eindopdracht.dto.user;

public class StudentSummaryDto {
    private Long id;
    private String firstname;
    private String lastname;
    private String email;               // Email toegevoegd
    private boolean presentMorning;
    private boolean competentDeclared;
    private String certificateUrl;

    public StudentSummaryDto() {}

    public StudentSummaryDto(Long id, String firstname, String lastname, String email,
                             boolean presentMorning, boolean competentDeclared, String certificateUrl) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.presentMorning = presentMorning;
        this.competentDeclared = competentDeclared;
        this.certificateUrl = certificateUrl;
    }

    // Getters & Setters (inclusief email)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getFirstname() { return firstname; }
    public void setFirstname(String firstname) { this.firstname = firstname; }

    public String getLastname() { return lastname; }
    public void setLastname(String lastname) { this.lastname = lastname; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public boolean isPresentMorning() { return presentMorning; }
    public void setPresentMorning(boolean presentMorning) { this.presentMorning = presentMorning; }

    public boolean isCompetentDeclared() { return competentDeclared; }
    public void setCompetentDeclared(boolean competentDeclared) { this.competentDeclared = competentDeclared; }

    public String getCertificateUrl() { return certificateUrl; }
    public void setCertificateUrl(String certificateUrl) { this.certificateUrl = certificateUrl; }
}
