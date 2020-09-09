package leetcode.editor.cn;
//请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。如果
//一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。
//
// [["a","b","c","e"],
//["s","f","c","s"],
//["a","d","e","e"]]
//
// 但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
//
//
//
// 示例 1：
//
// 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "A
//BCCED"
//输出：true
//
//
// 示例 2：
//
// 输入：board = [["a","b"],["c","d"]], word = "abcd"
//输出：false
//
//
// 提示：
//
//
// 1 <= board.length <= 200
// 1 <= board[i].length <= 200
//
//
// 注意：本题与主站 79 题相同：https://leetcode-cn.com/problems/word-search/
// Related Topics 深度优先搜索
// 👍 160 👎 0

// 矩阵中的路径
public class JuZhenZhongDeLuJingLcof {
    public static void main(String[] args) {
        Solution solution = new JuZhenZhongDeLuJingLcof().new Solution();
        solution.exist(new char[][]{{'a'},{'a'}},"aaa");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 深度优先搜索 DFS 通过递归，先朝一个方向搜到底，再回溯至上个节点，沿另一个方向搜索，以此类推
        public boolean exist(char[][] board, String word) {
            char[] words = word.toCharArray();
            // visited数组中保存着路径
            boolean[][] visited = new boolean[board.length][board[0].length];
            // 从board[0][0]开始
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    // i,j位置开始进行 深度优先搜索，搜索到就返回
                    if (dfs(board, visited, words, i, j, 0)) return true;
                }
            }
            return false;
        }

        /**
         * 深度优先搜索
         *
         * @param board  矩阵
         * @param words  字符串数组
         * @param curRow 当前行
         * @param curCol 当前列
         * @param wIndex 字符串数组下标
         * @return
         */
        private boolean dfs(char[][] board, boolean[][] visited, char[] words, int curRow, int curCol, int wIndex) {
            //边界的判断，如果越界直接返回false。index表示的是查找到字符串word的第几个字符，
            //如果这个字符不等于board[i][j]，说明验证这个坐标路径是走不通的，直接返回false
            if (curRow >= board.length || curRow < 0 ||  curCol >= board[0].length || curCol < 0 || visited[curRow][curCol] ||board[curRow][curCol] != words[wIndex])
                return false;
            //如果word的每个字符都查找完了，直接返回true
            if (wIndex == words.length - 1)
                return true;
            visited[curRow][curCol] = true;
            //走递归，沿着当前坐标的下 上 右 左 4个方向查找
            boolean res = dfs(board, visited, words, curRow + 1, curCol, wIndex + 1) || dfs(board, visited, words, curRow - 1, curCol, wIndex + 1) ||
                    dfs(board, visited, words, curRow, curCol + 1, wIndex + 1) || dfs(board, visited, words, curRow, curCol - 1, wIndex + 1);
            //当前结果
            visited[curRow][curCol] = res;
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
