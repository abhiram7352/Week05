package org.day02_java_json;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class FilterJsonByAge {
    public static void main(String[] args) {
        // JSON Array as String
        String jsonString = "{ \"students\": " +
                "[ " +
                "{ \"name\": \"Abhiram Kumar\", \"age\": 21 }, " +
                "{ \"name\": \"Rahul Kumar\", \"age\": 30 }, " +
                "{ \"name\": \"Sneha Verma\", \"age\": 26 }, " +
                "{ \"name\": \"Rohan Das\", \"age\": 24 } " +
                "]" +
                "}";

        // Parse JSON String into a JsonObject
        JsonObject jsonObject = JsonParser.parseString(jsonString).getAsJsonObject();

        // Get the "students" array
        JsonArray studentsArray = jsonObject.getAsJsonArray("students");

        // Create a new JSON array for filtered students
        JsonArray filteredStudents = new JsonArray();

        // Loop through each student and filter by age
        for (JsonElement studentElement : studentsArray) {
            JsonObject studentObject = studentElement.getAsJsonObject();
            if (studentObject.get("age").getAsInt() > 25) {
                filteredStudents.add(studentObject);
            }
        }

        // Convert the filtered JSON array back to JSON string
        JsonObject resultJson = new JsonObject();
        resultJson.add("filtered_students", filteredStudents);

        // Print the filtered JSON
        System.out.println(new Gson().toJson(resultJson));
    }
}
