package nl.novi.backend_eindopdracht.mapper.user;

import nl.novi.backend_eindopdracht.dto.user.AdministratorDto;
import nl.novi.backend_eindopdracht.dto.user.TrainerDto;
import nl.novi.backend_eindopdracht.dto.user.StudentDto;
import nl.novi.backend_eindopdracht.model.user.Administrator;
import nl.novi.backend_eindopdracht.model.user.Trainer;
import nl.novi.backend_eindopdracht.model.user.Student;

public class UserSubtypeMapper {

    public AdministratorDto toDto(Administrator admin) {
        if (admin == null) return null;
        AdministratorDto dto = new AdministratorDto();
        dto.setId(admin.getId());
        dto.setName(admin.getName());
        dto.setEmail(admin.getEmail());

        return dto;
    }

    public Administrator toEntity(AdministratorDto dto) {
        if (dto == null) return null;
        Administrator admin = new Administrator();
        admin.setName(dto.getName());
        admin.setEmail(dto.getEmail());

        return admin;
    }

    public TrainerDto toDto(Trainer trainer) {
        if (trainer == null) return null;
        TrainerDto dto = new TrainerDto();
        dto.setId(trainer.getId());
        dto.setName(trainer.getName());
        dto.setEmail(trainer.getEmail());

        return dto;
    }

    public Trainer toEntity(TrainerDto dto) {
        if (dto == null) return null;
        Trainer trainer = new Trainer();
        trainer.setName(dto.getName());
        trainer.setEmail(dto.getEmail());

        return trainer;
    }

    public StudentDto toDto(Student student) {
        if (student == null) return null;
        StudentDto dto = new StudentDto();
        dto.setId(student.getId());
        dto.setName(student.getName());
        dto.setEmail(student.getEmail());

        return dto;
    }

    public Student toEntity(StudentDto dto) {
        if (dto == null) return null;
        Student student = new Student();
        student.setName(dto.getName());
        student.setEmail(dto.getEmail());

        return student;
    }
}
