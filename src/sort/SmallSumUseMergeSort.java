package sort;

/**
 * @Classname SmallSumUseMergeSort
 * @Created by zgw
 * @Date 2018-11-25 16:33
 * @Description 使用归并排序算法求小和问题
 *
 * 在一个数组中，每一个数左边比当前数小的数累加起来，叫做这个数组的小和。
 *  在归并的过程中，如果左边比右边的小，就记下左边的数 * 右边比左边大的个数
 *  再到更大范围内的归并
 *  分治--不会重复，不会遗漏
 *  左边有序的部分和右边有序的部分进行归并时：
 *      如果左边部分中的一个数比右边部分中的一个数小，右边部分中会有从右边这个数到右边部分最后个比左边大的个数A，小和=这个个数A*左边部分的这个数
 *  每次都是左边部分和右边部分之间进行计算，因此小和不会出现重复和遗漏现象
 */
public class SmallSumUseMergeSort {

    public static int smallSum(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        return mergeSort(arr, 0, arr.length - 1);
    }

    public static int mergeSort(int[] arr, int l, int r) {
        if (l == r) {
            return 0;
        }
        //中间位置
        int mid = l + ((r - l) >> 1);
        //参数的小和为左侧merge时的小和 加 右侧merge小和 加 左右两侧merge时的小和
        return mergeSort(arr, l, mid) + mergeSort(arr, mid + 1, r) + merge(arr, l, mid, r);
    }

    public static int merge(int[] arr, int l, int m, int r) {
        int[] help = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = m + 1;
        int res = 0;
        while (p1 <= m && p2 <= r) {
            //如果p1比p2小，产生的小和是  p2到该有序部分末尾的个数  *  p1位置数组的值
            res += arr[p1] < arr[p2] ? (r - p2 + 1) * arr[p1] : 0;
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= m) {
            help[i++] = arr[p1++];
        }
        while (p2 <= r) {
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++) {
            arr[l + i] = help[i];
        }
        return res;
    }
}
