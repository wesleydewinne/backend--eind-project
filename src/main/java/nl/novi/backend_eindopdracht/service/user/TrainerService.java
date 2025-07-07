package nl.novi.backend_eindopdracht.service.user;

import nl.novi.backend_eindopdracht.exception.user.TrainerNotFoundException;
import nl.novi.backend_eindopdracht.model.user.Trainer;
import nl.novi.backend_eindopdracht.repository.user.TrainerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainerService {

    private final TrainerRepository trainerRepository;

    public TrainerService(TrainerRepository trainerRepository) {
        this.trainerRepository = trainerRepository;
    }

    public List<Trainer> getAllTrainers() {
        return trainerRepository.findAll();
    }

    public Trainer getTrainerById(Long id) {
        return trainerRepository.findById(id)
                .orElseThrow(() -> new TrainerNotFoundException(id));
    }

    public Trainer saveTrainer(Trainer trainer) {
        return trainerRepository.save(trainer);
    }

    public Trainer updateTrainer(Long id, Trainer trainerDetails) {
        return trainerRepository.findById(id)
                .map(trainer -> {
                    trainer.setFirstname(trainerDetails.getFirstname());
                    trainer.setLastname(trainerDetails.getLastname());
                    trainer.setEmail(trainerDetails.getEmail());

                    return trainerRepository.save(trainer);
                })
                .orElseThrow(() -> new TrainerNotFoundException("Trainer met ID " + id + " niet gevonden"));
    }

    public void deleteTrainer(Long id) {
        if (!trainerRepository.existsById(id)) {
            throw new TrainerNotFoundException("Kan trainer met ID " + id + " niet verwijderen: niet gevonden.");
        }
        trainerRepository.deleteById(id);
    }
}
