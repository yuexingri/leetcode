public class Matcher {
    public static void main(String[] args) {
        System.out.println(isMatch("abc", "a*bc"));
        System.out.println(isMatch("ac", "a*c"));
    }

    public static boolean isMatch(String s, String p) {
        if (s.equals(p)) {
            return true;
        }
        boolean isFirstMatched = false;
        if (!s.isEmpty() && !p.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')) {
            isFirstMatched = true;
        }

        if (!s.isEmpty() && !p.isEmpty() && p.length() > 2 && p.charAt(1) == '*') {
            return isMatch(s, p.substring(2)) || (isFirstMatched && isMatch(s.substring(1), p));
        }

        return isFirstMatched && isMatch(s.substring(1), p.substring(1));
    }
}
