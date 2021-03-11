//实现一个基本的计算器来计算一个简单的字符串表达式 s 的值。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "1 + 1"
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：s = " 2-1 + 2 "
//输出：3
// 
//
// 示例 3： 
//
// 
//输入：s = "(1+(4+5+2)-3)+(6+8)"
//输出：23
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 3 * 105 
// s 由数字、'+'、'-'、'('、')'、和 ' ' 组成 
// s 表示一个有效的表达式 
// 
// Related Topics 栈 数学 
// 👍 434 👎 0

package leetcode.editor.cn;

import java.util.Stack;

//java:基本计算器
public class P224BasicCalculator{
    
    public static void main(String[] args){
        Solution solution = new P224BasicCalculator().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int calculate(String s) {
        StringBuilder builder = new StringBuilder();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c == ' ' || c == '(' || c == ')') {
                continue;
            }
            builder.append(c);
        }
        String trimed = builder.toString();

        int ans = trimed.charAt(0) - '0';

        for (int i = 1; i < trimed.length(); i += 2) {
            char flag = trimed.charAt(i);
            char num = trimed.charAt(i + 1);
            if (flag == '-') {
                ans -= (num - '0');
            } else {
                ans += (num + '0');
            }
        }

        return ans;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}