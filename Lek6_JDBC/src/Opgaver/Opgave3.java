package Opgaver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;

public class Opgave3 {
    public static void main(String[] args) {
        try {
            System.out.println("Find telefonnummer ");
            BufferedReader inLine = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Indtast navn: ");
            String navn = inLine.readLine();

            Connection minConnection;
            minConnection = DriverManager
                    .getConnection("jdbc:sqlserver://localhost;databaseName=Lek3;user=sa;password=reallyStrongPwd123;");

            Statement stmt = minConnection.createStatement();

            String sql = "select mobil from medarbejder where navn = (?) ";// preparedStatement
            PreparedStatement prestmt = minConnection.prepareStatement(sql);
            prestmt.clearParameters();

            prestmt.setString(1,navn);

            ResultSet res = prestmt.executeQuery();

            while (res.next()) {
                System.out.println(res.getString(1));
            }

            if (res != null)
                res.close();
            if (stmt != null)
                stmt.close();
            if (minConnection != null)
                minConnection.close();
        } catch (Exception e) {
            System.out.println("fejl:  " + e.getMessage());
        }
    }
}
