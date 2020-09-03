package leetcode.editor.cn;
//找出数组中重复的数字。
//
//
//在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请
//找出数组中任意一个重复的数字。
//
// 示例 1：
//
// 输入：
//[2, 3, 1, 0, 2, 5, 3]
//输出：2 或 3
//
//
//
//
// 限制：
//
// 2 <= n <= 100000
// Related Topics 数组 哈希表
// 👍 160 👎 0

// 数组中重复的数字
public class ShuZuZhongZhongFuDeShuZiLcof {
    public static void main(String[] args) {
        Solution solution = new ShuZuZhongZhongFuDeShuZiLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findRepeatNumber(int[] nums) {
            //数组中的数都在0-n-1的范围内。如果没有重复的数字，重排后，数字i出现在下标为i的位置
            for (int i = 0; i < nums.length; i++) {
                //只有当下标与值相等时下一个,不等时循环，下标i中的值nums[i]和下标nums[i]的值是否相等，不等互换，相等返回
                while (i!=nums[i]){
                    if (nums[i]!=nums[nums[i]]){
                        swap2(nums,i,nums[i]);
                    }else {
                        return nums[i];
                    }
                }
            }
            //时间复杂度为O(n)，空间复杂度O(1)
            return -1;
        }

        public void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        public void swap2(int[] nums, int i, int j) {
            nums[i] = nums[i] ^ nums[j];
            nums[j] = nums[i] ^ nums[j];
            nums[i] = nums[i] ^ nums[j];
        }
        // public int findRepeatNumber(int[] nums) {
        //     //使用hashset，时间和空间复杂度为O(n)
        //     Set<Integer> set = new HashSet<Integer>();
        //     int repeat = -1;
        //     for (int num : nums) {
        //         //hashset存在元素时，再次添加返回false
        //         if (!set.add(num)) {
        //             repeat = num;
        //             break;
        //         }
        //     }
        //     return repeat;
        // }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
