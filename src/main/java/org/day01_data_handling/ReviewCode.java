package org.day01_data_handling;

import java.util.*;

public class ReviewCode {
    public static String SorttheMethod(Map<String, Integer> mp) {
        // Adding elements to the map
        mp.put("A", 5);
        mp.put("B", 3);
        mp.put("V", 1);
        mp.put("C", 2);
        mp.put("D", 4);


        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(mp.entrySet());


        entryList.sort(Map.Entry.comparingByValue());

        // Build the sorted key-value pairs as a string
        StringBuilder result = new StringBuilder();
        for (Map.Entry<String, Integer> entry : entryList) {
            result.append(entry.getKey()).append(" - ").append(entry.getValue()).append("\n");
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Map<String, Integer> mp = new HashMap<>();
        System.out.println(SorttheMethod(mp));
    }
}
