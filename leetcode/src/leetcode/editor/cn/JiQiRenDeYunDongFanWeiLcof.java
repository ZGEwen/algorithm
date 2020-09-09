package leetcode.editor.cn;
//地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一
//格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但
//它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
//
//
//
// 示例 1：
//
// 输入：m = 2, n = 3, k = 1
//输出：3
//
//
// 示例 2：
//
// 输入：m = 3, n = 1, k = 0
//输出：1
//
//
// 提示：
//
//
// 1 <= n,m <= 100
// 0 <= k <= 20
//
// 👍 151 👎 0

// 机器人的运动范围
public class JiQiRenDeYunDongFanWeiLcof {
    public static void main(String[] args) {
        Solution solution = new JiQiRenDeYunDongFanWeiLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int movingCount(int m, int n, int k) {
            boolean[][] visited = new boolean[m][n];
            return visit(0, 0, m, n, k, visited);
        }

        private int visit(int row, int col, int m, int n, int k, boolean[][] visited) {
            if (row < 0 || row >= m || col < 0 || col >= n || visited[row][col] || cal(row) + cal(col) > k) {
                return 0;
            }
            visited[row][col] = true;
            return 1 + visit(row - 1, col, m, n, k, visited) + visit(row + 1, col, m, n, k, visited) + visit(row, col+1, m, n, k, visited) + visit(row, col-1, m, n, k, visited);
        }

        /**
         * 计算数位和
         *
         * @param number
         * @return
         */
        private int cal(int number) {
            int s = 0;
            while (number > 0) {
                s = s + number % 10;
                number = number / 10;
            }
            return s;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
