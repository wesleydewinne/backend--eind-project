package nl.novi.backend_eindopdracht.controller.certificate;

import nl.novi.backend_eindopdracht.dto.certificate.CertificateDto;
import nl.novi.backend_eindopdracht.service.certificate.CertificateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/certificates")
public class CertificateController {

    private final CertificateService certificateService;

    public CertificateController(CertificateService certificateService) {
        this.certificateService = certificateService;
    }

    @PostMapping("/api/{studentId}/{courseId}")
    public ResponseEntity<CertificateDto> generateCertificate(@PathVariable Long studentId,
                                                              @PathVariable Long courseId) {
        CertificateDto dto = certificateService.createCertificate(studentId, courseId);
        return ResponseEntity.ok(dto);
    }
}
