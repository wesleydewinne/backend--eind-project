package nl.novi.backend_eindopdracht.service.certificate;

import nl.novi.backend_eindopdracht.dto.certificate.CertificateDto;

public interface CertificateService {
    CertificateDto createCertificate(Long studentId, Long courseId);
}
