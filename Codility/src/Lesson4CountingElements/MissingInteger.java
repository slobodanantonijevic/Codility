package Lesson4CountingElements;

import java.util.Arrays;

public class MissingInteger {

    /**
     * 100/100
     * @param A
     * @return
     */
    public int solution(int[] A) {

        int smallest = 1;

        Arrays.sort(A);
        for (int i = 0; i < A.length; i++) {

            if (A[i] > 0 && A[i] == smallest) {

                smallest++;
            } else if (A[i] > smallest) {

                return smallest;
            }
        }

        return smallest;
    }
}

/**
 *
 */