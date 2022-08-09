import java.sql.*;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;


public class UserDAO {
    private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;

    // CREATE
    private static final String INSERT_USERS_SQL = "INSERT INTO users" + "  (fname, lname, email) VALUES " +
            " (?, ?, ?);";

    // READ
    private static final String SELECT_USER_BY_ID = "SELECT id, fname, lname, email FROM users WHERE id=?;";
    private static final String SELECT_ALL_USERS = "SELECT * FROM users;";

    // UPDATE
    private static final String UPDATE_USERS_SQL = "UPDATE users SET fname= ?, lname=?, email- ?;";

    // DELETE
    private static final String DELETE_USERS_SQL = "DELETE from users WHERE id= ?";

    // Constructor
    UserDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        this.jdbcURL = jdbcURL;
        this.jdbcUsername = jdbcUsername;
        this.jdbcPassword = jdbcPassword;
    }

    UserDAO(String jdbcUsername, String jdbcPassword) {
        this("jdbc:mysql://localhost:5000/sampleDB", jdbcUsername, jdbcPassword);
    }

    UserDAO() {}

    // To establish a connection
    protected Connection getConnection() {
        Connection conn = null;

        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return conn;
    }

    public void insert(User user) throws SQLException {
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getEmailId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public User selectOne(int id) throws SQLException {
        User user = null;

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {

            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String name = rs.getString("fname");
                String email = rs.getString("lname");
                String country = rs.getString("email");
                user = new User(id, name, email, country);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return user;
    }

    public List <User> selectAll() throws SQLException {
        List < User > users = new ArrayList < > ();

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("fname");
                String email = rs.getString("lname");
                String country = rs.getString("email");
                users.add(new User(id, name, email, country));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return users;
    }

    public boolean delete(int id) throws SQLException{
        boolean rowDeleted;

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    public boolean update(User user) throws SQLException {
        boolean rowUpdated;

        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getLastName());
            statement.setString(3, user.getEmailId());
            statement.setInt(4, user.getId());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
