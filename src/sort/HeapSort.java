package sort;

import tool.ToolHelper;

/**
 * @Classname HeapSort
 * @Created by zgw
 * @Date 2018-11-27 15:22
 * @Description 堆排序
 *
 * 构造大顶堆，最终数组以从小到大顺序排序
 */
public class HeapSort {

    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);//0-i位置形成大顶堆
        }
        int size = arr.length;
        //堆顶元素和末尾元素交换，堆的规模大小减一；由于是大顶堆，交换后，堆中最大的数放到了堆的末尾+1位置
        ToolHelper.swapWithTmp(arr, 0, --size);
        while (size > 0) {
            //重新调整成大顶堆
            heapify(arr, 0, size);
            //堆顶元素和末尾元素交换，堆的规模大小减一；由于是大顶堆，交换后，堆中最大的数放到了堆的末尾+1位置
            ToolHelper.swapWithTmp(arr, 0, --size);
        }
        //最终，数组中的元素按照从小到大顺序排列
    }

    /**
     * 构建大顶堆的过程
     * @param arr
     * @param index
     */
    public static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            //大顶堆，每一个子树都是大顶堆，因此在形成大顶堆之后，需要去看是否调整父节点，让整个树也满足大顶堆
            ToolHelper.swapWithTmp(arr, index, (index - 1) / 2);
            //子节点的父节点
            index = (index - 1) / 2;
        }
    }

    /**
     * 由于大顶堆中某项值发生变化，进行调整的过程
     * @param arr
     * @param index 该位置对应的值变小
     * @param size 堆的大小，可以伸缩
     */
    public static void heapify(int[] arr, int index, int size) {
        int left = index * 2 + 1;
        //左孩子在堆上
        while (left < size) {
            //右孩子不越界，判断左右孩子哪个更大
            int largest = left + 1 < size && arr[left + 1] > arr[left]
                    ? left + 1
                    : left;
            //比较左右孩子最大值和父节点的值进行比较，找出最大值
            largest = arr[largest] > arr[index]
                    ? largest
                    : index;
            //不在向下调整
            if (largest == index) {
                break;
            }
            //largest ！= index 需要交换
            ToolHelper.swapWithTmp(arr, largest, index);
            //要调整的值当前所在的位置
            index = largest;
            //要调整的值左孩子所在的位置
            left = index * 2 + 1;
        }
    }
}
