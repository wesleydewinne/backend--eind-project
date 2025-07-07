package nl.novi.backend_eindopdracht.controller.user;

import nl.novi.backend_eindopdracht.exception.user.AdministratorNotFoundException;
import nl.novi.backend_eindopdracht.model.user.Administrator;
import nl.novi.backend_eindopdracht.service.user.AdministratorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/administrators")
public class AdministratorController {

    private final AdministratorService administratorService;

    public AdministratorController(AdministratorService administratorService) {
        this.administratorService = administratorService;
    }

    @GetMapping
    public ResponseEntity<List<Administrator>> getAllAdministrators() {
        List<Administrator> admins = administratorService.getAllAdministrators();
        return ResponseEntity.ok(admins);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Administrator> getAdministratorById(@PathVariable Long id) {
        Administrator admin = administratorService.getAdministratorById(id);
        return ResponseEntity.ok(admin);
    }

    @PostMapping
    public ResponseEntity<Administrator> createAdministrator(@RequestBody Administrator administrator) {
        Administrator saved = administratorService.saveAdministrator(administrator);
        return ResponseEntity.ok(saved);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Administrator> updateAdministrator(@PathVariable Long id, @RequestBody Administrator administrator) {
        try {
            Administrator updatedAdministrator = administratorService.updateAdministrator(id, administrator);
            return ResponseEntity.ok(updatedAdministrator);
        } catch (AdministratorNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteAdministrator(@PathVariable Long id) {
        try {
            administratorService.deleteAdministrator(id);
            Map<String, String> response = Map.of("message", "Administrator met id " + id + " is verwijderd.");
            return ResponseEntity.ok(response);
        } catch (AdministratorNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
