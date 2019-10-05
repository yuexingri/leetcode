import java.util.ArrayList;
import java.util.List;

public class PartitionPalindrome {

    public static void main(String[] args) {
        PartitionPalindrome partitionPalindrome = new PartitionPalindrome();
        partitionPalindrome.partition("aab");
        System.out.println(partitionPalindrome.res);
    }

    List<List<String>> res = new ArrayList<>();

    public List<List<String>> partition(String s) {
        if (s == null || s.length() == 0) {
            return res;
        }
        dfs(s, new ArrayList<String>(), 0);
        return res;
    }

    private void dfs(String s, List<String> remain, int left) {
        if (left == s.length()) {
            res.add(new ArrayList<String>(remain));
            return;
        }
        for (int right = left; right < s.length(); right++) {
            if (isPalindrome(s, left, right)) {
                remain.add(s.substring(left, right + 1));
                dfs(s, remain, right + 1);
                remain.remove(remain.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right && s.charAt(left) == s.charAt(right)) {
            left++;
            right--;
        }
        return left >= right;
    }

}
