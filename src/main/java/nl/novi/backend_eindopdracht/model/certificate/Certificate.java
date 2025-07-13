package nl.novi.backend_eindopdracht.model.certificate;

import jakarta.persistence.*;
import nl.novi.backend_eindopdracht.model.course.Course;
import nl.novi.backend_eindopdracht.model.user.Student;
import java.time.LocalDate;

@Entity
public class Certificate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate issueDate;

    private String certificateUrl;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    public Certificate() { }

    public Certificate(LocalDate issueDate, String certificateUrl, Student student, Course course) {
        this.issueDate = issueDate;
        this.certificateUrl = certificateUrl;
        this.student = student;
        this.course = course;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public String getCertificateUrl() {
        return certificateUrl;
    }

    public void setCertificateUrl(String certificateUrl) {
        this.certificateUrl = certificateUrl;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
