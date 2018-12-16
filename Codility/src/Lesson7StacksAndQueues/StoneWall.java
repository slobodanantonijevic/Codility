package Lesson7StacksAndQueues;

import java.util.Stack;

public class StoneWall {

    /**
     * 100/100
     * @param H
     * @return
     */
    public int solution(int[] H) {

        int blocks = 0;
        Stack<Integer> stack = new Stack<Integer>();

        // main idea: need to use "stack" to check when we need a new block
        for (int i = 0; i < H.length; i++) {

            // step 1: "stack is not empty" AND "from high to low"
            // then, "pop" (it is the key point, be careful)
            while (!stack.isEmpty() && stack.peek() > H[i]) {

                stack.pop();
            }

            // step 2: if the stack is empty
            if (stack.isEmpty()) {

                blocks++;     // add a block
                stack.push(H[i]);  // push the height
            } else if (stack.peek() < H[i]) { //step 3: from low to high

                blocks++;    // add a block
                stack.push(H[i]); // push the height
            }
        }
        return blocks;
    }
}

// Inspiration: https://github.com/Mickey0521/Codility/blob/master/StoneWall.java

/**
 * You are going to build a stone wall. The wall should be straight and N meters long, and its thickness should be constant; however, it should have different heights in different places. The height of the wall is specified by an array H of N positive integers. H[I] is the height of the wall from I to I+1 meters to the right of its left end. In particular, H[0] is the height of the wall's left end and H[N−1] is the height of the wall's right end.
 *
 * The wall should be built of cuboid stone blocks (that is, all sides of such blocks are rectangular). Your task is to compute the minimum number of blocks needed to build the wall.
 *
 * Write a function:
 *
 * class Solution { public int solution(int[] H); }
 *
 * that, given an array H of N positive integers specifying the height of the wall, returns the minimum number of blocks needed to build it.
 *
 * For example, given array H containing N = 9 integers:
 *
 *   H[0] = 8    H[1] = 8    H[2] = 5
 *   H[3] = 7    H[4] = 9    H[5] = 8
 *   H[6] = 7    H[7] = 4    H[8] = 8
 * the function should return 7. The figure shows one possible arrangement of seven blocks.
 *
 *
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [1..100,000];
 * each element of array H is an integer within the range [1..1,000,000,000].
 */