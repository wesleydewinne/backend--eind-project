package nl.novi.backend_eindopdracht.service.certificate;

import nl.novi.backend_eindopdracht.dto.certificate.CertificateDto;
//import nl.novi.backend_eindopdracht.helper.PdfGenerator;
import nl.novi.backend_eindopdracht.mapper.certificaat.*;
import nl.novi.backend_eindopdracht.model.certificate.*;
import nl.novi.backend_eindopdracht.model.course.Course;
import nl.novi.backend_eindopdracht.model.user.Student;
import nl.novi.backend_eindopdracht.repository.CertificateRepository;
import nl.novi.backend_eindopdracht.repository.course.CourseRepository;
import nl.novi.backend_eindopdracht.repository.user.StudentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class CertificateServiceImpl implements CertificateService {

    private final CertificateRepository certificateRepository;
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public CertificateServiceImpl(CertificateRepository certificateRepository,
                                  StudentRepository studentRepository,
                                  CourseRepository courseRepository) {
        this.certificateRepository = certificateRepository;
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public CertificateDto createCertificate(Long studentId, Long courseId) {
        Student student = studentRepository.findById(studentId).orElseThrow();
        Course course = courseRepository.findById(courseId).orElseThrow();

        // Validatie: competent + factuur betaald gebeurt extern

        Certificate certificate = new Certificate();
        certificate.setStudent(student);
        certificate.setCourse(course);
        certificate.setIssueDate(LocalDate.now());

        certificate = certificateRepository.save(certificate);

//        String pdfPath = PdfGenerator.generateCertificatePdf(certificate);
//        certificate.setCertificateUrl(pdfPath);

        certificateRepository.save(certificate);
        return CertificateMapper.toDto(certificate);
    }
}
