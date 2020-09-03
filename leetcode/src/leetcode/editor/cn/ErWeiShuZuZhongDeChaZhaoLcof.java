package leetcode.editor.cn;
//在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，
//判断数组中是否含有该整数。
//
//
//
// 示例:
//
// 现有矩阵 matrix 如下：
//
// [
//  [1,   4,  7, 11, 15],
//  [2,   5,  8, 12, 19],
//  [3,   6,  9, 16, 22],
//  [10, 13, 14, 17, 24],
//  [18, 21, 23, 26, 30]
//]
//
//
// 给定 target = 5，返回 true。
//
// 给定 target = 20，返回 false。
//
//
//
// 限制：
//
// 0 <= n <= 1000
//
// 0 <= m <= 1000
//
//
//
// 注意：本题与主站 240 题相同：https://leetcode-cn.com/problems/search-a-2d-matrix-ii/
// Related Topics 数组 双指针
// 👍 133 👎 0

// 二维数组中的查找
public class ErWeiShuZuZhongDeChaZhaoLcof {
    public static void main(String[] args) {
        Solution solution = new ErWeiShuZuZhongDeChaZhaoLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean findNumberIn2DArray(int[][] matrix, int target) {
            if (matrix == null) {
                return false;
            }
            // 有序的二维数组，从左到右从上向下依次增加，与右上角(左下角)的值进行比较
            //  [1,   4,  7, 11, 15],
            //  [2,   5,  8, 12, 19],
            //  [3,   6,  9, 16, 22],
            //  [10, 13, 14, 17, 24],
            //  [18, 21, 23, 26, 30]
            int rows = matrix.length;
            if (rows == 0) {
                return false;
            }
            int columns = matrix[0].length;
            //target < 15 移除15所在的列; target > 15 移除15所在的行
            for (int row = 0, col = columns - 1; row < rows && col >= 0; ) {
                // target = 15 返回
                if (matrix[row][col] == target) {
                    return true;
                } else if (matrix[row][col] > target) {
                    --col; // 划掉该列
                } else {
                    ++row; // 划掉该行
                }
            }
            // 全部查找完成为查找到
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
