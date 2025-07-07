package nl.novi.backend_eindopdracht.mapper.user;

import org.springframework.stereotype.Component;
import nl.novi.backend_eindopdracht.dto.user.UserDto;
import nl.novi.backend_eindopdracht.model.user.User;

@Component
public class UserDtoMapper {

    public UserDto toDto(User user) {
        if (user == null) return null;

        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setFirstname(user.getFirstname());
        dto.setLastname(user.getLastname());
        dto.setEmail(user.getEmail());
        dto.setRole(user.getRole() != null ? user.getRole().name() : null);

        return dto;
    }
}

