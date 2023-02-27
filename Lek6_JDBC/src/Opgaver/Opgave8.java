package Opgaver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Opgave8 {
    public static void main(String[] args) {

        try {
            System.out.println("Opret Testtype ");
            BufferedReader inLine = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Indtast char: ");
            String testchar = inLine.readLine();
            System.out.println("Indtast varchar: ");
            String testvarchar = inLine.readLine();
            System.out.println("Indtast int: ");
            String testint = inLine.readLine();
            System.out.println("Indtast decimal: ");
            String testdecimal = inLine.readLine();
            System.out.println("Indtast date: ");
            String testdate = inLine.readLine();
            System.out.println("Indtast bit: ");
            String testbit = inLine.readLine();


            Connection minConnection;
            minConnection = DriverManager.getConnection(
                    "jdbc:sqlserver://localhost;databaseName=Lek6;user=sa;password=reallyStrongPwd123;");

            String sql = "insert into TESTTYPE values(?,?,?,?,?,?) ";// preparedStatement
            PreparedStatement prestmt = minConnection.prepareStatement(sql);
            prestmt.clearParameters();

            prestmt.setString(1, testchar);
            prestmt.setString(2, testvarchar);
            prestmt.setInt(3, Integer.parseInt(testint));
            prestmt.setFloat(4, Float.parseFloat(testdecimal));
            prestmt.setString(5, testdate);
            prestmt.setString(6, testbit);

            prestmt.executeUpdate();
            System.out.println("Testtype indsat");

            if (prestmt != null)
                prestmt.close();
            if (minConnection != null)
                minConnection.close();
        } catch (Exception e) {
            System.out.println("fejl:  " + e.getMessage());
        }
    }
}
