package org.day01_data_handling;

import java.io.*;
import java.util.regex.*;

public class ValidateCSVData {
    public static void main(String[] args) {
        String filePath = "employees.csv"; // CSV file path
        String line;

        // Regex patterns
        String emailRegex = "^[\\w.-]+@[a-zA-Z\\d.-]+\\.[a-zA-Z]{2,6}$"; // Valid email pattern
        String phoneRegex = "^\\d{10}$"; // Exactly 10 digits for phone number

        Pattern emailPattern = Pattern.compile(emailRegex);
        Pattern phonePattern = Pattern.compile(phoneRegex);

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String header = br.readLine(); // Read header row
            System.out.println("Checking for invalid records...\n");

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String email = data[3].trim(); // Assuming Email is in the 4th column
                String phone = data[4].trim(); // Assuming Phone Number is in the 5th column

                boolean isEmailValid = emailPattern.matcher(email).matches();
                boolean isPhoneValid = phonePattern.matcher(phone).matches();

                if (!isEmailValid || !isPhoneValid) {
                    System.out.println("Invalid Record: " + line);
                    if (!isEmailValid) {
                        System.out.println("  ➤ Invalid Email: " + email);
                    }
                    if (!isPhoneValid) {
                        System.out.println("  ➤ Invalid Phone Number: " + phone);
                    }
                    System.out.println();
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}
