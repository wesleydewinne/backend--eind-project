package nl.novi.backend_eindopdracht.service.user;

import nl.novi.backend_eindopdracht.exception.user.StudentNotFoundException;
import nl.novi.backend_eindopdracht.model.user.Student;
import nl.novi.backend_eindopdracht.repository.user.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException(id));
    }

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student updateStudent(Long id, Student studentDetails) {
        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student not found with id " + id));

        existingStudent.setFirstname(studentDetails.getFirstname());
        existingStudent.setLastname(studentDetails.getLastname());
        existingStudent.setEmail(studentDetails.getEmail());

        return studentRepository.save(existingStudent);
    }

    public void deleteStudent(Long id) {
        if (!studentRepository.existsById(id)) {
            throw new StudentNotFoundException("Kan student met ID " + id + " niet verwijderen: niet gevonden.");
        }
        studentRepository.deleteById(id);
    }
}
