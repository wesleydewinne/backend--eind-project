package nl.novi.backend_eindopdracht.repository;

import nl.novi.backend_eindopdracht.model.certificate.Certificate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CertificateRepository extends JpaRepository<Certificate, Long> {
}
