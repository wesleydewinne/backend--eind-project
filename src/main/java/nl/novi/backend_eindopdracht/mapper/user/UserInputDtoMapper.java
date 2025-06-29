package nl.novi.backend_eindopdracht.mapper.user;

import nl.novi.backend_eindopdracht.dto.user.UserInputDto;
import nl.novi.backend_eindopdracht.model.user.enums.RolType;
import nl.novi.backend_eindopdracht.model.user.Administrator;
import nl.novi.backend_eindopdracht.model.user.Student;
import nl.novi.backend_eindopdracht.model.user.Trainer;
import nl.novi.backend_eindopdracht.model.user.User;

public class UserInputDtoMapper {

    public User toEntity(UserInputDto dto, RolType role) {
        if (dto == null || role == null) return null;

        User user;
        switch (role) {
            case ADMINISTRATOR:
                user = new Administrator();
                break;
            case TRAINER:
                user = new Trainer();
                break;
            case STUDENT:
                user = new Student();
                break;
            default:
                throw new IllegalArgumentException("Ongeldige rol: " + role);
        }

        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setRole(role);

        return user;
    }
}
