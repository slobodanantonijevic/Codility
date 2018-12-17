package Lesson9MaximumSliceProblem;

public class MaxSliceSum {

    /**
     * 100/100
     * Kadane's algorithm
     * @param A
     * @return
     */
    public int solution(int[] A) {

        int maxSlice = A[0];
        int maxEnding = A[0];

        /**
         * For each position, we compute the largest sum that ends in that position
         * If we assume that the maximum sum of a slice ending in position i equals maxEnding
         * then the maximum slice ending in position i equals max(A[i], maxEnding + A[i])
         * All this is basically an implementation of Kadane’s algorithm:
         * https://en.wikipedia.org/wiki/Maximum_subarray_problem#Kadane's_algorithm
         */
        for (int i = 1; i < A.length; i++) {

            maxEnding = Math.max(A[i], maxEnding + A[i]);
            maxSlice = Math.max(maxEnding, maxSlice);
        }

        return maxSlice;
    }

}

/**
 * A non-empty array A consisting of N integers is given. A pair of integers (P, Q), such that 0 ≤ P ≤ Q < N, is called a slice of array A. The sum of a slice (P, Q) is the total of A[P] + A[P+1] + ... + A[Q].
 *
 * Write a function:
 *
 * class Solution { public int solution(int[] A); }
 *
 * that, given an array A consisting of N integers, returns the maximum sum of any slice of A.
 *
 * For example, given array A such that:
 *
 * A[0] = 3  A[1] = 2  A[2] = -6
 * A[3] = 4  A[4] = 0
 * the function should return 5 because:
 *
 * (3, 4) is a slice of A that has sum 4,
 * (2, 2) is a slice of A that has sum −6,
 * (0, 1) is a slice of A that has sum 5,
 * no other slice of A has sum greater than (0, 1).
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [1..1,000,000];
 * each element of array A is an integer within the range [−1,000,000..1,000,000];
 * the result will be an integer within the range [−2,147,483,648..2,147,483,647].
 */