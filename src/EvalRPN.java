import java.util.Stack;

public class EvalRPN {
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
            return 0;
        }
        Stack<String> prn = new Stack<>();
        for (String c : tokens) {
            if (c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/")) {
                int a = Integer.parseInt(prn.pop());
                int b = Integer.parseInt(prn.pop());
                if (c.equals("+")) {
                    prn.push(String.valueOf(a + b));
                } else if (c.equals("-")) {
                    prn.push(String.valueOf(b - a));
                } else if (c.equals("*")) {
                    prn.push(String.valueOf(b * a));
                } else if (c.equals("/")) {
                    prn.push(String.valueOf(b / a));
                }
            } else {
                prn.push(c);
            }
        }
        return Integer.parseInt(prn.pop());
    }
}
