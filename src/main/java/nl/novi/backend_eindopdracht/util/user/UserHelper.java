package nl.novi.backend_eindopdracht.util.user;

import nl.novi.backend_eindopdracht.model.user.enums.RolType;
import nl.novi.backend_eindopdracht.model.user.User;

import java.util.regex.Pattern;

public class UserHelper {

    // ===================== ROL-CHECKS =====================

    public static boolean isAdmin(User user) {
        return user != null && user.getRole() == RolType.ADMINISTRATOR;
    }

    public static boolean isTrainer(User user) {
        return user != null && user.getRole() == RolType.TRAINER;
    }

    public static boolean isStudent(User user) {
        return user != null && user.getRole() == RolType.STUDENT;
    }

    public static boolean hasRole(User user, RolType role) {
        return user != null && user.getRole() == role;
    }

    // ===================== WACHTWOORD MASKEREN =====================

    public static void maskPassword(User user) {
        if (user != null) {
            user.setPassword("****");
        }
    }

    // ===================== VALIDATIE =====================

    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public static boolean isValidEmail(String email) {
        return email != null && EMAIL_PATTERN.matcher(email).matches();
    }

}
