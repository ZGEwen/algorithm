package sort;

/**
 * @Classname MergeSort
 * @Created by zgw
 * @Date 2018-11-25 15:58
 * @Description 归并排序--分治
 *
 * 将待排序部分分为两部分，先使两小部分分别有序，再进行归并操作使得整个也有序
 */
public class MergeSort {

    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        mergeSort(arr, 0, arr.length - 1);
    }

    public static void mergeSort(int[] arr, int l, int r) {
        if (l == r) {
            return;
        }
        //l和r中点mid
        int mid = l + ((r - l) >> 1);
        mergeSort(arr, l, mid);//T(N/2)
        mergeSort(arr, mid + 1, r);//T(N/2)
        merge(arr, l, mid, r);//O(N)
        //T(N)=2T(N/2)+O(N)
    }

    public static void merge(int[] arr, int l, int m, int r) {
        int[] help = new int[r - l + 1];
        int i = 0;
        //左侧部分最小值
        int p1 = l;
        //右侧部分最小值
        int p2 = m + 1;
        while (p1 <= m && p2 <= r) {
            //谁小填谁，然后两者均下移
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        //p1和p2只有一个有剩余

        //p1还有剩余
        while (p1 <= m) {
            help[i++] = arr[p1++];
        }
        //p2还有剩余
        while (p2 <= r) {
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++) {
            arr[l + i] = help[i];
        }
    }
}
