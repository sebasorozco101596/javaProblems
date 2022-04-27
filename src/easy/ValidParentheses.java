package easy;

import java.util.ArrayList;
import java.util.Stack;

// 20. Valid Parentheses
public class ValidParentheses {

    public boolean isValid(String s) {

        boolean isValid = true;
        ArrayList<Character> opens = new ArrayList<>();

        for ( int i = 0; i < s.length(); i++ ) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' ||s.charAt(i) == '[' ) {
                opens.add(s.charAt(i));
            } else {
                if (opens.size() > 0) {
                    if (s.charAt(i) != haveToBe(opens.get(opens.size() - 1))) {
                        isValid = false;
                        break;
                    } else {
                        opens.remove(opens.size() - 1);
                    }
                } else {
                    isValid = false;
                }
            }
        }

        if (opens.size() > 0) {
            isValid = false;
        }

        return isValid;
    }

    public char haveToBe(char parenthesis) {
        switch (parenthesis) {
            case '(' -> {
                return ')';
            }
            case '{' -> {
                return '}';
            }
            case '[' -> {
                return ']';
            }
            default -> {
                return '.';
            }
        }
    }


    // Optimal Solution
    public boolean isValidOptimal(String s) {
        char[] arr = new char[s.length()];
        int ptr = -1;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                arr[++ptr] = c;
            } else {
                char opening = ' ';
                if (c == ')') {
                    opening = '(';
                } else if (c == '}') {
                    opening = '{';
                } else if (c == ']') {
                    opening = '[';
                } else {
                    return false;
                }
                if (ptr ==-1 || arr[ptr] != opening) {
                    return false;
                }

                ptr--;
            }
        }
        if (ptr >= 0) {
            return false;
        }
        return true;

    }


    // Using Stack
    public boolean isValidWithStack(String s) {
        Stack<Character> stack = new Stack<Character>();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                if (c == '(')
                    stack.push(')');
                if (c == '{')
                    stack.push('}');
                if (c == '[')
                    stack.push(']');
            }
            else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    if (c != stack.pop()) {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
}
