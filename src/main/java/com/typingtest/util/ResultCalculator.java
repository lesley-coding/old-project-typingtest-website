package com.typingtest.util;

import com.typingtest.po.Result;
import java.util.Collections;
import java.util.List;

/**
 * util class mainly for:
 * 1.calculating 2-factor-based score
 * 2.evaluate the user's performance
 * 3.evaluate if the result is a valid one;
 *
 */

public class ResultCalculator {
    private final static double SPEED_FACTOR = 0.7;
    private final static double ACC_FACTOR = 0.3;

    private final static int VALID_BOUND_ACC = 50;
    private final static int VALID_BOUND_CPM  = 20;

    // calculate  a score value based on both speed and  accuracy.
    public static int getScore(int cpm, int accuracy) {
        int score;
        if (accuracy >= 85) {
            score = (int) (cpm * SPEED_FACTOR + accuracy * ACC_FACTOR);
        } else {
            score = (int) (Math.sqrt(cpm) + ACC_FACTOR * accuracy);
        }
        return score;
    }

    public static double getBetterThanPercentage(List<Integer> scores, int currentUserScore) {
        Collections.sort(scores);
        int numOfSmallerScores = 0;

        for (int i = 0; i < scores.size(); i++) {
            if (scores.get(i) > currentUserScore) {
                numOfSmallerScores = i;
                break;
            } else if (i == scores.size() - 1) {
                numOfSmallerScores = i + 1;
                break;
            }
        }

        double percentage = (double) numOfSmallerScores / scores.size() * 100;
        return percentage;
    }

    public static boolean valid(Result result) {
        int cpm =result.getCpm();
        int acc = result.getAccuracy();

        if(cpm < VALID_BOUND_CPM|| acc < VALID_BOUND_ACC ){
            return false;
        }
        return true;
    }
}
