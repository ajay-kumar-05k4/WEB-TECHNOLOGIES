import java.sql.*;

public class Simplequeries{
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String user = "root";
        String password = "your_password";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connection Established Successfully!");

            Statement stmt = conn.createStatement();

            String createTable = "CREATE TABLE IF NOT EXISTS students (" +
                                 "id INT AUTO_INCREMENT PRIMARY KEY, " +
                                 "name VARCHAR(50), " +
                                 "age INT)";
            stmt.executeUpdate(createTable);
            System.out.println("Table created (if not exists).");

            String insertQuery = "INSERT INTO students (name, age) VALUES ('Ajay', 21)";
            stmt.executeUpdate(insertQuery);
            System.out.println("Record inserted.");

            String selectQuery = "SELECT * FROM students";
            ResultSet rs = stmt.executeQuery(selectQuery);
            System.out.println("\nStudent Records:");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                                   ", Name: " + rs.getString("name") +
                                   ", Age: " + rs.getInt("age"));
            }

            String updateQuery = "UPDATE students SET age = 22 WHERE name = 'Ajay'";
            stmt.executeUpdate(updateQuery);
            System.out.println("Record updated.");

            String deleteQuery = "DELETE FROM students WHERE name = 'Ajay'";
            stmt.executeUpdate(deleteQuery);
            System.out.println("Record deleted.");

            rs.close();
            stmt.close();
            conn.close();
            System.out.println("\nConnection Closed.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
