package nl.novi.backend_eindopdracht.repository.course;

import nl.novi.backend_eindopdracht.model.course.Course;
import nl.novi.backend_eindopdracht.model.user.Student;
import nl.novi.backend_eindopdracht.model.user.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {

    // Vind alle cursussen waarin deze student zit
    List<Course> findByStudentsContaining(Student student);

    // Vind alle cursussen van een specifieke trainer
    List<Course> findByTrainer(Trainer trainer);
}