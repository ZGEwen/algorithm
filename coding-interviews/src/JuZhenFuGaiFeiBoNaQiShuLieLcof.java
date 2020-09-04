//我们可以用 2*1 的小矩形横着或者竖着去覆盖更大的矩形。请问用 n 个 2*1 的小矩形无重叠地覆盖一个 2*n 的大矩形，总共有多少种方法？
// https://www.nowcoder.com/practice/72a5a919508a4251859fb2cfb987a0e6?tpId=13&tqId=11163&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
//比如n=3时，2*3的矩形块有3种覆盖方法：
//参考题解：https://cyc2018.github.io/CS-Notes/#/notes/10.2%20%E7%9F%A9%E5%BD%A2%E8%A6%86%E7%9B%96
// 矩阵覆盖斐波那契数列
public class JuZhenFuGaiFeiBoNaQiShuLieLcof {
    public static void main(String[] args) {
        Solution solution = new JuZhenFuGaiFeiBoNaQiShuLieLcof().new Solution();
        System.out.println(solution.RectCover(3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //当 n 为 1 时，只有一种覆盖方法，当 n 为 2 时，有两种覆盖方法
        //要覆盖 2*n 的大矩形，可以先覆盖 2*1 的矩形，再覆盖 2*(n-1) 的矩形；或者先覆盖 2*2 的矩形，再覆盖 2*(n-2) 的矩形。而覆盖 2*(n-1) 和 2*(n-2) 的矩形可以看成子问题
        public int RectCover(int n) {
            if (n <= 2)
                return n;
            int pre2 = 1, pre1 = 2;
            int result = 0;
            for (int i = 3; i <= n; i++) {
                result = pre2 + pre1;
                pre2 = pre1;
                pre1 = result;
            }
            return result;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
