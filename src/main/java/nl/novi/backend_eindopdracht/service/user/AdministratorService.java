package nl.novi.backend_eindopdracht.service.user;

import nl.novi.backend_eindopdracht.exception.user.AdministratorNotFoundException;
import nl.novi.backend_eindopdracht.model.user.Administrator;
import nl.novi.backend_eindopdracht.repository.user.AdministratorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministratorService {

    private final AdministratorRepository administratorRepository;

    public AdministratorService(AdministratorRepository administratorRepository) {
        this.administratorRepository = administratorRepository;
    }

    public List<Administrator> getAllAdministrators() {
        return administratorRepository.findAll();
    }

    public Administrator getAdministratorById(Long id) {
        return administratorRepository.findById(id)
                .orElseThrow(() -> new AdministratorNotFoundException(id));
    }

    public Administrator saveAdministrator(Administrator administrator) {
        return administratorRepository.save(administrator);
    }

    public Administrator updateAdministrator(Long id, Administrator administratorDetails) {
        return administratorRepository.findById(id)
                .map(admin -> {
                    admin.setFirstname(administratorDetails.getFirstname());
                    admin.setLastname(administratorDetails.getLastname());
                    admin.setEmail(administratorDetails.getEmail());

                    return administratorRepository.save(admin);
                })
                .orElseThrow(() -> new AdministratorNotFoundException("Administrator met ID " + id + " niet gevonden"));
    }

    public void deleteAdministrator(Long id) {
        if (!administratorRepository.existsById(id)) {
            throw new AdministratorNotFoundException("Kan administrator met ID " + id + " niet verwijderen: niet gevonden.");
        }
        administratorRepository.deleteById(id);
    }
}
