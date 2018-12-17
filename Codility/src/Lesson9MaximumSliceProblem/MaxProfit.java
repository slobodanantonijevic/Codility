package Lesson9MaximumSliceProblem;

public class MaxProfit {

    /**
     * 100/100
     * Check MaxSliceSum for explanation on Kadane's algorithm is applied here
     * @param A
     * @return
     */
    public int solution(int[] A) {

        if (A.length == 1 || A.length == 0) {
            return 0;
        }

        int maxSoFar = 0;
        int maxEndingHere = 0;
        int minPrice = A[0];
        for (int i = 1; i < A.length; i++) {

            maxEndingHere = Math.max(0, A[i] - minPrice);
            minPrice = Math.min(minPrice, A[i]);
            maxSoFar = Math.max(maxEndingHere, maxSoFar);
        }

        return maxSoFar;
    }
}

/**
 *
 */