package nl.novi.backend_eindopdracht.service.user;

import nl.novi.backend_eindopdracht.helper.user.UserHelper;
import nl.novi.backend_eindopdracht.model.enums.RolType;
import nl.novi.backend_eindopdracht.model.user.Administrator;
import nl.novi.backend_eindopdracht.repository.user.AdministratorRepository;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class AdministratorService {

    private final AdministratorRepository administratorRepository;

    public AdministratorService(AdministratorRepository administratorRepository) {
        this.administratorRepository = administratorRepository;
    }

    public List<Administrator> getAllAdministrators() {
        List<Administrator> admins = administratorRepository.findAll();
        admins.forEach(UserHelper::maskPassword);  // verberg wachtwoorden
        return admins;
    }

    public Administrator getAdministratorById(int id) {
        Administrator admin = administratorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Administrator met id " + id + " niet gevonden"));

        if (!UserHelper.isAdmin(admin)) {
            throw new SecurityException("Gebruiker is geen administrator");
        }

        UserHelper.maskPassword(admin);
        return admin;
    }

    public Administrator saveAdministrator(Administrator administrator) {
        // Email validatie (optioneel)
        if (!UserHelper.isValidEmail(administrator.getEmail())) {
            throw new IllegalArgumentException("Ongeldig e-mailadres");
        }

        // Hier kun je ook checken of de rol klopt:
        if (!UserHelper.hasRole(administrator, RolType.ADMINISTRATOR)) {
            throw new IllegalArgumentException("Rol moet ADMINISTRATOR zijn");
        }

        return administratorRepository.save(administrator);
    }

    public void deleteAdministrator(int id) {
        if (!administratorRepository.existsById(id)) {
            throw new EntityNotFoundException("Administrator met id " + id + " bestaat niet");
        }
        administratorRepository.deleteById(id);
    }
}
