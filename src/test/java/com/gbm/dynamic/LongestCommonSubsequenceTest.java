package com.gbm.dynamic;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class LongestCommonSubsequenceTest {


    @Test
    public void testLongestCommonSubsequenceFosh() {
        var dictionary = Set.of("fish", "fort");
        var result = new LongestCommonSubsequence(dictionary).find("fosh");
        assertEquals("fish", result.word);
        assertEquals(3, result.sequenceLength);
    }

    @Test
    public void testLongestCommonSubsequenceBush() {
        var dictionary = Set.of("fish", "gosh","fort", "kesh","bash");
        var result = new LongestCommonSubsequence(dictionary).find("bush");
        assertEquals("bash", result.word);
        assertEquals(3, result.sequenceLength);
    }

    @Test
    public void testLongestCommonSubsequenceNull() {
        var dictionary = Set.of("fish", "gosh","fort", "kesh","bash");
        var result = new LongestCommonSubsequence(dictionary).find("clue");
        assertNull(result);
    }

}
