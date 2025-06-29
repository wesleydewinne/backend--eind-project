package nl.novi.backend_eindopdracht.mapper.user;

import nl.novi.backend_eindopdracht.dto.user.UserDto;
import nl.novi.backend_eindopdracht.model.user.User;

public class UserDtoMapper {

    public UserDto toDto(User user) {
        if (user == null) return null;
        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setRole(user.getRole().name());

        return dto;
    }
}
