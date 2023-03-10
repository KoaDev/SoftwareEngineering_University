package isp.lab2.Exercise6WordGuess;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WordGuessTest {

    @Test
    public void countOccurenceTest() {
        char c = 'a';
        char[] word = {'a', 'b', 'c', 'a', 'd', 'a'};
        int expected = 3;
        int actual = Exercise6WordGuess.countOccurence(c, word);
        assertEquals(expected, actual);
    }
}
