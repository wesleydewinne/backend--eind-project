package nl.novi.backend_eindopdracht.repository.location;

import nl.novi.backend_eindopdracht.model.location.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {}
