package Opgaver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Opgave5 {
    public static void main(String[] args) {

        try {
            System.out.println("Opret Tidsregistrering ");
            BufferedReader inLine = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Indtast Starttid: ");
            String starttid = inLine.readLine();
            System.out.println("Indtast sluttid: ");
            String sluttid = inLine.readLine();
            System.out.println("Indtast beskrivelse af arbejde: ");
            String beskrivelse = inLine.readLine();
            System.out.println("Dato for registrering: ");
            String dato = inLine.readLine();
            System.out.println("MedarbejderNr: ");
            String medNr = inLine.readLine();
            System.out.println("OpgaveNr: ");
            String opgNr = inLine.readLine();


            Connection minConnection;
            minConnection = DriverManager.getConnection(
                    "jdbc:sqlserver://localhost;databaseName=Lek3;user=sa;password=reallyStrongPwd123;");

            String sql = "insert into Tidsregistrering values(?,?,?,?,?,?) ";// preparedStatement
            PreparedStatement prestmt = minConnection.prepareStatement(sql);
            prestmt.clearParameters();

            prestmt.setString(1, starttid);
            prestmt.setString(2, sluttid);
            prestmt.setString(3, beskrivelse);
            prestmt.setString(4, dato);
            prestmt.setInt(5, Integer.parseInt(medNr.trim()));
            prestmt.setInt(6, Integer.parseInt(opgNr.trim()));

            prestmt.executeUpdate();
            System.out.println("Tidsregistrering indsat");

            if (prestmt != null)
                prestmt.close();
            if (minConnection != null)
                minConnection.close();
        } catch (Exception e) {
            System.out.println("fejl:  " + e.getMessage());
        }
    }
}
