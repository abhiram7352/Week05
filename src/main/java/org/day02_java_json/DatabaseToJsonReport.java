package org.day02_java_json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.sql.*;
import java.util.*;

public class DatabaseToJsonReport {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/your_database"; // Replace with your DB
        String username = "abhiram@7352";
        String password = "password@2025";

        String sqlQuery = "SELECT id, name, age, city FROM students"; // Replace with your table

        List<Map<String, Object>> recordsList = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(jdbcURL, username, password);
             PreparedStatement pstmt = conn.prepareStatement(sqlQuery);
             ResultSet rs = pstmt.executeQuery()) {

            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            while (rs.next()) {
                Map<String, Object> record = new LinkedHashMap<>();
                for (int i = 1; i <= columnCount; i++) {
                    record.put(metaData.getColumnName(i), rs.getObject(i));
                }
                recordsList.add(record);
            }

            // Convert List to JSON using Jackson
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
            String jsonReport = objectMapper.writeValueAsString(recordsList);

            // Print JSON Report
            System.out.println(jsonReport);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
