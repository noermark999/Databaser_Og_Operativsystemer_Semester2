import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;

public class Procedure {
    public static void main(String[] args) {
        try {
            // Connection & Prepare Statement
            Connection connection = DriverManager.getConnection(
                    "jdbc:sqlserver://localhost;databaseName=obliOpgave;user=sa;password=reallyStrongPwd123;");
            String sql = "INSERT INTO ResultAfEksamen VALUES(?,?,?)";
            java.sql.PreparedStatement statement = connection.prepareStatement(sql);

            // Ask for input
            System.out.println("Indsæt karakter");
            BufferedReader inLine = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Intast studerendes ID: ");
            String studerendeId = inLine.readLine();
            System.out.print("Indtast eksamens ID: ");
            String eksamenId = inLine.readLine();
            System.out.print("Indtast karakter: ");
            String karakter = inLine.readLine();

            // Execute Statement
            statement.setInt(1, Integer.parseInt(studerendeId.trim()));
            statement.setInt(2, Integer.parseInt(eksamenId.trim()));
            statement.setInt(3, Integer.parseInt(karakter.trim()));
            System.out.println(statement.executeUpdate());
            System.out.println("Karakter indsat");

            // Close
            statement.close();
            connection.close();
        } catch (SQLException e) {
            if (e.getErrorCode() == 51000) {
                System.out.println(e.getMessage());
            }
            if (e.getErrorCode() == 547) {
                System.out.println("Fejl");
            }
        } catch (Exception e) {
            System.out.println("fejl:  " + e.getMessage());
        }
    }
}









