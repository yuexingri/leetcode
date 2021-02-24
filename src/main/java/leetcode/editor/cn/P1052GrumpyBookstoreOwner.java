//今天，书店老板有一家店打算试营业 customers.length 分钟。每分钟都有一些顾客（customers[i]）会进入书店，所有这些顾客都会在那一分
//钟结束后离开。 
//
// 在某些时候，书店老板会生气。 如果书店老板在第 i 分钟生气，那么 grumpy[i] = 1，否则 grumpy[i] = 0。 当书店老板生气时，那一
//分钟的顾客就会不满意，不生气则他们是满意的。 
//
// 书店老板知道一个秘密技巧，能抑制自己的情绪，可以让自己连续 X 分钟不生气，但却只能使用一次。 
//
// 请你返回这一天营业下来，最多有多少客户能够感到满意的数量。 
// 
//
// 示例： 
//
// 输入：customers = [1,0,1,2,1,1,7,5], grumpy = [0,1,0,1,0,1,0,1], X = 3
//输出：16
//解释：
//书店老板在最后 3 分钟保持冷静。
//感到满意的最大客户数量 = 1 + 1 + 1 + 1 + 7 + 5 = 16.
// 
//
// 
//
// 提示： 
//
// 
// 1 <= X <= customers.length == grumpy.length <= 20000 
// 0 <= customers[i] <= 1000 
// 0 <= grumpy[i] <= 1 
// 
// Related Topics 数组 Sliding Window 
// 👍 88 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

//java:爱生气的书店老板
public class P1052GrumpyBookstoreOwner{
    
    public static void main(String[] args){
        Solution solution = new P1052GrumpyBookstoreOwner().new Solution();
//        int[] c = {1,0,1,2,1,1,7,5};
        int[] c = {5, 8};
//        int[] g = {0,1,0,1,0,1,0,1};
        int[] g = {0,1};
//        int x = 3;
        int x = 1;
        int i = solution.maxSatisfied(c, g, x);
        System.out.println();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int len = customers.length;
        if (len <= X) {
            return Arrays.stream(customers).sum();
        }
        Queue<int[]> queue = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]);
        int max = 0;
        for (int i = 0; i < X - 1; i++) {
            if (grumpy[i] == 1) {
                queue.offer(new int[] {i, customers[i]});
                max += customers[i];
            }
        }
        int left = 0;
        int right = X - 1;
        int cur = max;
        while (right < len) {

            if (!queue.isEmpty() && queue.peek()[0] < left) {
                int[] poll = queue.poll();
                cur -= poll[1];
            }
            if (grumpy[right] == 1) {
                cur += customers[right];
                queue.offer(new int[] {right, customers[right]});
            }

            max = Math.max(max, cur);

            left++;
            right++;
        }

        for (int i = 0; i < len; i++) {
            max += (grumpy[i] == 0 ? customers[i] : 0);
        }

        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}