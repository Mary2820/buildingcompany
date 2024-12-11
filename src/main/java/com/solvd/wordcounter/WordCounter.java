package com.solvd.wordcounter;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class WordCounter {
    public static void main(String[] args) {
        try {
            FileUtils.writeLines(new File("output.txt"),
                    Arrays.stream(FileUtils.readFileToString(new File("input.txt"), StandardCharsets.UTF_8)
                                    .toLowerCase().chars()
                                    .mapToObj(c -> Character.isLetterOrDigit(c) || Character.isWhitespace(c) ? (char) c : ' ')
                                    .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                                    .toString().split("\\s+"))
                            .filter(word -> !word.isEmpty())
                            .collect(Collectors.groupingBy(word -> word, TreeMap::new, Collectors.counting()))
                            .entrySet().stream().map(entry -> entry.getKey() + " (" + entry.getValue() + ")")
                            .collect(Collectors.toList())
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}