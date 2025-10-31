import java.sql.*;

public class UpdatableAndScrollable{
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String user = "root";
        String password = "your_password";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("Connected!");

            Statement stmt = con.createStatement(
                ResultSet.TYPE_SCROLL_SENSITIVE, 
                ResultSet.CONCUR_UPDATABLE
            );

            ResultSet rs = stmt.executeQuery("SELECT * FROM students");

            System.out.println("Forward Direction:");
            while (rs.next()) {
                System.out.println(rs.getInt(1) + "  " + rs.getString(2));
            }

            System.out.println("\nBackward Direction:");
            while (rs.previous()) {
                System.out.println(rs.getInt(1) + "  " + rs.getString(2));
            }

            rs.absolute(1);
            rs.updateString("name", "Ajay Kumar");
            rs.updateRow();
            System.out.println("\nRow updated successfully.");

            rs.moveToInsertRow();
            rs.updateInt("id", 5);
            rs.updateString("name", "New Student");
            rs.insertRow();
            System.out.println("New row inserted successfully.");

            rs.beforeFirst();
            System.out.println("\nFinal Table:");
            while (rs.next()) {
                System.out.println(rs.getInt(1) + "  " + rs.getString(2));
            }

            con.close();
            System.out.println("\nConnection closed.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
