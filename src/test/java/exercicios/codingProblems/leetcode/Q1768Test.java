package exercicios.codingProblems.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
class Q1768Test {

    @Test
    void mergeAlternately1() {
        String word1 = "abc";
        String word2 = "pqr";
        String mergeAlternately = Q1768.mergeAlternately(word1, word2);

        Assertions.assertEquals(mergeAlternately, "apbqcr");
    }

    @Test
    void mergeAlternately2() {
        String word1 = "ab";
        String word2 = "pqrs";
        String mergeAlternately = Q1768.mergeAlternately(word1, word2);

        Assertions.assertEquals(mergeAlternately, "apbqrs");
    }

    @Test
    void mergeAlternately3() {
        String word1 = "abcd";
        String word2 = "pq";
        String mergeAlternately = Q1768.mergeAlternately(word1, word2);

        Assertions.assertEquals(mergeAlternately, "apbqcd");
    }
}