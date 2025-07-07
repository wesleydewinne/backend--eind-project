package nl.novi.backend_eindopdracht.service;

import nl.novi.backend_eindopdracht.dto.location.LocationDto;
import nl.novi.backend_eindopdracht.mapper.location.LocationMapper;
import nl.novi.backend_eindopdracht.model.location.Location;
import nl.novi.backend_eindopdracht.repository.location.LocationRepository;
import nl.novi.backend_eindopdracht.util.location.LocationHelper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LocationService {

    private final LocationRepository locationRepository;

    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public List<LocationDto> getAllLocations() {
        return locationRepository.findAll()
                .stream()
                .map(LocationMapper::toDto)
                .collect(Collectors.toList());
    }

    public Optional<LocationDto> getLocationById(Long id) {
        return locationRepository.findById(id)
                .map(LocationMapper::toDto);
    }

    public LocationDto createLocation(LocationDto dto) {
        validateAndFormat(dto);
        Location location = LocationMapper.toEntity(dto);
        location = locationRepository.save(location);
        return LocationMapper.toDto(location);
    }

    public LocationDto updateLocation(Long id, LocationDto dto) {
        Optional<Location> optional = locationRepository.findById(id);
        if (optional.isEmpty()) {
            throw new RuntimeException("Locatie niet gevonden met id: " + id);
        }

        validateAndFormat(dto);

        Location location = optional.get();
        location.setStreet(dto.getStreet());
        location.setPostalCode(dto.getPostalCode());
        location.setCity(dto.getCity());
        location.setBuilding(dto.getBuilding());
        location.setExtraInfo(dto.getExtraInfo());

        location = locationRepository.save(location);
        return LocationMapper.toDto(location);
    }

    public void deleteLocation(Long id) {
        locationRepository.deleteById(id);
    }

    /**
     * ✅ Verplaats de validatie/normalisatie naar een aparte methode
     */
    private void validateAndFormat(LocationDto dto) {
        if (!LocationHelper.isValidPostalCode(dto.getPostalCode())) {
            throw new IllegalArgumentException("Ongeldige postcode: " + dto.getPostalCode());
        }

        // Format postcode (zoals 1234AB → 1234 AB)
        dto.setPostalCode(LocationHelper.formatPostalCode(dto.getPostalCode()));

        // Vul stad automatisch in als deze niet is meegegeven
        if (dto.getCity() == null || dto.getCity().isBlank()) {
            dto.setCity(LocationHelper.lookupCityByPostalCode(dto.getPostalCode()));
        }
    }
}
