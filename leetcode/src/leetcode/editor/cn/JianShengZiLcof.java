package leetcode.editor.cn;
//给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。
//请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18
//。
//
// 示例 1：
//
// 输入: 2
//输出: 1
//解释: 2 = 1 + 1, 1 × 1 = 1
//
// 示例 2:
//
// 输入: 10
//输出: 36
//解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
//
// 提示：
//
//
// 2 <= n <= 58
//
//
// 注意：本题与主站 343 题相同：https://leetcode-cn.com/problems/integer-break/
// Related Topics 数学 动态规划
// 👍 105 👎 0

// 剪绳子
public class JianShengZiLcof {
    public static void main(String[] args) {
        Solution solution = new JianShengZiLcof().new Solution();
        System.out.println(solution.cuttingRope(10));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int cuttingRope(int n) {
            // 长度为i的剪出来各段乘积的最大值
            int[] dp = new int[n + 1];
            dp[1] = 1;
            // 长度为i，从小到大开始计算
            for (int i = 2; i <= n; i++) {
                int max = 0;
                // 第一刀可能切的长度为j，i/2时全部可能就能够覆盖
                for (int j = 1; j <= i / 2; j++) {
                    // 这时，1.左右都能拆分 dp[i] =dp[j]*dp[i-j]
                    // 2.都不能拆分 dp[i]=j*(i-j);
                    // 3.左侧不能拆分 dp[i]=j*dp[i-j]
                    // 4.右侧不能拆分 dp[i] =dp[j]*(i-j)
                    // dp[i]取上述4种中的最大值
                    int pr = dp[j] * dp[i - j];
                    if (pr > max)
                        max = pr;
                    if (max < j * (i - j))
                        max = j * (i - j);
                    if (max < j * dp[i - j])
                        max = j * dp[i - j];
                    if (max < dp[j] * (i - j))
                        max = dp[j] * (i - j);
                }
                dp[i] = max;
            }
            return dp[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
