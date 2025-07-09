package nl.novi.backend_eindopdracht.dto.course;

import nl.novi.backend_eindopdracht.model.course.enums.CourseType;

import java.time.LocalDate;
import java.time.LocalTime;

public class CourseStudentDto {

    private Long id;
    private LocalDate trainingDate;
    private LocalTime startTime;
    private LocalTime endTime;
    private String location; // optioneel, bijv. locatie-naam
    private CourseType courseType;

    // Getters en setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDate getTrainingDate() { return trainingDate; }
    public void setTrainingDate(LocalDate trainingDate) { this.trainingDate = trainingDate; }

    public LocalTime getStartTime() { return startTime; }
    public void setStartTime(LocalTime startTime) { this.startTime = startTime; }

    public LocalTime getEndTime() { return endTime; }
    public void setEndTime(LocalTime endTime) { this.endTime = endTime; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public CourseType getCourseType() { return courseType; }
    public void setCourseType(CourseType courseType) { this.courseType = courseType; }
}
