package org.day01_data_handling;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteCSV {
    public static void main(String[] args) {
        String filePath = "employees.csv"; // Output file name

        // Employee data (ID, Name, Department, Salary)
        String[] employees = {
                "101,Abhiram,Engineering,75000",
                "102,Hiritk,Marketing,68000",
                "103,Ram Vikash,HR,60000",
                "104,Putin,Finance,72000",
                "105,Trump Donald,IT,80000"
        };

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            // Writing header
            bw.write("ID,Name,Department,Salary");
            bw.newLine();

            // Writing employee records
            for (String emp : employees) {
                bw.write(emp);
                bw.newLine();
            }

            System.out.println("CSV file created successfully: " + filePath);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}
