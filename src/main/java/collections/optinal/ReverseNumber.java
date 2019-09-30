package collections.optinal;

import java.util.Stack;

public class ReverseNumber {
    public String reverseNumber(String string) {
        char[] chars = string.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            stack.push(chars[i]);
        }
        String reversNumber = "";
        while(!stack.isEmpty()) {
            reversNumber += stack.pop();
        }
        return reversNumber;
    }
}
