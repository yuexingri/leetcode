//给你一个二维整数数组 matrix， 返回 matrix 的 转置矩阵 。 
//
// 矩阵的 转置 是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[[1,4,7],[2,5,8],[3,6,9]]
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[1,2,3],[4,5,6]]
//输出：[[1,4],[2,5],[3,6]]
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 1000 
// 1 <= m * n <= 105 
// -109 <= matrix[i][j] <= 109 
// 
// Related Topics 数组 
// 👍 158 👎 0

package leetcode.editor.cn;
//java:转置矩阵
public class P867TransposeMatrix{
    
    public static void main(String[] args){
        Solution solution = new P867TransposeMatrix().new Solution();
        ////输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
        ////输出：[[1,4,7],[2,5,8],[3,6,9]]
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[][] transpose = solution.transpose(matrix);
        System.out.println();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] transpose(int[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;

        int[][] ans = new int[column][];
        int index = 0;
        for (int i = 0; i < column; i++) {
            int[] line = new int[row];
            for (int j = 0; j < row; j++) {
                line[j] = matrix[j][i];
            }
            ans[index++] = line;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}