//给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。 
//
// 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。 
//
// 注意: 
//假设字符串的长度不会超过 1010。 
//
// 示例 1: 
//
// 
//输入:
//"abccccdd"
//
//输出:
//7
//
//解释:
//我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
// 
// Related Topics 哈希表 
// 👍 275 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

//java:最长回文串
public class P409LongestPalindrome{
    
    public static void main(String[] args){
        Solution solution = new P409LongestPalindrome().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestPalindrome(String s) {
        int len = s.length();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            Integer count = map.getOrDefault(c, 0);
            map.put(c, count + 1);
        }

        int ans = 0;

        boolean flag = false;

        for (Integer value : map.values()) {
            ans += value / 2 * 2;
            if (!flag && value % 2 == 1) {
                flag = true;
            }
        }

        return flag ? ans + 1 : ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}