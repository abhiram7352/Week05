package org.day02_java_json;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ValidateJson {
    public static  boolean isValidJson(String json) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(json);
            return jsonNode != null; // JSON is valid
        } catch (Exception e) {
            return false; // Invalid JSON
        }
    }

    public static void main(String[] args) {
        String validJson = "{ \"name\": \"Ravi\", \"age\": 25 }";
        String invalidJson = "{ name: \"Ravi\", age: 25 "; // Missing closing }

        System.out.println("Valid JSON? " + isValidJson(validJson));   // Output: true
        System.out.println("Valid JSON? " + isValidJson(invalidJson)); // Output: false
    }
}
