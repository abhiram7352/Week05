package org.day01_data_handling;

import java.io.*;
import java.sql.*;

public class GenerateCSVReportFromDB {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/your_database"; // JDBC URL for MySQL
        String jdbcUser = "abhi_ram7352"; // Database username
        String jdbcPassword = "abhram@2003"; // Database password
        String query = "SELECT employee_id, name, department, salary FROM employees"; // SQL Query

        try (Connection conn = DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPassword);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query);
             BufferedWriter bw = new BufferedWriter(new FileWriter("employee_report.csv"))) {

            // Write CSV headers
            bw.write("Employee ID,Name,Department,Salary");
            bw.newLine();

            // Write data from the result set into the CSV file
            while (rs.next()) {
                int id = rs.getInt("employee_id");
                String name = rs.getString("name");
                String department = rs.getString("department");
                double salary = rs.getDouble("salary");

                // Write a single record into the CSV file
                bw.write(id + "," + name + "," + department + "," + salary);
                bw.newLine();
            }

            System.out.println("CSV report generated successfully.");
        } catch (SQLException | IOException e) {
            System.out.println("Error generating CSV report: " + e.getMessage());
        }
    }
}
