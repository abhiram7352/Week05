package org.day02_java_json;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

class Student1 {
    String name;
    int age;

    public Student1(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

public class JavaObjectIntoJSONArray {
    public static void main(String[] args) {
        // Create a list of Student objects
        List<Student1> students = new ArrayList<>();
        students.add(new Student1("Abhiram Kumar", 21));
        students.add(new Student1("Rahul Kumar", 25));
        students.add(new Student1("Sneha Verma", 22));

        // Convert list of objects into JSON array
        Gson gson = new Gson();
        JsonElement jsonArray = gson.toJsonTree(students);

        // Create final JSON object
        JsonObject jsonObject = new JsonObject();
        jsonObject.add("students", jsonArray);

        // Print JSON
        System.out.println(jsonObject.toString());
    }
}
