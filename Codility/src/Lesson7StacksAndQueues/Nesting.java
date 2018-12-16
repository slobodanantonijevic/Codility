package Lesson7StacksAndQueues;

import java.util.Stack;

public class Nesting {

    /**
     * 100/100
     * @param S
     * @return
     */
    public int solution(String S) {

        if (S.length() == 0) return 1;
        if (S.length() % 2 != 0) return 0;

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < S.length(); i++) {

            char character = S.charAt(i);

            if (character == ')') {

                if (!stack.isEmpty() && stack.peek() == '(') {

                    stack.pop();
                } else {

                    return 0;
                }
            } else {

                stack.push(character);
            }

        }

        if (stack.size() == 0) {

            return 1;
        }

        return 0;
    }

}

/**
 * A string S consisting of N characters is called properly nested if:
 *
 * S is empty;
 * S has the form "(U)" where U is a properly nested string;
 * S has the form "VW" where V and W are properly nested strings.
 * For example, string "(()(())())" is properly nested but string "())" isn't.
 *
 * Write a function:
 *
 * class Solution { public int solution(String S); }
 *
 * that, given a string S consisting of N characters, returns 1 if string S is properly nested and 0 otherwise.
 *
 * For example, given S = "(()(())())", the function should return 1 and given S = "())", the function should return 0, as explained above.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [0..1,000,000];
 * string S consists only of the characters "(" and/or ")".
 */