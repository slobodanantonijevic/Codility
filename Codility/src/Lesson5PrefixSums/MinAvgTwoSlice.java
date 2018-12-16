package Lesson5PrefixSums;

public class MinAvgTwoSlice {

    /**
     * 100/100
     * @param A
     * @return
     */
    public int solution(int[] A) {

        int[] prefixSums = getPrefixSums(A);

        float minAvg = Float.MAX_VALUE;
        int minPos = 0;

        for (int i = 0; i < A.length; i++) {

            if (i < A.length - 1) {

                float avg = (prefixSums[i + 2] - prefixSums[i]) / 2.0f; //((i + 1) - i) + 1 = 2
                if (avg < minAvg) {

                    minAvg = avg;
                    minPos = i;
                }
            }

            if (i < A.length - 2) {

                float avg = (prefixSums[i + 3] - prefixSums[i]) / 3.0f; //((i + 2) - i) + 1 = 3
                if (avg < minAvg) {

                    minAvg = avg;
                    minPos = i;
                }
            }
        }

        return minPos;
    }

    public int[] getPrefixSums(int[] A) {

        int[] prefixSums = new int[A.length + 1];
        for (int i = 0; i < A.length; i++) {

            prefixSums[i + 1] = prefixSums[i] + A[i];
        }

        return prefixSums;
    }

}

// Logic from: https://codesays.com/2014/solution-to-min-avg-two-slice-by-codility/
// Helper solution: https://gist.github.com/arielm/b2b38a01185a816cf27fba2ae6467129

/**
 * A non-empty array A consisting of N integers is given. A pair of integers (P, Q), such that 0 ≤ P < Q < N, is called a slice of array A (notice that the slice contains at least two elements). The average of a slice (P, Q) is the sum of A[P] + A[P + 1] + ... + A[Q] divided by the length of the slice. To be precise, the average equals (A[P] + A[P + 1] + ... + A[Q]) / (Q − P + 1).
 *
 * For example, array A such that:
 *
 *     A[0] = 4
 *     A[1] = 2
 *     A[2] = 2
 *     A[3] = 5
 *     A[4] = 1
 *     A[5] = 5
 *     A[6] = 8
 * contains the following example slices:
 *
 * slice (1, 2), whose average is (2 + 2) / 2 = 2;
 * slice (3, 4), whose average is (5 + 1) / 2 = 3;
 * slice (1, 4), whose average is (2 + 2 + 5 + 1) / 4 = 2.5.
 * The goal is to find the starting position of a slice whose average is minimal.
 *
 * Write a function:
 *
 * class Solution { public int solution(int[] A); }
 *
 * that, given a non-empty array A consisting of N integers, returns the starting position of the slice with the minimal average. If there is more than one slice with a minimal average, you should return the smallest starting position of such a slice.
 *
 * For example, given array A such that:
 *
 *     A[0] = 4
 *     A[1] = 2
 *     A[2] = 2
 *     A[3] = 5
 *     A[4] = 1
 *     A[5] = 5
 *     A[6] = 8
 * the function should return 1, as explained above.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [2..100,000];
 * each element of array A is an integer within the range [−10,000..10,000].
 */