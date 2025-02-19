package org.day02_java_json;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.csv.*;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;

public class IPLCensorAnalyzer {
    public static void main(String[] args) {
        // File paths
        String jsonInputFile = "C:\\Users\\Hp\\OneDrive\\Desktop\\Java Full Stack Training\\Week05\\src\\main\\java\\org\\day02_java_json\\ipl_matches.json";
        String jsonOutputFile = "censored_ipl_matches.json";
        String csvInputFile = "C:\\Users\\Hp\\OneDrive\\Desktop\\Java Full Stack Training\\Week05\\src\\main\\java\\org\\day02_java_json\\ipl_matches.csv";
        String csvOutputFile = "censored_ipl_matches.csv";

        // Process JSON
        processJsonFile(jsonInputFile, jsonOutputFile);

        // Process CSV
        processCsvFile(csvInputFile, csvOutputFile);
    }

    // ✅ Method to process JSON file
    private static void processJsonFile(String inputFile, String outputFile) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Read JSON file into a list of maps
            List<Map<String, Object>> matches = objectMapper.readValue(new File(inputFile), new TypeReference<List<Map<String, Object>>>() {});

            // Apply censorship rules
            for (Map<String, Object> match : matches) {
                match.put("team1", censorTeamName((String) match.get("team1")));
                match.put("team2", censorTeamName((String) match.get("team2")));
                match.put("winner", censorTeamName((String) match.get("winner")));
                match.put("player_of_match", "REDACTED");

                // Censor score keys
                Map<String, Integer> scores = (Map<String, Integer>) match.get("score");
                Map<String, Integer> censoredScores = scores.entrySet().stream()
                        .collect(Collectors.toMap(
                                e -> censorTeamName(e.getKey()),
                                Map.Entry::getValue
                        ));
                match.put("score", censoredScores);
            }

            // Write Censored Data to JSON
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(outputFile), matches);
            System.out.println("✅ Censored JSON file created: " + outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // ✅ Method to process CSV file
    private static void processCsvFile(String inputFile, String outputFile) {
        try (Reader reader = Files.newBufferedReader(Paths.get(inputFile));
             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader());
             BufferedWriter writer = Files.newBufferedWriter(Paths.get(outputFile));
             CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT.withHeader(csvParser.getHeaderNames().toArray(new String[0])))) {

            for (CSVRecord record : csvParser) {
                csvPrinter.printRecord(
                        record.get("match_id"),
                        censorTeamName(record.get("team1")),
                        censorTeamName(record.get("team2")),
                        record.get("score_team1"),
                        record.get("score_team2"),
                        censorTeamName(record.get("winner")),
                        "REDACTED"
                );
            }

            System.out.println("✅ Censored CSV file created: " + outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // ✅ Method to censor team names
    private static String censorTeamName(String team) {
        if (team.contains(" ")) {
            return team.substring(0, team.indexOf(" ")) + " ***";
        }
        return team;
    }
}
