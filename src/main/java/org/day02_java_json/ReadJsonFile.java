package org.day02_java_json;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileReader;
import java.util.Map;

public class ReadJsonFile {
    public static void main(String[] args) {
        try {
            // Read JSON file
            FileReader reader = new FileReader("C:\\Users\\Hp\\OneDrive\\Desktop\\Java Full Stack Training\\Week05\\src\\main\\java\\org\\day02_java_json\\jsonFile.json"); // Ensure this file exists
            JsonElement jsonElement = JsonParser.parseReader(reader);

            // Check if it's a JSON object
            if (jsonElement.isJsonObject()) {
                JsonObject jsonObject = jsonElement.getAsJsonObject();

                // Iterate through keys and values
                for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
                    System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
                }
            } else {
                System.out.println("The JSON file does not contain a valid JSON object.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
