//不修改数组找出数组中重复的数字。
//
//
//在一个长度为 n+1 的数组 nums 里的所有数字都在 1～n 的范围内，所以数组中至少有一个数字重复
//找出数组中任意一个重复的数字，但不能修改输入的数组。
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


// 不修改数组找出数组中重复的数字
public class ShuZuZhongZhongFuDeShuZiNoEditLcof {
    public static void main(String[] args) {
        Solution solution = new ShuZuZhongZhongFuDeShuZiNoEditLcof().new Solution();
        int[] nums = {2, 3, 5, 4, 3, 2, 6, 7};

        System.out.println(solution.findRepeatNumber(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findRepeatNumber(int[] nums) {
            //数组中的数都在1-n的范围内。长度n+1肯定存在重复的数字

            return duplicate(nums);
            // return tempArray(nums);
        }

        /**
         * 使用辅助数组
         *
         * @param nums
         * @return
         */
        public int tempArray(int[] nums) {
            //空间复杂度O(n)
            int[] temp = new int[nums.length];
            int i = 0;
            for (int num : nums) {
                if (temp[num] == 0) {
                    temp[num] = num;
                } else {
                    // System.out.println(num + ",repeat index:" + i);
                    // 可以获取到所有的重复数字，重复的数字相关信息均可以得到
                    return num;
                }
                i++;
            }
            //时间复杂度为O(n)，空间复杂度O(1)
            return -1;
        }

        /**
         * 使用二分的思想，将区间1-n 一分为二，分别统计两段中的 每个数字在整个数组中出现的次数和
         * 时间复杂度O(nlogn),空间复杂度O(1)
         *
         * @param nums
         * @return
         */
        public int duplicate(int[] nums) {
            if (nums == null) {
                return -1;
            }
            //检查不合格项
            for (int num : nums) {
                if (num < 1 || num >= nums.length) {
                    return -1;
                }
            }
            //数字全在1~n-1之间
            int start = 1;
            int end = nums.length - 1;
            while (end >= start) {
                //计算数字取值范围的中点
                int mid = (start + end) >>> 1;
                //计算前半段取值范围，在数组中出现的次数
                int count = countRange(nums, start, mid);
                //特别，截止条件，不在进行
                if (end == start) {
                    if (count > 1) {
                        return start;
                    } else {
                        break;
                    }
                }
                //start..mid..end (mid - start + 1)个数在数组中出现count次
                // count较大说明[start..mid]范围内一定有重复的数，接着在[start..mid]二分
                if (count > (mid - start + 1)) {
                    end = mid;
                } else {
                    start = mid + 1;
                }
            }
            return -1;
        }

        /**
         * 计算某范围的数，在数组中出现的总次数
         *
         * @param array
         * @param start
         * @param end
         * @return
         */
        public int countRange(int[] array, int start, int end) {
            if (array == null || start > end) {
                return -1;
            }
            int count = 0;
            for (int e : array) {
                //e 在[start,end]区间内计数
                if (e >= start && e <= end) {
                    ++count;
                }
            }
            //在[start,end]区间总数
            return count;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
