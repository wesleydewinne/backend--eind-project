package nl.novi.backend_eindopdracht.util.location;

import java.util.regex.Pattern;

public class LocationHelper {

    // Nederlands postcode patroon: 1234 AB
    private static final Pattern POSTAL_CODE_PATTERN = Pattern.compile("^[1-9][0-9]{3}\\s?[A-Z]{2}$");

    /**
     * Check of de postcode geldig is.
     */
    public static boolean isValidPostalCode(String postalCode) {
        if (postalCode == null) return false;
        return POSTAL_CODE_PATTERN.matcher(postalCode.trim().toUpperCase()).matches();
    }

    /**
     * Format postcode naar standaard formaat: 1234 AB
     */
    public static String formatPostalCode(String postalCode) {
        if (postalCode == null) return null;

        String cleaned = postalCode.replaceAll("\\s+", "").toUpperCase();
        if (cleaned.length() == 6) {
            return cleaned.substring(0, 4) + " " + cleaned.substring(4);
        }
        return postalCode;
    }

    /**
     * Dummy-functie voor toekomstig gebruik (bijv. externe API koppeling).
     * Hier kun je later een adres opvragen op basis van postcode.
     */
    public static String lookupCityByPostalCode(String postalCode) {
        if (postalCode == null) return null;

        // Tijdelijk dummy gedrag
        if (postalCode.startsWith("101")) return "Amsterdam";
        if (postalCode.startsWith("301")) return "Rotterdam";
        if (postalCode.startsWith("251")) return "Den Haag";
        if (postalCode.startsWith("381")) return "Amersfoort";
        return "Onbekend";
    }
}
