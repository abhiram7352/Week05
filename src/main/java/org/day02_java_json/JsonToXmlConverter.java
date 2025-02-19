package org.day02_java_json;


import org.json.JSONObject;
import org.json.XML;

public class JsonToXmlConverter {
    public static void main(String[] args) {
        // JSON input
        String jsonString = """
            {
                "student": {
                    "name": "Abhiram Kumar",
                    "age": 21,
                    "city": "Delhi"
                }
            }
            """;

        // Convert JSON to XML
        JSONObject jsonObject = new JSONObject(jsonString);
        String xmlString = XML.toString(jsonObject);

        // Print the XML output
        System.out.println("XML Output:\n" + xmlString);
    }
}
