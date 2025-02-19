package org.day02_java_json;

import com.google.gson.JsonObject;
import com.google.gson.JsonArray;

class Student {
    //Attributes
    String name;
    int age;
    String[] subjects;

    //Constructor
    public Student(String name, int age, String[] subjects) {
        this.name = name;
        this.age = age;
        this.subjects = subjects;
    }
}
//JSONObjectExample class
public class JSONObjectExample {
    public static void main(String[] args) {
        Student student = new Student("Abhiram Kumar", 21, new String[]{"Hindi", "Maths", "Science"});

        // Creating JSON Object
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("name", student.name);
        jsonObject.addProperty("age", student.age);

        // Adding subjects array
        JsonArray subjectsArray = new JsonArray();
        for (String subject : student.subjects) {
            subjectsArray.add(subject);
        }
        jsonObject.add("subjects", subjectsArray);

        // Printing JSON Object
        System.out.println(jsonObject.toString());
    }
}
