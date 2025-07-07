package nl.novi.backend_eindopdracht.repository.user;

import nl.novi.backend_eindopdracht.model.user.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministratorRepository extends JpaRepository<Administrator, Long> {
}
