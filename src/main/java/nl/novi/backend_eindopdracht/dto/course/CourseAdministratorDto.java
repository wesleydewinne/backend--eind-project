package nl.novi.backend_eindopdracht.dto.course;

import nl.novi.backend_eindopdracht.dto.user.StudentSummaryDto;
import nl.novi.backend_eindopdracht.dto.user.TrainerSummaryDto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class CourseAdministratorDto {
    private Long id;
    private String courseCode;
    private LocalDate trainingDate;
    private int groupNumber;
    private String description;
    private LocalTime startTime;
    private LocalTime endTime;
    private String courseType;
    private String status;
    private int maxParticipants;
    private int availableSpots;
    private TrainerSummaryDto trainer;           // Juiste type
    private List<Long> studentIds;   // Juiste type

    public CourseAdministratorDto() {}

    // Getters en setters voor alle velden

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCourseCode() { return courseCode; }
    public void setCourseCode(String courseCode) { this.courseCode = courseCode; }

    public LocalDate getTrainingDate() { return trainingDate; }
    public void setTrainingDate(LocalDate trainingDate) { this.trainingDate = trainingDate; }

    public int getGroupNumber() { return groupNumber; }
    public void setGroupNumber(int groupNumber) { this.groupNumber = groupNumber; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public LocalTime getStartTime() { return startTime; }
    public void setStartTime(LocalTime startTime) { this.startTime = startTime; }

    public LocalTime getEndTime() { return endTime; }
    public void setEndTime(LocalTime endTime) { this.endTime = endTime; }

    public String getCourseType() { return courseType; }
    public void setCourseType(String courseType) { this.courseType = courseType; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public int getMaxParticipants() { return maxParticipants; }
    public void setMaxParticipants(int maxParticipants) { this.maxParticipants = maxParticipants; }

    public int getAvailableSpots() { return availableSpots; }
    public void setAvailableSpots(int availableSpots) { this.availableSpots = availableSpots; }

    public TrainerSummaryDto getTrainer() { return trainer; }
    public void setTrainer(TrainerSummaryDto trainer) { this.trainer = trainer; }

    public List<Long> getStudentIds() { return studentIds; }
    public void setStudentIds(List<Long> studentIds) { this.studentIds = studentIds; }
}
