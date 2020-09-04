//一只青蛙一次可以跳上 1 级台阶，也可以跳上 2 级... 它也可以跳上 n 级。求该青蛙跳上一个 n 级的台阶总共有多少种跳法
//https://www.nowcoder.com/practice/22243d016f6b47f2a6928b4313c85387?tpId=13&tqId=11162&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking

//题解参考：https://cyc2018.github.io/CS-Notes/#/notes/10.4%20%E5%8F%98%E6%80%81%E8%B7%B3%E5%8F%B0%E9%98%B6

// 变态青蛙跳台阶问题
public class BTQingWaTiaoTaiJieWenTiLcof {
    public static void main(String[] args) {
        Solution solution = new BTQingWaTiaoTaiJieWenTiLcof().new Solution();
        System.out.println(solution.JumpFloorII(3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //n=1,f(1)=1;n=2,f(2)=2;
        //跳上 n-1 级台阶，可以从 n-2 级跳 1 级上去，也可以从 n-3 级跳 2 级上去...，f(n-1) = f(n-2) + f(n-3) + ... + f(0)
        //跳上 n 级台阶，可以从 n-1 级跳 1 级上去，也可以从 n-2 级跳 2 级上去... f(n) = f(n-1) + f(n-2) + ... + f(0)
        //f(n) = 2*f(n-1)，等比数列，第n项 f(n)=2^(n-1)
        public int JumpFloorII(int n) {
            return (int) Math.pow(2, n - 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
