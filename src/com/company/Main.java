package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Map<String, Integer> wordsList = new HashMap<>();
        Path filePath = Paths.get("src/com/company/song");
        String song = new String(Files.readAllBytes(filePath));
        song = song.toLowerCase();
        ArrayList<String> words = new ArrayList<>(Arrays.asList(song.split("\\W+")));
        for (int i = 0; i < words.size(); i++) {
            String word = words.get(i);

            if (!wordsList.containsKey(word)) {
                wordsList.put(word, 1);
            } else {
                wordsList.put(word, wordsList.get(word) + 1);
            }
        }

        wordsList.forEach((key, value) -> System.out.println(key + " : " + value));

        int max = Collections.max(wordsList.values());
        for (Map.Entry<String, Integer> pair : wordsList.entrySet()) {
            if (pair.getValue() == max) {
                System.out.println("Most frequent word is: " + pair.getKey() + ". Number of repeats : " + pair.getValue());
            }

        }

    }
}
