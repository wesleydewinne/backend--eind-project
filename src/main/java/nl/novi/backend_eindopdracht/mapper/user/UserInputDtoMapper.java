package nl.novi.backend_eindopdracht.mapper.user;

import nl.novi.backend_eindopdracht.dto.user.UserInputDto;
import org.springframework.stereotype.Component;
import nl.novi.backend_eindopdracht.model.user.Administrator;
import nl.novi.backend_eindopdracht.model.user.Student;
import nl.novi.backend_eindopdracht.model.user.Trainer;
import nl.novi.backend_eindopdracht.model.user.User;
import nl.novi.backend_eindopdracht.model.user.enums.RolType;

@Component
public class UserInputDtoMapper {

    public User toEntity(UserInputDto dto, RolType role) {
        if (dto == null) {
            throw new IllegalArgumentException("UserInputDto mag niet null zijn");
        }
        if (role == null) {
            throw new IllegalArgumentException("RolType mag niet null zijn");
        }

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

        user.setFirstname(dto.getFirstname());
        user.setLastname(dto.getLastname());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setRole(role);

        return user;
    }
}
