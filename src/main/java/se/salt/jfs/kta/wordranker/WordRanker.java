package se.salt.jfs.kta.wordranker;

import java.sql.Array;

public class WordRanker {

    public String highestRanking(String sentence){

        String[] words = sentence.split(" ");

        if (words.length == 0 || words[0] == ""){
            throw new IllegalArgumentException("Please enter a word");
        }

        int highestValue = 0;
        String highestRankingWord = "";

        for (String word:words) {
            int wordValue = 0;

            for (int i = 0; i < word.length(); i++) {
                if (Character.isAlphabetic(word.charAt(i))){
                    wordValue += word.charAt(i);
                }
                if (wordValue > highestValue){
                    highestValue = wordValue;
                    highestRankingWord = word;
                }
            }
        }
        return highestRankingWord;
    }
}
