package nl.novi.backend_eindopdracht.service.course;

import nl.novi.backend_eindopdracht.dto.course.CourseAdministratorDto;
import nl.novi.backend_eindopdracht.dto.course.CourseStudentDto;
import nl.novi.backend_eindopdracht.dto.course.CourseTrainerDto;

import java.util.List;

public interface CourseService {

    // Voor studenten
    List<CourseStudentDto> getAllCoursesForStudent(Long studentId);
    CourseStudentDto getCourseForStudent(Long courseId, Long studentId);

    // Voor trainers
    List<CourseTrainerDto> getAllCoursesForTrainer(Long trainerId);
    CourseTrainerDto getCourseForTrainer(Long courseId, Long trainerId);
    void markStudentAsCompetent(Long courseId, Long studentId);

    // Voor administrator
    List<CourseAdministratorDto> getAllCoursesForAdministrator();
    CourseAdministratorDto getCourseForAdministrator(Long courseId);
    CourseAdministratorDto createCourse(CourseAdministratorDto dto);
    CourseAdministratorDto updateSchedule(Long courseId, CourseAdministratorDto dto);
    void deleteCourse(Long courseId);
}
