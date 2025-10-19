package FreelanceHub;

import java.sql.*;

public class DatabaseConnection {
    private static final String SERVER_URL = "jdbc:mysql://localhost:3306/";
    private static final String DB_NAME = "freelancehub";
    private static final String DB_URL = SERVER_URL + DB_NAME;
    private static final String USER = "root";
    private static final String PASS = "***";

    private static Connection connection = null;

    private static void createDatabase() {
        try (Connection conn = DriverManager.getConnection(SERVER_URL, USER, PASS)) {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("CREATE DATABASE IF NOT EXISTS " + DB_NAME);
            System.out.println("Database created or already exists");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void createTables(Connection conn) throws SQLException {
        Statement stmt = conn.createStatement();

        String createUsers = """
                CREATE TABLE IF NOT EXISTS users (
                    user_id VARCHAR(50) PRIMARY KEY,
                    password VARCHAR(50) NOT NULL
                )""";

        String createClients = """
                CREATE TABLE IF NOT EXISTS clients (
                    client_id INT PRIMARY KEY,
                    client_name VARCHAR(100) NOT NULL,
                    contact_info VARCHAR(255)
                )""";

        String createProjects = """
                CREATE TABLE IF NOT EXISTS project (
                    project_id INT PRIMARY KEY,
                    project_name VARCHAR(100) NOT NULL,
                    description TEXT,
                    user_id VARCHAR(50),
                    client_id INT,
                    FOREIGN KEY (user_id) REFERENCES users(user_id),
                    FOREIGN KEY (client_id) REFERENCES clients(client_id)
                )""";

        String createTasks = """
                CREATE TABLE IF NOT EXISTS task (
                    task_id INT AUTO_INCREMENT PRIMARY KEY,
                    task_name VARCHAR(100) NOT NULL,
                    description TEXT,
                    status VARCHAR(20),
                    project_id INT,
                    FOREIGN KEY (project_id) REFERENCES project(project_id)
                )""";

        stmt.executeUpdate(createUsers);
        stmt.executeUpdate(createClients);
        stmt.executeUpdate(createProjects);
        stmt.executeUpdate(createTasks);
        System.out.println("Tables created successfully");
    }

    public static Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                createDatabase();  

                System.out.println("Connecting to the database...");
                connection = DriverManager.getConnection(DB_URL, USER, PASS);
                createTables(connection); 
                System.out.println("Connection established successfully!");

            } catch (ClassNotFoundException e) {
                System.err.println("JDBC Driver not found!");
                e.printStackTrace();
            } catch (SQLException e) {
                System.err.println("Connection failed! Check your URL, username, and password.");
                e.printStackTrace();
            }
        }
        return connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Database connection closed.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}