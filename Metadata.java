import java.sql.*;

public class Metadata {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String user = "root";
        String password = "your_password";

        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println(" Connection Established\n");
            DatabaseMetaData dbMeta = conn.getMetaData();
            System.out.println("📘 Database Metadata:");
            System.out.println("Database Product Name: " + dbMeta.getDatabaseProductName());
            System.out.println("Database Version: " + dbMeta.getDatabaseProductVersion());
            System.out.println("Driver Name: " + dbMeta.getDriverName());
            System.out.println("Driver Version: " + dbMeta.getDriverVersion());
            System.out.println("User Name: " + dbMeta.getUserName());
            System.out.println();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM students");

            ResultSetMetaData rsMeta = rs.getMetaData();
            int columnCount = rsMeta.getColumnCount();

            System.out.println(" ResultSet Metadata:");
            System.out.println("Total Columns: " + columnCount);
            for (int i = 1; i <= columnCount; i++) {
                System.out.println("Column " + i + ": " + rsMeta.getColumnName(i) +
                                   " (" + rsMeta.getColumnTypeName(i) + ")");
            }

            rs.close();
            stmt.close();
            conn.close();
            System.out.println("\n✅ Connection Closed");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
