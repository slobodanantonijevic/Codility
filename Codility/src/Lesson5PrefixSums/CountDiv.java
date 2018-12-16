package Lesson5PrefixSums;

public class CountDiv {

    public int solution(int A, int B, int K) {

        int firstDivisible = -1;
        if (K == 1) { // if K is 1, all of the ints are divisible by it in range

            return B - A + 1; // return ALL of them, no need to process anything
        }

        // In case K is greater than 1, find the first one in range that is divisible by K
        for (int i = A; i <= B; i++) {

            if (i % K == 0) {

                firstDivisible = i;
                break;
            }
        }

        // in case we found at least one, >= 0 is ‘cause 0 % K (for any K) is always 0 (divisible)
        if (firstDivisible >= 0) {

            // every K-th (sort of speak) element after that in range is divisible by K
            return 1 + (B - firstDivisible) / K;
        }

        return 0;
    }
}

/**
 * Write a function:
 *
 * class Solution { public int solution(int A, int B, int K); }
 *
 * that, given three integers A, B and K, returns the number of integers within the range [A..B] that are divisible by K, i.e.:
 *
 * { i : A ≤ i ≤ B, i mod K = 0 }
 *
 * For example, for A = 6, B = 11 and K = 2, your function should return 3, because there are three numbers divisible by 2 within the range [6..11], namely 6, 8 and 10.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * A and B are integers within the range [0..2,000,000,000];
 * K is an integer within the range [1..2,000,000,000];
 * A ≤ B.
 */