package nl.novi.backend_eindopdracht.mapper.location;

import nl.novi.backend_eindopdracht.dto.location.LocationDto;
import nl.novi.backend_eindopdracht.model.location.Location;

public class LocationMapper {

    public static LocationDto toDto(Location location) {
        if (location == null) return null;

        LocationDto dto = new LocationDto();
        dto.setId(location.getId());
        dto.setStreet(location.getStreet());
        dto.setPostalCode(location.getPostalCode());
        dto.setCity(location.getCity());
        dto.setBuilding(location.getBuilding());
        dto.setExtraInfo(location.getExtraInfo());
        dto.setPhoneNumber(location.getPhoneNumber());
        dto.setFireDrillPossible(location.isFireDrillPossible());
        dto.setFireDrillLocation(location.getFireDrillLocation());
        return dto;
    }

    public static Location toEntity(LocationDto dto) {
        if (dto == null) return null;

        Location location = new Location();
        location.setId(dto.getId());
        location.setStreet(dto.getStreet());
        location.setPostalCode(dto.getPostalCode());
        location.setCity(dto.getCity());
        location.setBuilding(dto.getBuilding());
        location.setExtraInfo(dto.getExtraInfo());
        location.setPhoneNumber(dto.getPhoneNumber());
        location.setFireDrillPossible(dto.isFireDrillPossible());
        location.setFireDrillLocation(dto.getFireDrillLocation());
        return location;
    }
}
