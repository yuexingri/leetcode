//给定一个二进制矩阵 A，我们想先水平翻转图像，然后反转图像并返回结果。 
//
// 水平翻转图片就是将图片的每一行都进行翻转，即逆序。例如，水平翻转 [1, 1, 0] 的结果是 [0, 1, 1]。 
//
// 反转图片的意思是图片中的 0 全部被 1 替换， 1 全部被 0 替换。例如，反转 [0, 1, 1] 的结果是 [1, 0, 0]。 
//
// 
//
// 示例 1： 
//
// 
//输入：[[1,1,0],[1,0,1],[0,0,0]]
//输出：[[1,0,0],[0,1,0],[1,1,1]]
//解释：首先翻转每一行: [[0,1,1],[1,0,1],[0,0,0]]；
//     然后反转图片: [[1,0,0],[0,1,0],[1,1,1]]
// 
//
// 示例 2： 
//
// 
//输入：[[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
//输出：[[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
//解释：首先翻转每一行: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]]；
//     然后反转图片: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length = A[0].length <= 20 
// 0 <= A[i][j] <= 1 
// 
// Related Topics 数组 
// 👍 217 👎 0

package leetcode.editor.cn;
//java:翻转图像
public class P832FlippingAnImage{
    
    public static void main(String[] args){
        Solution solution = new P832FlippingAnImage().new Solution();
        //[1,1,0],[1,0,1],[0,0,0]
        //[[1,0,0],[0,1,0],[1,1,1]]
        int[][] a = {
                {1, 1, 0},
                {1, 0, 1},
                {0, 0, 0}
        };
        int[][] ints = solution.flipAndInvertImage(a);
        System.out.println();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        int row = A.length;
        int column = A[0].length;
        for (int i = 0; i < row; i++) {
            int[] line = A[i];
            int left = 0;
            int right = column - 1;
            while (left < right) {
                int tmp = line[left];
                line[left] = line[right];
                line[right] = tmp;
                left++;
                right--;
            }
            for (int j = 0; j < column; j++) {
                line[j] = line[j] ^ 1;
            }
        }
        return A;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}