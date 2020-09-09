package leetcode.editor.cn;
//请实现一个函数，输入一个整数，输出该数二进制表示中 1 的个数。例如，把 9 表示成二进制是 1001，有 2 位是 1。因此，如果输入 9，则该函数输出
//2。
//
// 示例 1：
//
// 输入：00000000000000000000000000001011
//输出：3
//解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
//
//
// 示例 2：
//
// 输入：00000000000000000000000010000000
//输出：1
//解释：输入的二进制串 00000000000000000000000010000000 中，共有一位为 '1'。
//
//
// 示例 3：
//
// 输入：11111111111111111111111111111101
//输出：31
//解释：输入的二进制串 11111111111111111111111111111101 中，共有 31 位为 '1'。
//
//
//
// 注意：本题与主站 191 题相同：https://leetcode-cn.com/problems/number-of-1-bits/
// Related Topics 位运算
// 👍 48 👎 0

// 二进制中1的个数
public class ErJinZhiZhong1deGeShuLcof {
    public static void main(String[] args) {
        Solution solution = new ErJinZhiZhong1deGeShuLcof().new Solution();
        int a=10;
        System.out.println(Integer.toBinaryString(10));
        System.out.println(1010==Integer.parseInt(Integer.toBinaryString(10)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    public class Solution {
        // you need to treat n as an unsigned value
        // 在某些语言（如 Java）中，没有无符号整数类型。在这种情况下，输入和输出都将被指定为有符号整数类型，并且不应影响您的实现，因为无论整数是有符号的还是无符号的，其内部的二进制表示形式都是相同的。
        // 在 Java 中，编译器使用二进制补码记法来表示有符号整数。
        // 来源：力扣（LeetCode）
        // 链接：https://leetcode-cn.com/problems/number-of-1-bits
        // 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
        public int hammingWeight(int n) {
            //将整数减1，再与原来的整数与运算，会把整数最右侧的1变为0，直到所有都变为0时，统计完成1的个数
            int count=0;
            while (n!=0){
                count++;
                n=n & (n-1);
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
