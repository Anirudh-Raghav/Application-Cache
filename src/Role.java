public class Role {
    private String designation, division, location;

    // Constructors
    public Role(String designation, String division, String location) {
        // Can also be obtained from the DB side and loaded into the class
        this.designation = designation;
        this.division = division;
        this.location = location;
    }
    public Role() {
        this("Default Designation", "Default Division", "Default Location");
    }

    // Getters
    public String getDesignation() {
        return designation;
    }
    public String getDivision() {
        return division;
    }

    public String getLocation() {
        return location;
    }
}