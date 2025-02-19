package org.day02_java_json;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class MergeTwoJSONObjectArray {
    public static void main(String[] args) {
        JsonObject jsonObject1 = new JsonObject();
        jsonObject1.addProperty("name", "Abhiram Kumar");
        jsonObject1.addProperty("age", 21);

        JsonObject jsonObject2 = new JsonObject();
        jsonObject2.addProperty("name", "Rahul Kumar");
        jsonObject2.addProperty("age", 40);

        // Store both objects in an array
        JsonArray jsonArray = new JsonArray();
        jsonArray.add(jsonObject1);
        jsonArray.add(jsonObject2);

        // Create final JSON object
        JsonObject jsonObject3 = new JsonObject();
        jsonObject3.add("people", jsonArray);

        System.out.println(jsonObject3.toString());
    }
}
