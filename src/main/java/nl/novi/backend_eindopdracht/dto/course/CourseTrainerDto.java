package nl.novi.backend_eindopdracht.dto.course;

import nl.novi.backend_eindopdracht.dto.user.StudentSummaryDto;
import nl.novi.backend_eindopdracht.model.course.enums.CourseStatus;
import nl.novi.backend_eindopdracht.model.course.enums.CourseType;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class CourseTrainerDto {

    private Long id;
    private LocalDate trainingDate;
    private String groupNumber;
    private String description;
    private LocalTime startTime;
    private LocalTime endTime;
    private CourseType courseType;
    private CourseStatus status;
    private int maxParticipants;
    private int availableSpots;
    private List<StudentSummaryDto> students;

    // Getters en setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

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

    public List<StudentSummaryDto> getStudents() { return students; }
    public void setStudents(List<StudentSummaryDto> students) { this.students = students; }
}
