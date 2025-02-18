package org.day01_data_handling;

import java.util.HashMap;

public class LoveLeetCodeProblem {
    public static char firstUniqueChar(String str) {
        HashMap<Character, Integer> occ = new HashMap<>();

        for (char ch : str.toCharArray()) {
            occ.put(ch, occ.getOrDefault(ch, 0) + 1);
        }

        for (char ch : str.toCharArray()) {
            if (occ.get(ch) == 1) {
                return ch;
            }
        }
        return '0';
    }

    public static void main(String[] args) {
        String str = "loveleetcode";
        char result = firstUniqueChar(str);
        System.out.println(result);

    }
}
