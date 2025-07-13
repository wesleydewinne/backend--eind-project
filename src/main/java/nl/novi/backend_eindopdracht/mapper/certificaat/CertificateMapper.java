package nl.novi.backend_eindopdracht.mapper.certificaat;

import nl.novi.backend_eindopdracht.dto.certificate.CertificateDto;
import nl.novi.backend_eindopdracht.model.certificate.Certificate;

public class CertificateMapper {

    public static CertificateDto toDto(Certificate certificate) {
        CertificateDto dto = new CertificateDto();
        dto.setId(certificate.getId());
        dto.setIssueDate(certificate.getIssueDate());
        dto.setCertificateUrl(certificate.getCertificateUrl());
        dto.setStudentId(certificate.getStudent().getId());
        dto.setCourseId(certificate.getCourse().getId());
        return dto;
    }
}
