package leetcode.editor.cn;
//请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
//
//
//
// 示例 1：
//
// 输入：s = "We are happy."
//输出："We%20are%20happy."
//
//
//
// 限制：
//
// 0 <= s 的长度 <= 10000
// 👍 39 👎 0

// 替换空格
public class TiHuanKongGeLcof {
    public static void main(String[] args) {
        Solution solution = new TiHuanKongGeLcof().new Solution();
        solution.replaceSpace("We are happy.");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //先计算长度，再从后向前复制，复杂度O(n)
        public String replaceSpace(String s) {
            // return s.replaceAll(" ","%20");
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == ' ') sb.append("%20");
                else sb.append(c);
            }
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
