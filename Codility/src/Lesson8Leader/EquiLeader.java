package Lesson8Leader;

public class EquiLeader {

    public int solution(int[] A) {

        int N = A.length;
        int count = 1;
        int candidate = A[0];

        // 1. Find a candidate, note: if there is a leader it will for sure be candidate
        for (int i = 1; i < N; i++) {

            if (count == 0) candidate = A[i];
            if (A[i] == candidate) {

                count++;
            } else {

                count--;
            }
        }

        // 2. Check if candidate is a leader?
        count = 0;
        // Count how many times a candidate appears
        for (int i = 0; i < N; i++) {

            if (candidate == A[i]) count++;
        }
        // If it appears less than half there is no solution, return 0
        if (count < N / 2) return 0;

        // 3. Count EquiLeaders
        int countLeft = 0;
        int countRight = count;
        int equiLeaders = 0;
        for (int i = 0; i < N; i++) {

            if (A[i] == candidate) {

                countLeft++;
                countRight--;
            }

            if (countLeft > (i + 1) / 2
                    && countRight > (N - i - 1) / 2) {

                equiLeaders++;
            }
        }

        return equiLeaders;
    }
}

/**
 * A non-empty array A consisting of N integers is given.
 *
 * The leader of this array is the value that occurs in more than half of the elements of A.
 *
 * An equi leader is an index S such that 0 ≤ S < N − 1 and two sequences A[0], A[1], ..., A[S] and A[S + 1], A[S + 2], ..., A[N − 1] have leaders of the same value.
 *
 * For example, given array A such that:
 *
 *     A[0] = 4
 *     A[1] = 3
 *     A[2] = 4
 *     A[3] = 4
 *     A[4] = 4
 *     A[5] = 2
 * we can find two equi leaders:
 *
 * 0, because sequences: (4) and (3, 4, 4, 4, 2) have the same leader, whose value is 4.
 * 2, because sequences: (4, 3, 4) and (4, 4, 2) have the same leader, whose value is 4.
 * The goal is to count the number of equi leaders.
 *
 * Write a function:
 *
 * class Solution { public int solution(int[] A); }
 *
 * that, given a non-empty array A consisting of N integers, returns the number of equi leaders.
 *
 * For example, given:
 *
 *     A[0] = 4
 *     A[1] = 3
 *     A[2] = 4
 *     A[3] = 4
 *     A[4] = 4
 *     A[5] = 2
 * the function should return 2, as explained above.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [1..100,000];
 * each element of array A is an integer within the range [−1,000,000,000..1,000,000,000].
 */