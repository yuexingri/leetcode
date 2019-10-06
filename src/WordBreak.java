import java.util.List;

public class WordBreak {

    public static void main(String[] args) {
        String s = "abc";
        System.out.println(s.substring(0, 1));
        System.out.println(s.substring(0, 2));
        System.out.println(s.substring(1, 2));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        int maxLength = 0;
        for (String dict : wordDict) {
            maxLength = maxLength > dict.length() ? maxLength : dict.length();
        }
        boolean[] memo = new boolean[n + 1];
        memo[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = i - 1; j >= 0 && maxLength >= i - j; j--) {
                if (memo[j] && wordDict.contains(s.substring(j, i))) {
                    memo[i] = true;
                    break;
                }
            }
        }
        return memo[n];
    }
}
