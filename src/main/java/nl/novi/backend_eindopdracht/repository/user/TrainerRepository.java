package nl.novi.backend_eindopdracht.repository.user;

import nl.novi.backend_eindopdracht.model.user.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainerRepository extends JpaRepository<Trainer, Long> {
}