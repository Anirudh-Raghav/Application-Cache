public class Organization {
    private String name, countryOfOrigin;

    // Constructors
    public Organization (String name, String countryOfOrigin)
    {
        this.name = name;
        this.countryOfOrigin = countryOfOrigin;
    }

    public Organization () {
        this("Oracle", "Deafault Country");
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }
}