package org.day02_java_json;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.FileReader;
import java.io.IOException;

public class ReadJson {
    public static void main(String[] args) {
      try{
          FileReader fileReader = new FileReader("C:\\Users\\Hp\\OneDrive\\Desktop\\Java Full Stack Training\\Week05\\src\\main\\java\\org\\day02_java_json\\jsonFile.json");

          JsonObject jsonObject = JsonParser.parseReader(fileReader).getAsJsonObject();

          //Extract specific fields
          String name = jsonObject.get("name").getAsString();
          String email = jsonObject.get("email").getAsString();

          //Print extracted value
          System.out.println("Name: " + name);
          System.out.println("Email: " + email);
      } catch (IOException e) {
           e.printStackTrace();
      }
    }
}
