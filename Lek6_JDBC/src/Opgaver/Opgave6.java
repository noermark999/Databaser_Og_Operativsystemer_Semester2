package Opgaver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;

public class Opgave6 {
    public static void main(String[] args) {

        try {
            System.out.println("Opret Tidsregistrering ");
            BufferedReader inLine = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Navn: ");
            String navn = inLine.readLine();
            System.out.println("Stillingsbetegnelse: ");
            String stilling = inLine.readLine();
            System.out.println("Mobil: ");
            String mobil = inLine.readLine();


            Connection minConnection;
            minConnection = DriverManager.getConnection(
                    "jdbc:sqlserver://localhost;databaseName=Lek3;user=sa;password=reallyStrongPwd123;");

            String sql = "insert into medarbejder values(?,?,?,?) ";// preparedStatement
            PreparedStatement prestmt = minConnection.prepareStatement(sql);
            prestmt.clearParameters();

            Statement stmt = minConnection.createStatement();
            ResultSet res = stmt.executeQuery("select max(medarbejderNR) from Medarbejder");
            res.next();
            int medid = Integer.parseInt(res.getString(1));

            prestmt.setInt(1, ++medid);
            prestmt.setString(2, navn);
            prestmt.setString(3, stilling);
            prestmt.setString(4, mobil);


            prestmt.executeUpdate();
            System.out.println("Medarbejder indsat");

            if (prestmt != null)
                prestmt.close();
            if (minConnection != null)
                minConnection.close();
        } catch (Exception e) {
            System.out.println("fejl:  " + e.getMessage());
        }
    }
}
