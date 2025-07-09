package nl.novi.backend_eindopdracht.mapper.course;

import nl.novi.backend_eindopdracht.dto.user.StudentSummaryDto;
import nl.novi.backend_eindopdracht.dto.user.TrainerSummaryDto;
import nl.novi.backend_eindopdracht.model.user.Student;
import nl.novi.backend_eindopdracht.model.user.Trainer;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public StudentSummaryDto toStudentSummaryDto(Student student) {
        if (student == null) return null;

        StudentSummaryDto dto = new StudentSummaryDto();
        dto.setId(student.getId());
        dto.setFirstname(student.getFirstname());
        dto.setLastname(student.getLastname());
        dto.setEmail(student.getEmail());                // belangrijk: email meegeven
//        dto.setPresentMorning(student.isPresentMorning());
        dto.setCompetentDeclared(student.isCompetentDeclared());
//        dto.setCertificateUrl(student.getCertificateUrl());

        return dto;
    }

    public TrainerSummaryDto toTrainerSummaryDto(Trainer trainer) {
        if (trainer == null) return null;

        TrainerSummaryDto dto = new TrainerSummaryDto();
        dto.setId(trainer.getId());
        dto.setFirstname(trainer.getFirstname());
        dto.setLastname(trainer.getLastname());
        dto.setEmail(trainer.getEmail());

        return dto;
    }
}
