//给定一些标记了宽度和高度的信封，宽度和高度以整数对形式 (w, h) 出现。当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如
//同俄罗斯套娃一样。 
//
// 请计算最多能有多少个信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。 
//
// 说明: 
//不允许旋转信封。 
//
// 示例: 
//
// 输入: envelopes = [[5,4],[6,4],[6,7],[2,3]]
//输出: 3 
//解释: 最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。
// 
// Related Topics 二分查找 动态规划 
// 👍 340 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;

//java:俄罗斯套娃信封问题
public class P354RussianDollEnvelopes{
    
    public static void main(String[] args){
        Solution solution = new P354RussianDollEnvelopes().new Solution();

//[[5,4],[6,4],[6,7],[2,3]]
        //
        int[][] envelopes = {
                {5, 4},
                {6, 4},
                {6, 7},
                {2, 3}
        };
        int i = solution.maxEnvelopes(envelopes);
        System.out.println();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int len = envelopes.length;
        int[] dp = new int[len];
        Arrays.fill(dp, 1);

        for (int i = 1; i < len; i++) {
            int[] a = envelopes[i];
            for (int j = 0; j < i; j++) {
                int[] b = envelopes[j];
                if (b[0] < a[0] && b[1] < a[1]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }

        }
        int max = 1;
        for (int i = 0; i < len; i++) {
            max = Math.max(dp[i], max);
        }

        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}