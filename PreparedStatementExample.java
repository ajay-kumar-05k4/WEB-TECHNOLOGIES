import java.sql.*;

public class PreparedStatementExample {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String user = "root";
        String password = "your_password";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("Connected!");

            String create = "CREATE TABLE students(id INT, name VARCHAR(30))";
            java.sql.PreparedStatement ps1 = con.prepareStatement(create);
            ps1.executeUpdate();
            System.out.println("Table created.");

            String insert = "INSERT INTO students VALUES(?, ?)";
            java.sql.PreparedStatement ps2 = con.prepareStatement(insert);
            ps2.setInt(1, 1);
            ps2.setString(2, "Ajay");
            ps2.executeUpdate();
            System.out.println("Record inserted.");

            String select = "SELECT * FROM students";
            java.sql.PreparedStatement ps3 = con.prepareStatement(select);
            ResultSet rs = ps3.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getInt(1) + "  " + rs.getString(2));
            }

            con.close();
            System.out.println("Connection closed.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
