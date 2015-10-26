package com.ginvaell.module4.task1;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class KeyWords {
    private final Map<String, Integer> words = new HashMap<>();

    public KeyWords(File filename) throws IOException {
        try (FileReader fileReader = new FileReader(filename);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String tmp;
            while (true) {
                tmp = bufferedReader.readLine();
                if (tmp == null) break;
                words.put(tmp, 0);

            }


        }
    }


    public boolean tryInc(String word) {
        if (!Objects.equals(word, "") && words.containsKey(word)) {
            Integer tmp = words.get(word);
            words.put(word, tmp + 1);
            return true;
        } else {
            return false;
        }
    }

    public void printAll() {
        System.out.println(words);
    }

    public String getUsedWords() {
        StringBuilder result = new StringBuilder();
        words.entrySet().stream().filter(entry -> entry.getValue() > 0).forEach(entry -> {
            result.append(entry.getKey());
            result.append(" ");
            result.append(entry.getValue());
            result.append("\n");
        });
        return result.toString();
    }
}
