package org.day02_java_json;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.csv.*;

import java.io.*;
import java.util.*;

public class CsvToJsonConverter {
    public static void main(String[] args) {
        String csvFilePath = "C:\\Users\\Hp\\OneDrive\\Desktop\\Java Full Stack Training\\Week05\\src\\main\\java\\org\\day02_java_json\\data.csv"; // Replace with your CSV file path
        List<Map<String, String>> dataList = new ArrayList<>();

        try (Reader reader = new FileReader(csvFilePath);
             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader())) {

            for (CSVRecord csvRecord : csvParser) {
                Map<String, String> jsonMap = new LinkedHashMap<>();
                for (String header : csvParser.getHeaderNames()) {
                    jsonMap.put(header, csvRecord.get(header));
                }
                dataList.add(jsonMap);
            }

            // Convert List of Maps to JSON
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonOutput = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(dataList);

            // Print JSON output
            System.out.println(jsonOutput);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
