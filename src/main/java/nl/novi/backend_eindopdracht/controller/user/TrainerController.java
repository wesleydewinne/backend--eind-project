package nl.novi.backend_eindopdracht.controller.user;

import nl.novi.backend_eindopdracht.model.user.Trainer;
import nl.novi.backend_eindopdracht.service.user.TrainerService;
import nl.novi.backend_eindopdracht.exception.user.TrainerNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/trainers")
public class TrainerController {

    private final TrainerService trainerService;

    public TrainerController(TrainerService trainerService) {
        this.trainerService = trainerService;
    }

    @GetMapping
    public ResponseEntity<List<Trainer>> getAllTrainers() {
        return ResponseEntity.ok(trainerService.getAllTrainers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Trainer> getTrainerById(@PathVariable Long id) {
        try {
            Trainer trainer = trainerService.getTrainerById(id);
            return ResponseEntity.ok(trainer);
        } catch (TrainerNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Trainer> createTrainer(@RequestBody Trainer trainer) {
        Trainer saved = trainerService.saveTrainer(trainer);
        return ResponseEntity.ok(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Trainer> updateTrainer(@PathVariable Long id, @RequestBody Trainer trainer) {
        try {
            Trainer updatedTrainer = trainerService.updateTrainer(id, trainer);
            return ResponseEntity.ok(updatedTrainer);
        } catch (TrainerNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteTrainer(@PathVariable Long id) {
        try {
            trainerService.deleteTrainer(id);
            Map<String, String> response = Map.of("message", "Trainer met id " + id + " is verwijderd.");
            return ResponseEntity.ok(response);
        } catch (TrainerNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
