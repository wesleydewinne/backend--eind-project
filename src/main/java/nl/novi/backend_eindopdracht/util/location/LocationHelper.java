package nl.novi.backend_eindopdracht.util.location;

public class LocationHelper {

    public static boolean isValidPostalCode(String postalCode) {
        if (postalCode == null) return false;
        String cleaned = postalCode.replaceAll("\\s+", "").toUpperCase();

        // Postcode moet 6 tekens lang zijn: 4 cijfers en 2 hoofdletters
        if (cleaned.length() != 6) return false;

        String digits = cleaned.substring(0, 4);
        String letters = cleaned.substring(4);

        return digits.matches("[1-9][0-9]{3}") && letters.matches("[A-Z]{2}");
    }

    public static String formatPostalCode(String postalCode) {
        if (postalCode == null) return null;

        String cleaned = postalCode.replaceAll("\\s+", "").toUpperCase();
        if (cleaned.length() == 6) {
            return cleaned.substring(0, 4) + " " + cleaned.substring(4);
        }
        return postalCode.toUpperCase();
    }

    public static boolean isValidPhoneNumber(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.isBlank()) return false;

        String cleaned = phoneNumber.replaceAll("[\\s\\-()]", "");

        if (cleaned.startsWith("+31")) {
            cleaned = cleaned.substring(3);
        } else if (cleaned.startsWith("0031")) {
            cleaned = cleaned.substring(4);
        } else if (cleaned.startsWith("0")) {
            cleaned = cleaned.substring(1);
        } else {
            return false;
        }

        // Check of de rest uit 9 cijfers bestaat (zoals 612345678)
        return cleaned.matches("[1-9][0-9]{8}");
    }

    public static String formatPhoneNumber(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.isBlank()) return null;

        String cleaned = phoneNumber.replaceAll("[\\s\\-()]", "");

        if (cleaned.startsWith("06")) {
            return "+31 6" + cleaned.substring(2);
        } else if (cleaned.startsWith("0 ")) {
            return "+31" + cleaned.substring(1);
        } else if (cleaned.startsWith("0031 ")) {
            return "+31" + cleaned.substring(4);
        } else if (cleaned.startsWith("+31 ")) {
            return cleaned;
        }

        return cleaned;
    }
}
