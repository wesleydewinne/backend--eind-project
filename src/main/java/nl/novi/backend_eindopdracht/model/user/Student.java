package nl.novi.backend_eindopdracht.model.user;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import nl.novi.backend_eindopdracht.model.user.enums.RolType;

@Entity
@DiscriminatorValue("STUDENT")
public class Student extends User {

    private String enrolledCourse;

    public Student() {
        super();
        this.setRole(RolType.STUDENT); // Of RolType.STUDENT als dat zo heet in je enum
    }

    public Student(String name, String email, String password, String enrolledCourse) {
        super(name, email, password, RolType.STUDENT);
        this.enrolledCourse = enrolledCourse;
    }

    public String getEnrolledCourse() {
        return enrolledCourse;
    }

    public void setEnrolledCourse(String enrolledCourse) {
        this.enrolledCourse = enrolledCourse;
    }
}
