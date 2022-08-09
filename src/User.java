// Planned to use the Factory design pattern for abstraction of the data type used in caching as well as implement auto
// incremented ID system.

// Another alternative is to use a AtomicInteger for the same

public class User {
    private final int id;
    private String firstName, lastName, emailId;

    // Constructors
    public User(int id, String firstName, String lastName, String emailId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
    }
    public User(int id) {
        this(id, "", "", "DefaultEmailId");
    }

    // Setters (Can be configured to obtain data from the database)
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    // Getters
    public int getId() {
        return id;
    }
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void printDetails() {
        if (firstName == null || lastName == null || emailId == null) {
            System.out.println("NULL");
        }
        System.out.println("First name: " + firstName +
                "\nLast name: " + lastName +
                "\nEmail ID: " + emailId);
    }
}