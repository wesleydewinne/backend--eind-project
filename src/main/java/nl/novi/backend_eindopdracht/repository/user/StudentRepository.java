package nl.novi.backend_eindopdracht.repository.user;

import nl.novi.backend_eindopdracht.model.user.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}

