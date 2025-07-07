package nl.novi.backend_eindopdracht.dto.location;

public class LocationDto {

    private Long id;
    private String street;
    private String postalCode;
    private String city;
    private String building;
    private String extraInfo;
    private String phoneNumber;
    private boolean fireDrillPossible;
    private String fireDrillLocation;

    // Getters en setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getStreet() { return street; }
    public void setStreet(String street) { this.street = street; }

    public String getPostalCode() { return postalCode; }
    public void setPostalCode(String postalCode) { this.postalCode = postalCode; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getBuilding() { return building; }
    public void setBuilding(String building) { this.building = building; }

    public String getExtraInfo() { return extraInfo; }
    public void setExtraInfo(String extraInfo) { this.extraInfo = extraInfo; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public boolean isFireDrillPossible() { return fireDrillPossible; }
    public void setFireDrillPossible(boolean fireDrillPossible) { this.fireDrillPossible = fireDrillPossible; }

    public String getFireDrillLocation() { return fireDrillLocation; }
    public void setFireDrillLocation(String fireDrillLocation) { this.fireDrillLocation = fireDrillLocation; }
}
