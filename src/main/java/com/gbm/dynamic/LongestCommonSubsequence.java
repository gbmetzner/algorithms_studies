package com.gbm.dynamic;

import java.util.ArrayList;
import java.util.Set;

import static java.lang.Math.max;
import static java.util.Comparator.comparingInt;

public class LongestCommonSubsequence {

    private final Set<String> dictionary;

    public LongestCommonSubsequence(Set<String> dictionary) {
        this.dictionary = dictionary;
    }

    public Result find(String word) {

        var results = new ArrayList<Result>();

        for (var s : dictionary) {

            var wordGrid = new int[word.length()][word.length()];

            for (var i = 0; i < word.length(); i++) {
                for (var j = 0; j < s.length(); j++) {
                    if (word.charAt(i) == s.charAt(j)) {
                        wordGrid[i][j] = 1; // letters matched set to 1
                        if (i > 0 && j > 0) {
                            wordGrid[i][j] = wordGrid[i - 1][j - 1] + 1;
                        }
                    } else {
                        wordGrid[i][j] = 0; // letters didn't match set to 0
                        if (i == 0 && j > 0) {
                            wordGrid[i][j] = wordGrid[i][j - 1];
                        } else if (i > 0 && j == 0) {
                            wordGrid[i][j] = wordGrid[i - 1][j];
                        } else if (i > 0) {
                            wordGrid[i][j] = max(wordGrid[i - 1][j], wordGrid[i][j - 1]);
                        }
                    }
                }
            }

            results.add(new Result(s, wordGrid[s.length() - 1][s.length() - 1]));
        }

        return results.stream()
                .max(comparingInt(r -> r.sequenceLength))
                .filter(r -> r.sequenceLength > 1)
                .orElse(null);
    }


    public static class Result {

        public final String word;
        public final int sequenceLength;

        public Result(String word, int length) {
            this.word = word;
            this.sequenceLength = length;
        }
    }
}
