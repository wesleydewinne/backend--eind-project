package nl.novi.backend_eindopdracht.dto.course;

import nl.novi.backend_eindopdracht.model.course.enums.CourseStatus;
import nl.novi.backend_eindopdracht.model.course.enums.CourseType;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

public class CourseDto {

    private Long id;
    private String courseCode;
    private LocalDate trainingDate;
    private String groupNumber;
    private String description;
    private LocalTime startTime;
    private LocalTime endTime;
    private CourseType courseType;
    private CourseStatus status;
    private int maxParticipants;
    private int availableSpots;
    private Long trainerId;
    private Set<Long> studentIds;

    // Getters en setters
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

    public Long getTrainerId() { return trainerId; }
    public void setTrainerId(Long trainerId) { this.trainerId = trainerId; }

    public Set<Long> getStudentIds() { return studentIds; }
    public void setStudentIds(Set<Long> studentIds) { this.studentIds = studentIds; }
}
