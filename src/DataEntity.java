// We can change the setters according to a JDBC to get, append and set values

interface Users {
    void setFirstName(String firstName);
    String getFirstName();

    void setLastName(String lastName);
    String getLastName();

    void setEmailId(String emailId);
    String getEmailId();
}

interface Roles {
    void setDesignation(String designation);
    String getDesignation();

    void setDivision(String division);
    String getDivision();

    void setLocation(String location);
    String getLocation();
}

interface Organizations {
    void setOrganizationName(String organizationName);
    String getOrganizationName();

    void setCountryOfOrigin(String countryOfOrigin);
    String getCountryOfOrigin();
}

public class DataEntity implements Users, Roles, Organizations{
    // User fields
    private String firstName, lastName, emailId;
    // Role fields
    private String designation, division, location;
    // Organization fields
    private String organizationName, countryOfOrigin;

    // Omitted constructors and included setters as they can be modified to directly get data from JDBC for a given connection

    // User setters
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
    // Role getters
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getEmailId() {
        return emailId;
    }

    // Role setters
    public void setDesignation(String designation) {
        this.designation = designation;
    }
    public void setDivision(String division) {
        this.division = division;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    // Role getters
    public String getDesignation() {
        return designation;
    }
    public String getDivision() {
        return division;
    }
    public String getLocation() {
        return location;
    }

    // Organization setters
    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }
    public void setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
    }
    // Organization getters
    public String getOrganizationName() {
        return organizationName;
    }
    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }
}
