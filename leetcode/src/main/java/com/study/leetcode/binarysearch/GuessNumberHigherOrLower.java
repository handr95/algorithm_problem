package com.study.leetcode.binarysearch;

/**
 * 374. Guess Number Higher or Lower
 * https://leetcode.com/problems/guess-number-higher-or-lower/description/
 * Easy
 * We are playing the Guess Game. The game is as follows:
 *
 * I pick a number from 1 to n. You have to guess which number I picked.
 *
 * Every time you guess wrong, I will tell you whether the number I picked is higher or lower than your guess.
 *
 * You call a pre-defined API int guess(int num), which returns three possible results:
 *
 * -1: Your guess is higher than the number I picked (i.e. num > pick).
 * 1: Your guess is lower than the number I picked (i.e. num < pick).
 * 0: your guess is equal to the number I picked (i.e. num == pick).
 * Return the number that I picked.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 10, pick = 6
 * Output: 6
 * Example 2:
 *
 * Input: n = 1, pick = 1
 * Output: 1
 * Example 3:
 *
 * Input: n = 2, pick = 1
 * Output: 1
 *
 *
 * Constraints:
 *
 * 1 <= n <= 231 - 1
 * 1 <= pick <= n
 */
public class GuessNumberHigherOrLower {

    private int pickNumber;
    public void setPick(int pickNumber) {
        this.pickNumber = pickNumber;
    }
    public int guessNumber(int n) {
        int start = 1;
        int end = n;
        while(true) {
            if (end - start == 1) {
                int guess = guess(start);
                if (guess == 0) {
                    return start;
                }
                guess = guess(end);
                if (guess == 0) {
                    return end;
                }
            }
            int middle = start + (end-start) / 2;
            int guess = guess(middle);
            if (guess == 0) {
                return middle;
            }
            if (guess == 1) {
                start = middle;
            } else {
                end = middle;
            }
        }
    }

    /**
     *
     * @param num your guess
     * @return -1 if num is higher than the picked number
     *          1 if num is lower than the picked number
     *      otherwise return 0
     */
    int guess(int num) {
        if (pickNumber < num) {
            return -1;
        } else if (pickNumber > num) {
            return 1;
        }
        return 0;
    }

}
