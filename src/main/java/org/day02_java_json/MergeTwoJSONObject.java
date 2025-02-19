package org.day02_java_json;


import com.google.gson.JsonObject;

public class MergeTwoJSONObject {
    public static void main(String[] args) {
        JsonObject jsonObject1 = new JsonObject();
        jsonObject1.addProperty("name", "Abhiram Kumar");
        jsonObject1.addProperty("age", 21);
        jsonObject1.addProperty("city", "Delhi");

        JsonObject jsonObject2 = new JsonObject();
        jsonObject2.addProperty("name", "Rahul Kumar");
        jsonObject2.addProperty("age", 40);
        jsonObject2.addProperty("city", "Mumbai");

        // Merging two JSON objects
        JsonObject mergedJson = new JsonObject();
        jsonObject1.entrySet().forEach(entry -> mergedJson.add(entry.getKey(), entry.getValue()));
        jsonObject2.entrySet().forEach(entry -> mergedJson.add(entry.getKey(), entry.getValue()));

        // Print merged JSON object
        System.out.println(mergedJson.toString());
    }
}
