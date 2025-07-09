package nl.novi.backend_eindopdracht.mapper.course;

import nl.novi.backend_eindopdracht.dto.course.CourseAdministratorDto;
import nl.novi.backend_eindopdracht.dto.course.CourseStudentDto;
import nl.novi.backend_eindopdracht.dto.course.CourseTrainerDto;
import nl.novi.backend_eindopdracht.model.course.Course;
import nl.novi.backend_eindopdracht.model.user.Student;
import nl.novi.backend_eindopdracht.model.user.Trainer;
import nl.novi.backend_eindopdracht.mapper.course.UserMapper;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CourseMapper {

    private final UserMapper userMapper;

    public CourseMapper(UserMapper userMapper) {
        this.userMapper = userMapper;  // Correcte toewijzing
    }

    public CourseAdministratorDto toAdministratorDto(Course course) {
        CourseAdministratorDto dto = new CourseAdministratorDto();
        dto.setId(course.getId());
        dto.setCourseCode(course.getCourseCode());
        dto.setTrainingDate(course.getTrainingDate());
//        dto.setGroupNumber(course.getGroupNumber());
        dto.setDescription(course.getDescription());
        dto.setStartTime(course.getStartTime());
        dto.setEndTime(course.getEndTime());
//        dto.setCourseType(course.getCourseType());
//        dto.setStatus(course.getStatus());
        dto.setMaxParticipants(course.getMaxParticipants());
        dto.setAvailableSpots(course.getAvailableSpots());
        dto.setTrainer(userMapper.toTrainerSummaryDto(course.getTrainer()));  // userMapper ipv userDtoMapper
//        dto.setStudentIds(course.getStudents().stream()
//                .map(userMapper::toStudentSummaryDto) // userMapper ipv userDtoMapper
//                .collect(Collectors.toList()));
        return dto;
    }

    public CourseTrainerDto toTrainerDto(Course course) {
        CourseTrainerDto dto = new CourseTrainerDto();
        dto.setId(course.getId());
        dto.setTrainingDate(course.getTrainingDate());
        dto.setGroupNumber(course.getGroupNumber());
        dto.setDescription(course.getDescription());
        dto.setStartTime(course.getStartTime());
        dto.setEndTime(course.getEndTime());
        dto.setCourseType(course.getCourseType());
        dto.setStatus(course.getStatus());
        dto.setMaxParticipants(course.getMaxParticipants());
        dto.setAvailableSpots(course.getAvailableSpots());
        dto.setStudents(course.getStudents().stream()
                .map(userMapper::toStudentSummaryDto) // userMapper ipv userDtoMapper
                .collect(Collectors.toList()));
        return dto;
    }

    public CourseStudentDto toStudentDto(Course course) {
        CourseStudentDto dto = new CourseStudentDto();
        dto.setId(course.getId());
        dto.setTrainingDate(course.getTrainingDate());
        dto.setStartTime(course.getStartTime());
        dto.setEndTime(course.getEndTime());
        dto.setCourseType(course.getCourseType());
        // Bijv. locatie-naam uit ander veld als je die later toevoegt
        dto.setLocation("N.t.b."); // Placeholder
        return dto;
    }

    public Course toEntity(CourseAdministratorDto dto, Trainer trainer, List<Student> students) {
        Course course = new Course();
        course.setTrainingDate(dto.getTrainingDate());
//        course.setGroupNumber(dto.getGroupNumber());
        course.setDescription(dto.getDescription());
        course.setStartTime(dto.getStartTime());
        course.setEndTime(dto.getEndTime());
//        course.setCourseType(dto.getCourseType());
//        course.setStatus(dto.getStatus());
        course.setMaxParticipants(dto.getMaxParticipants());
        course.setAvailableSpots(dto.getAvailableSpots());
        course.setTrainer(trainer);
        course.setStudents(students.stream().collect(Collectors.toSet()));
        return course;
    }
}
