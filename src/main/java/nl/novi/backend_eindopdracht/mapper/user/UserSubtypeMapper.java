package nl.novi.backend_eindopdracht.mapper.user;

import nl.novi.backend_eindopdracht.dto.user.AdministratorDto;
import nl.novi.backend_eindopdracht.dto.user.StudentDto;
import nl.novi.backend_eindopdracht.dto.user.TrainerDto;
import nl.novi.backend_eindopdracht.model.user.Administrator;
import nl.novi.backend_eindopdracht.model.user.Student;
import nl.novi.backend_eindopdracht.model.user.Trainer;
import org.springframework.stereotype.Component;

@Component
public class UserSubtypeMapper {

    public AdministratorDto toDto(Administrator admin) {
        if (admin == null) return null;

        AdministratorDto dto = new AdministratorDto();
        dto.setId(admin.getId());
        dto.setFirstname(admin.getFirstname());
        dto.setLastname(admin.getLastname());
        dto.setEmail(admin.getEmail());
        return dto;
    }

    public Administrator toEntity(AdministratorDto dto) {
        if (dto == null) return null;

        Administrator admin = new Administrator();
        admin.setFirstname(dto.getFirstname());
        admin.setLastname(dto.getLastname());
        admin.setEmail(dto.getEmail());
        return admin;
    }

    public TrainerDto toDto(Trainer trainer) {
        if (trainer == null) return null;

        TrainerDto dto = new TrainerDto();
        dto.setId(trainer.getId());
        dto.setFirstname(trainer.getFirstname());
        dto.setLastname(trainer.getLastname());
        dto.setEmail(trainer.getEmail());
        return dto;
    }

    public Trainer toEntity(TrainerDto dto) {
        if (dto == null) return null;

        Trainer trainer = new Trainer();
        trainer.setFirstname(dto.getFirstname());
        trainer.setLastname(dto.getLastname());
        trainer.setEmail(dto.getEmail());
        return trainer;
    }

    public StudentDto toDto(Student student) {
        if (student == null) return null;

        StudentDto dto = new StudentDto();
        dto.setId(student.getId());
        dto.setFirstname(student.getFirstname());
        dto.setLastname(student.getLastname());
        dto.setEmail(student.getEmail());
        return dto;
    }

    public Student toEntity(StudentDto dto) {
        if (dto == null) return null;

        Student student = new Student();
        student.setFirstname(dto.getFirstname());
        student.setLastname(dto.getLastname());
        student.setEmail(dto.getEmail());
        return student;
    }
}
