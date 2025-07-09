package nl.novi.backend_eindopdracht.service.course;

import nl.novi.backend_eindopdracht.dto.course.CourseAdministratorDto;
import nl.novi.backend_eindopdracht.dto.course.CourseStudentDto;
import nl.novi.backend_eindopdracht.dto.course.CourseTrainerDto;
import nl.novi.backend_eindopdracht.mapper.course.CourseMapper;
import nl.novi.backend_eindopdracht.model.course.Course;
import nl.novi.backend_eindopdracht.model.user.Student;
import nl.novi.backend_eindopdracht.model.user.Trainer;
import nl.novi.backend_eindopdracht.repository.course.CourseRepository;
import nl.novi.backend_eindopdracht.repository.user.StudentRepository;
import nl.novi.backend_eindopdracht.repository.user.TrainerRepository;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final TrainerRepository trainerRepository;
    private final StudentRepository studentRepository;
    private final CourseMapper courseMapper;

    public CourseServiceImpl(CourseRepository courseRepository,
                             TrainerRepository trainerRepository,
                             StudentRepository studentRepository,
                             CourseMapper courseMapper) {
        this.courseRepository = courseRepository;
        this.trainerRepository = trainerRepository;
        this.studentRepository = studentRepository;
        this.courseMapper = courseMapper;
    }

    // === STUDENT ===
    @Override
    public List<CourseStudentDto> getAllCoursesForStudent(Long studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new NoSuchElementException("Student niet gevonden"));

        return courseRepository.findByStudentsContaining(student)
                .stream()
                .map(courseMapper::toStudentDto)
                .collect(Collectors.toList());
    }

    @Override
    public CourseStudentDto getCourseForStudent(Long courseId, Long studentId) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new NoSuchElementException("Cursus niet gevonden"));

        boolean isEnrolled = course.getStudents().stream()
                .anyMatch(student -> student.getId().equals(studentId));

        if (!isEnrolled) {
            throw new SecurityException("Student is niet ingeschreven voor deze cursus.");
        }

        return courseMapper.toStudentDto(course);
    }

    // === TRAINER ===
    @Override
    public List<CourseTrainerDto> getAllCoursesForTrainer(Long trainerId) {
        Trainer trainer = trainerRepository.findById(trainerId)
                .orElseThrow(() -> new NoSuchElementException("Trainer niet gevonden"));

        return courseRepository.findByTrainer(trainer)
                .stream()
                .map(courseMapper::toTrainerDto)
                .collect(Collectors.toList());
    }

    @Override
    public CourseTrainerDto getCourseForTrainer(Long courseId, Long trainerId) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new NoSuchElementException("Cursus niet gevonden"));

        if (!course.getTrainer().getId().equals(trainerId)) {
            throw new SecurityException("Trainer is niet gekoppeld aan deze cursus.");
        }

        return courseMapper.toTrainerDto(course);
    }

    @Override
    public void markStudentAsCompetent(Long courseId, Long studentId) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new NoSuchElementException("Cursus niet gevonden"));

        Optional<Student> studentOpt = course.getStudents().stream()
                .filter(s -> s.getId().equals(studentId))
                .findFirst();

        if (studentOpt.isEmpty()) {
            throw new NoSuchElementException("Student niet gevonden in deze cursus.");
        }

        Student student = studentOpt.get();
        student.setCompetentDeclared(true); // Zorg dat dit veld bestaat in je Student-model
        studentRepository.save(student);
    }

    // === ADMINISTRATOR ===
    @Override
    public List<CourseAdministratorDto> getAllCoursesForAdministrator() {
        return courseRepository.findAll()
                .stream()
                .map(courseMapper::toAdministratorDto)
                .collect(Collectors.toList());
    }

    @Override
    public CourseAdministratorDto getCourseForAdministrator(Long courseId) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new NoSuchElementException("Cursus niet gevonden"));
        return courseMapper.toAdministratorDto(course);
    }

    @Override
    public CourseAdministratorDto createCourse(CourseAdministratorDto dto) {
        Trainer trainer = trainerRepository.findById(dto.getTrainer().getId())
                .orElseThrow(() -> new NoSuchElementException("Trainer niet gevonden"));

        Set<Student> students = new HashSet<>();
        if (dto.getStudentIds() != null && !dto.getStudentIds().isEmpty()) {
            students = new HashSet<>(studentRepository.findAllById(dto.getStudentIds()));
        }

        Course course = courseMapper.toEntity(dto, trainer, new ArrayList<>(students));
        course = courseRepository.save(course);
        return courseMapper.toAdministratorDto(course);
    }

    @Override
    public CourseAdministratorDto updateSchedule(Long courseId, CourseAdministratorDto dto) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new NoSuchElementException("Cursus niet gevonden"));

        course.setTrainingDate(dto.getTrainingDate());
        course.setStartTime(dto.getStartTime());
        course.setEndTime(dto.getEndTime());

        course = courseRepository.save(course);
        return courseMapper.toAdministratorDto(course);
    }

    @Override
    public void deleteCourse(Long courseId) {
        courseRepository.deleteById(courseId);
    }
}
