package nl.novi.backend_eindopdracht.model.course;

import jakarta.persistence.*;
import nl.novi.backend_eindopdracht.model.user.Trainer;
import nl.novi.backend_eindopdracht.model.user.Student;

import nl.novi.backend_eindopdracht.model.course.CourseType;
import nl.novi.backend_eindopdracht.model.course.CourseStatus;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String courseCode;
    private LocalDate trainingDate;
    private String groupNumber;
    private String description;
    private LocalTime startTime;
    private LocalTime endTime;

    @Enumerated(EnumType.STRING)
    private CourseType courseType;

    @Enumerated(EnumType.STRING)
    private CourseStatus status;

    private int maxParticipants = 10;
    private int availableSpots;

    @ManyToOne
    @JoinColumn(name = "trainer_id")
    private Trainer trainer;

    @ManyToMany
    @JoinTable(
            name = "course_students",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private Set<Student> students = new HashSet<>();

    public Course() {}

    @PrePersist
    public void generateCourseCode() {
        this.courseCode = "CRS-" + System.currentTimeMillis();
        this.availableSpots = maxParticipants;
    }

    // Getters en setters hieronder

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCourseCode() { return courseCode; }
    public void setCourseCode(String courseCode) { this.courseCode = courseCode; }

    public LocalDate getTrainingDate() { return trainingDate; }
    public void setTrainingDate(LocalDate trainingDate) { this.trainingDate = trainingDate; }

    public String getGroupNumber() { return groupNumber; }
    public void setGroupNumber(String groupNumber) { this.groupNumber = groupNumber; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public LocalTime getStartTime() { return startTime; }
    public void setStartTime(LocalTime startTime) { this.startTime = startTime; }

    public LocalTime getEndTime() { return endTime; }
    public void setEndTime(LocalTime endTime) { this.endTime = endTime; }

    public CourseType getCourseType() { return courseType; }
    public void setCourseType(CourseType courseType) { this.courseType = courseType; }

    public CourseStatus getStatus() { return status; }
    public void setStatus(CourseStatus status) { this.status = status; }

    public int getMaxParticipants() { return maxParticipants; }
    public void setMaxParticipants(int maxParticipants) { this.maxParticipants = maxParticipants; }

    public int getAvailableSpots() { return availableSpots; }
    public void setAvailableSpots(int availableSpots) { this.availableSpots = availableSpots; }

    public Trainer getTrainer() { return trainer; }
    public void setTrainer(Trainer trainer) { this.trainer = trainer; }

    public Set<Student> getStudents() { return students; }
    public void setStudents(Set<Student> students) { this.students = students; }

    public void addStudent(Student student) {
        if (students.size() < maxParticipants) {
            students.add(student);
            availableSpots = maxParticipants - students.size();
        } else {
            throw new IllegalStateException("Maximaal aantal cursisten bereikt");
        }
    }
}
