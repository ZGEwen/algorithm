package test;//一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
//
// 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
//
// 示例 1：
//
// 输入：n = 2
//输出：2
//
//
// 示例 2：
//
// 输入：n = 7
//输出：21
//
//
// 示例 3：
//
// 输入：n = 0
//输出：1
//
// 提示：
//
//
// 0 <= n <= 100
//
//
// 注意：本题与主站 70 题相同：https://leetcode-cn.com/problems/climbing-stairs/
//
//
// Related Topics 递归
// 👍 63 👎 0

// 青蛙跳台阶问题
public class QingWaTiaoTaiJieWenTiLcof {
    public static void main(String[] args) {
        Solution solution = new QingWaTiaoTaiJieWenTiLcof().new Solution();
        System.out.println(solution.numWays(3));
        System.out.println(solution.numWays(4));
        System.out.println(solution.numWays(5));
        System.out.println(solution.numWays(6));
        System.out.println(solution.numWays(7));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //青蛙跳跃台阶，每次都有两种选择。调到n>2阶时，如果第一次跳1阶，这种情况下的总数为后边(n-1)的个数的总和
        //如果第一次跳2阶，这种情况下的总数为后边(n-3)的总和
        //因此，f(n) = f(n-1)+f(n-3)
        //n为跳跃次数
        public int numWays(int n) {
            int[] step = new int[n+1];
            if (n < 3) {
                return n;
            }
            step[0] = 1;
            step[1] = 1;
            step[2] = 2;

            for (int i = 3; i <= n; i++) {
                step[i]=(step[i-1]+step[i-3]) % 1000000007;
            }
            return step[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
