package leetcode.editor.cn;
//把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2
//] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。
//
// 示例 1：
//
// 输入：[3,4,5,1,2]
//输出：1
//
//
// 示例 2：
//
// 输入：[2,2,2,0,1]
//输出：0
//
//
// 注意：本题与主站 154 题相同：https://leetcode-cn.com/problems/find-minimum-in-rotated-sor
//ted-array-ii/
// Related Topics 二分查找
// 👍 146 👎 0

// 旋转数组的最小数字
public class XuanZhuanShuZuDeZuiXiaoShuZiLcof {
    public static void main(String[] args) {
        Solution solution = new XuanZhuanShuZuDeZuiXiaoShuZiLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //[3,4,5,1,2] 寻找旋转数组的最小元素即为寻找右排序数组的首个元素 numbers[x]，称数组下标x为 旋转点
        public int minArray(int[] numbers) {
            int len = numbers.length;
            if (len == 1 || numbers[0] < numbers[len - 1]) {
                return numbers[0];
            }

            int left = 0, right = len - 1;
            while (right - left > 1) {
                int mid = left + ((right - left) >> 1);
                //特殊情况时，顺序查找
                if (numbers[left] == numbers[mid] && numbers[mid] == numbers[right]) {
                    return findMin(numbers, left, right);
                }
                //二分查找
                if (numbers[mid] >= numbers[left]) {
                    left = mid;
                } else if (numbers[mid] <= numbers[right]) {
                    right = mid;
                }
            }
            return numbers[right];
        }

        private int findMin(int[] numbers, int left, int right) {
            int min = numbers[left];
            for (int i = left + 1; i < right; ++i) {
                if (min > numbers[i]) {
                    min = numbers[i];
                }
            }
            return min;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
