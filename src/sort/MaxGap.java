package sort;

/**
 * @Classname MaxGap
 * @Created by zgw
 * @Date 2018-11-29 15:48
 * @Description 桶排序
 *
 * 给定一个数组，求如果排序之后，相邻两数的最大差值，要求时间复杂度O(N)，且要求不能用非基于比较的排序
 * 设计空桶，可以说明一个桶内部的数一定不是所求的最大差值
 */
public class MaxGap {

    public static int maxGap(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int len = nums.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        //找到最小值最大值
        for (int i = 0; i < len; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        //相等时，差值为0
        if (min == max) {
            return 0;
        }
        //0-N号桶的三组信息
        //i号桶存放了数据
        boolean[] hasNum = new boolean[len + 1];
        //i号桶的最大值
        int[] maxs = new int[len + 1];
        //i号桶的最小值
        int[] mins = new int[len + 1];
        int bid = 0;
        for (int i = 0; i < len; i++) {
            //确定当前数属于几号桶
            bid = bucket(nums[i], len, min, max);
            mins[bid] = hasNum[bid] ? Math.min(mins[bid], nums[i]) : nums[i];
            maxs[bid] = hasNum[bid] ? Math.max(maxs[bid], nums[i]) : nums[i];
            hasNum[bid] = true;
        }
        int res = 0;
        int lastMax = maxs[0];
        int i = 1;
        for (; i <= len; i++) {
            //每一个桶中最小值和它前边的非空桶的最大值进行做差，然后找到整个差的值中最大的值
            if (hasNum[i]) {
                res = Math.max(res, mins[i] - lastMax);
                lastMax = maxs[i];
            }
        }
        return res;
    }

    /**
     * 确定一个数应该在哪个桶
     * @param num 当前数
     * @param len 数组中的个数
     * @param min 最小值
     * @param max 最大值
     * @return
     *
     * 区间为 (max - min)最大值减去最小值
     * (num - min) / (max - min) 把num映射到0-1的区间上
     * (num - min) * len / (max - min) 得到num应该在哪个位置
     */
    public static int bucket(long num, long len, long min, long max) {
        return (int) ((num - min) * len / (max - min));
    }
}
