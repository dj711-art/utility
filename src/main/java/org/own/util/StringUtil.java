package org.own.util;

import java.util.HashMap;

public class StringUtil {

    public  static HashMap<Character, Integer> countLetterFrequency(String sentence) {
        HashMap<Character, Integer> letterCount = new HashMap<>();
        for (char letter : sentence.toCharArray()) {
            // or add it with a count of 1 if it's not already there
            if (Character.isLetter(letter)){
                letterCount.put(letter, letterCount.getOrDefault(letter, 0) + 1);
            }
        }
        return letterCount;
    }

}
