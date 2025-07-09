package nl.novi.backend_eindopdracht.controller.course;

import nl.novi.backend_eindopdracht.dto.course.CourseAdministratorDto;
import nl.novi.backend_eindopdracht.dto.course.CourseStudentDto;
import nl.novi.backend_eindopdracht.dto.course.CourseTrainerDto;
import nl.novi.backend_eindopdracht.service.course.CourseService;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    // Voor studenten: alleen eigen courses, voor trainers: eigen courses, admins: alle courses
    @GetMapping
    @PreAuthorize("hasAnyRole('STUDENT', 'TRAINER', 'ADMINISTRATOR')")
    public ResponseEntity<List<?>> getAllCourses(Authentication authentication) {
        if (authentication.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_STUDENT"))) {
            Long studentId = getUserIdFromAuthentication(authentication);
            return ResponseEntity.ok(courseService.getAllCoursesForStudent(studentId));
        }
        if (authentication.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_TRAINER"))) {
            Long trainerId = getUserIdFromAuthentication(authentication);
            return ResponseEntity.ok(courseService.getAllCoursesForTrainer(trainerId));
        }
        // Administrator
        return ResponseEntity.ok(courseService.getAllCoursesForAdministrator());
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('STUDENT', 'TRAINER', 'ADMINISTRATOR')")
    public ResponseEntity<?> getCourseById(@PathVariable Long id, Authentication authentication) {
        if (authentication.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_STUDENT"))) {
            Long studentId = getUserIdFromAuthentication(authentication);
            CourseStudentDto studentDto = courseService.getCourseForStudent(id, studentId);
            return ResponseEntity.ok(studentDto);
        }
        if (authentication.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_TRAINER"))) {
            Long trainerId = getUserIdFromAuthentication(authentication);
            CourseTrainerDto trainerDto = courseService.getCourseForTrainer(id, trainerId);
            return ResponseEntity.ok(trainerDto);
        }
        // Administrator
        CourseAdministratorDto administratorDto = courseService.getCourseForAdministrator(id);
        return ResponseEntity.ok(administratorDto);
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMINISTRATOR')")
    public ResponseEntity<CourseAdministratorDto> createCourse(@RequestBody CourseAdministratorDto dto) {
        return ResponseEntity.ok(courseService.createCourse(dto));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMINISTRATOR')")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
        return ResponseEntity.noContent().build();
    }

    // Alleen admin mag datum en tijden aanpassen
    @PutMapping("/{id}/schedule")
    @PreAuthorize("hasRole('ADMINISTRATOR')")
    public ResponseEntity<CourseAdministratorDto> updateDateAndTime(@PathVariable Long id, @RequestBody CourseAdministratorDto dto) {
        return ResponseEntity.ok(courseService.updateSchedule(id, dto));
    }

    // Trainer kan competenties markeren
    @PostMapping("/{courseId}/students/{studentId}/competent")
    @PreAuthorize("hasRole('TRAINER')")
    public ResponseEntity<Void> markStudentCompetent(@PathVariable Long courseId, @PathVariable Long studentId) {
        courseService.markStudentAsCompetent(courseId, studentId);
        return ResponseEntity.ok().build();
    }

    // Hulpmethode om userId uit Authentication object te halen
    private Long getUserIdFromAuthentication(Authentication authentication) {
        Object principal = authentication.getPrincipal();
        if (principal instanceof org.springframework.security.core.userdetails.UserDetails) {
            // Je moet dit aanpassen aan jouw CustomUserDetails waarin je userId hebt
            // Bijvoorbeeld:
            // return ((CustomUserDetails) principal).getId();

            // Voor nu dummy 0L (vervang dit)
            return 0L;
        }
        return null;
    }
}
