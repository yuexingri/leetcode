//给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是回文。 
//
// 返回符合要求的 最少分割次数 。 
//
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：s = "aab"
//输出：1
//解释：只需一次分割就可将 s 分割成 ["aa","b"] 这样两个回文子串。
// 
//
// 示例 2： 
//
// 
//输入：s = "a"
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：s = "ab"
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 2000 
// s 仅由小写英文字母组成 
// 
// 
// 
// Related Topics 动态规划 
// 👍 286 👎 0

package leetcode.editor.cn;
//java:分割回文串 II
public class P132PalindromePartitioningIi{
    
    public static void main(String[] args){
        Solution solution = new P132PalindromePartitioningIi().new Solution();
        String str1 = "aab";
        String str2 = "a";
        String str3 = "ab";
        int i = solution.minCut(str1);
        int j = solution.minCut(str2);
        int k = solution.minCut(str3);
        System.out.println();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minCut(String s) {

        if (s == null || s.length() < 2) {
            return 0;
        }

        int len = s.length();
        int[] dp = new int[len];
        dp[0] = 0;
        for (int i = 1; i < len; i++) {
            int times = Integer.MAX_VALUE;
            for (int j = 0; j <= i; j++) {
                String str = s.substring(j, i + 1);
                boolean isPara = isPara(str);
                if (j == 0 && isPara) {
                    times = -1;
                    break;
                } else if (isPara) {
                    times = Math.min(times, dp[j - 1]);
                }
            }
            dp[i] = times + 1;
        }

        return dp[len - 1];
    }


    private boolean isPara(String str) {
        int len = str.length();
        int left = 0;
        int right = len - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}