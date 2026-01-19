
/*
https://neetcode.io/problems/validate-parentheses/question?list=blind75
https://leetcode.com/problems/valid-parentheses/
Valid Parentheses
-----------------
You are given a string s consisting of the following characters: '(', ')', '{', '}', '[' and ']'.

The input string s is valid if and only if:

Every open bracket is closed by the same type of close bracket.
Open brackets are closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.
Return true if s is a valid string, and false otherwise.

Example 1:

Input: s = "[]"

Output: true
Example 2:

Input: s = "([{}])"

Output: true
Example 3:

Input: s = "[(])"

Output: false
Explanation: The brackets are not closed in the correct order.

Constraints:

1 <= s.length <= 1000

*/
package LeetcodeProblems;

// These imports are required for Map, Deque, and ArrayDeque
import java.util.Map;
import java.util.Deque;
import java.util.ArrayDeque;

public class ValidParenthesis {

    public boolean isValid(String s) {
        Map<Character, Character> bracketMapping = Map.of(
             '}', '{', 
             ']', '[',
             ')', '('
        );
        
        Deque<Character> order = new ArrayDeque<>();
        
        for (char c : s.toCharArray()) {
            if (bracketMapping.containsKey(c)) {
                if (!order.isEmpty() && order.peek() == bracketMapping.get(c)) {
                    order.pop();
                } else {
                    return false;
                }
            } else {
                order.push(c);
            }
        }
        return order.isEmpty();
    }

    // Adding a main method so you can run and test it immediately
    public static void main(String[] args) {
        ValidParenthesis solver = new ValidParenthesis();
        
        System.out.println(solver.isValid("()[]{}")); // Expected: true
        System.out.println(solver.isValid("(]"));     // Expected: false
        System.out.println(solver.isValid("([)]"));   // Expected: false
    }
}
