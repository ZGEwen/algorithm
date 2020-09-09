package leetcode.editor.cn;
//给定一个二维网格和一个单词，找出该单词是否存在于网格中。
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
//
//
//
// 示例:
//
// board =
//[
//  ['A','B','C','E'],
//  ['S','F','C','S'],
//  ['A','D','E','E']
//]
//
//给定 word = "ABCCED", 返回 true
//给定 word = "SEE", 返回 true
//给定 word = "ABCB", 返回 false
//
//
//
// 提示：
//
//
// board 和 word 中只包含大写和小写英文字母。
// 1 <= board.length <= 200
// 1 <= board[i].length <= 200
// 1 <= word.length <= 10^3
//
// Related Topics 数组 回溯算法
// 👍 548 👎 0

// 单词搜索
public class WordSearch {
    public static void main(String[] args) {
        Solution solution = new WordSearch().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //用于标记是否已经找到了解
        private boolean flag;

        public boolean exist(char[][] board, String word) {
            if (board == null || board.length == 0 || board[0].length == 0) {
                return false;
            }
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (dfs(board, i, j, word, 0)) {
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean dfs(char[][] board, int i, int j, String word, int cur) {
            if (cur == word.length()) {
                flag = true;
                return true;
            }
            if (i < 0 || i >= board.length || j < 0 || j >= board[0].length
                    || board[i][j] != word.charAt(cur)) {
                return false;
            }
            //如果没有找到解，则继续DFS
            if (!flag) {
                char c = board[i][j];
                board[i][j] = '.';
                boolean ret1 = dfs(board, i + 1, j, word, cur + 1);
                boolean ret2 = dfs(board, i - 1, j, word, cur + 1);
                boolean ret3 = dfs(board, i, j + 1, word, cur + 1);
                boolean ret4 = dfs(board, i, j - 1, word, cur + 1);
                board[i][j] = c;
                return ret1 || ret2 || ret3 || ret4;
            } else {
                //找到解了，直接结束DFS并返回，这就是剪枝
                return true;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
