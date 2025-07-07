package nl.novi.backend_eindopdracht.util.location;

import java.util.regex.Pattern;

public class LocationHelper {


    private static final Pattern POSTAL_CODE_PATTERN = Pattern.compile("^[1-9][0-9]{3}\\s?[A-Z]{2}$");

    private static final Pattern PHONE_PATTERN = Pattern.compile(
            "^((\\+31|0031|0)[1-9][0-9]{1,3}[\\s\\-]?[0-9]{6,7})$"
    );

    public static boolean isValidPostalCode(String postalCode) {
        if (postalCode == null) return false;
        return POSTAL_CODE_PATTERN.matcher(postalCode.trim().toUpperCase()).matches();
    }

    public static String formatPostalCode(String postalCode) {
        if (postalCode == null) return null;
        String cleaned = postalCode.replaceAll("\\s+", "").toUpperCase();
        if (cleaned.length() == 6) {
            return cleaned.substring(0, 4) + " " + cleaned.substring(4);
        }
        return postalCode;
    }

    public static boolean isValidPhoneNumber(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.isBlank()) return false;
        String cleaned = phoneNumber.replaceAll("[\\s\\-()]", "");
        return PHONE_PATTERN.matcher(cleaned).matches();
    }
}
