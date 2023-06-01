package se.salt.jfs.kta.wordranker;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class WordRanker {
    public String highestRanking(String sentence) {
        if (sentence == " ") {
            throw new IllegalArgumentException("Sentence must not be empty");
        }
        String[] splitSentence = sentence.split(" ");
        List<Integer> wordScores = Arrays.stream(splitSentence)
                .map(str -> str.replaceAll("(?i)[^a-z]", ""))
                .map(str -> (int) str.chars().sum())
                .toList();
        int maxIndex = wordScores.indexOf(Collections.max(wordScores));
        return splitSentence[maxIndex].replaceAll("(?i)[^a-z]", "");
    }
}
