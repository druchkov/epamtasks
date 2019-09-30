package collections.optinal;

import java.util.Stack;

public class CheckCorrectPlacementBrackets {
    public static boolean isCorrectPlacementBrackets(String string) {
        if (string.length() < 2) {
            return false;
        }
        Stack<Character> brackets = new Stack<>();
        for (int i = 0; i < string.length(); i++) {
            Character bracket = string.charAt(i);
            if (bracket == '(' || bracket == '[' || bracket == '{') {
                brackets.push(bracket);
            }
            if (bracket == ')' || bracket == ']' || bracket == '}') {
                if (brackets.empty()) {
                    return false;
                }
                Character topStack = brackets.pop();
                if (!(bracket == ')' && topStack == '('
                        || bracket == ']' && topStack == '['
                        || bracket == '}' && topStack == '{')) {
                    return false;
                }
            }
        }
        return brackets.isEmpty();
    }
}
