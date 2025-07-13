package nl.novi.backend_eindopdracht.model.user;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import nl.novi.backend_eindopdracht.model.user.enums.RolType;

@Entity
@DiscriminatorValue("STUDENT")
public class Student extends User {

    private String enrolledCourse;
    private boolean competentDeclared;

    public Student() {
        super();
        this.setRole(RolType.STUDENT);
    }

    public Student(String firstname, String lastname, String email, String password, String enrolledCourse) {
        super(firstname, lastname, email, password, RolType.STUDENT);
        this.enrolledCourse = enrolledCourse;
    }

    public String getEnrolledCourse() {
        return enrolledCourse;
    }

    public void setEnrolledCourse(String enrolledCourse) {
        this.enrolledCourse = enrolledCourse;
    }

    // Voeg deze getters en setters toe:
    public boolean isCompetentDeclared() {
        return competentDeclared;
    }

    public void setCompetentDeclared(boolean competentDeclared) {
        this.competentDeclared = competentDeclared;
    }

}
