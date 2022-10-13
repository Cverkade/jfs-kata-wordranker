package se.salt.jfs.kta.wordranker;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WordRankerTest {


    WordRanker ranker = new WordRanker();

    @Test
    void shouldRateBrownHighest() {
        String word = ranker.highestRanking("The quick, brown fox");
        assertEquals("brown", word);
    }
}