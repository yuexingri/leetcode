import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {
        String s = "(]";
        System.out.println(isValidate(s));
    }

    public static boolean isValidate(String s) {
        Stack<Character> parentheses = new Stack<Character>();
        if (s == null) {
            return false;
        }
        char[] array = s.toCharArray();
        for (char c: array) {
            if (c == '{' || c == '[' || c == '(') {
                parentheses.push(c);
            }
            if (c == '}' || c == ']' || c == ')') {
                if (parentheses.isEmpty()) {
                    return false;
                }
                Character popedChar = parentheses.pop();
                if (popedChar == '{' && c != '}') {
                    return false;
                }
                if (popedChar == '[' && c != ']') {
                    return false;
                }
                if (popedChar == '(' && c != ')') {
                    return false;
                }
            }
            continue;
        }
        return parentheses.isEmpty();
    }
}
