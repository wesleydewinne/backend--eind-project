package nl.novi.backend_eindopdracht.controller.location;

import nl.novi.backend_eindopdracht.dto.location.LocationDto;
import nl.novi.backend_eindopdracht.service.LocationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/locations")
public class LocationController {

    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping
    public List<LocationDto> getAllLocations() {
        return locationService.getAllLocations();
    }

    @GetMapping("/{id}")
    public LocationDto getLocationById(@PathVariable Long id) {
        return locationService.getLocationById(id)
                .orElseThrow(() -> new RuntimeException("Location not found"));
    }

    @PostMapping
    public LocationDto createLocation(@RequestBody LocationDto dto) {
        return locationService.createLocation(dto);
    }

    @PutMapping("/{id}")
    public LocationDto updateLocation(@PathVariable Long id, @RequestBody LocationDto dto) {
        return locationService.updateLocation(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deleteLocation(@PathVariable Long id) {
        locationService.deleteLocation(id);
    }
}
