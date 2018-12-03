package sort;

import tool.ToolHelper;

/**
 * @Classname QuickSort
 * @Created by zgw
 * @Date 2018-11-27 10:26
 * @Description 改进后的随机快速排序
 */
public class QuickSort {
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    public static void quickSort(int[] arr, int l, int r) {
        if (l < r) {
            //随机快速排序
            //先将随机选取的数和最后一个数进行交换，然后再用交换后的这个最后的数进行交换
            ToolHelper.swapWithTmp(arr, l + (int) (Math.random() * (r - l + 1)), r);
            //p数组中是等于这个数的左边界和右边界
            int[] p = partition(arr, l, r);
            quickSort(arr, l, p[0] - 1);
            quickSort(arr, p[1] + 1, r);
        }
    }

    /**
     * 默认以r位置即最后一个数作为参照进行比较
     * 经典快速排序，一次只能确定一个数，就是作为比较的数X，且和数据初试状况有关
     * 这里改进之后，所有等于X的数都会被放在数组的中间，大于X的放右边，小于X的放左边
     * @param arr
     * @param l
     * @param r
     * @return 等于比较的数的数组上边界和下边界
     */
    public static int[] partition(int[] arr, int l, int r) {
        int less = l - 1;
        int more = r;
        while (l < more) {
            //整个过程中，作为参照的最右边的数仍然在最右边
            if (arr[l] < arr[r]) {
                //比这个值小的放左边
                //左边区域的下一个位置和l位置的数进行交换，l右移，less刚才已经右移
                ToolHelper.swapWithTmp(arr, ++less, l++);
            } else if (arr[l] > arr[r]) {
                //比这个数大的放右边
                //右边区域的前一个位置和l进行交换，交换后l保持不变，more刚才已经左移
                ToolHelper.swapWithTmp(arr, --more, l);
            } else {
                //等于这个数的放中间
                //l右移，左右两部分不变
                l++;
            }
        }
        //整个过程中，最右边的区域中为 大于参照的数[也可能没有] 和参照的数
        //因此需要将参照的数，放到等于的区域，因此将r位置和more位置[交换后从左到右等于参照的下一个位置]交换
        ToolHelper.swapWithTmp(arr, more, r);
        return new int[] { less + 1, more };
    }
}
