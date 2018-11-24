package sort;

import tool.ToolHelper;

/**
 * @Classname InsertionSort
 * @Created by zgw
 * @Date 2018-11-24 21:27
 * @Description 插入排序
 *
 * 将整个数组分成有序和无序的两个部分
 *  1.将数组中第一个数看成有序，从第二个到最后一个看成无序的部分
 *  2.依次从无序的部分中，从前往后依次拿出一个数
 *      1.和它前边的一个数【这一个数已经在有序的部分中】进行比较，比前边的数大，就把当前的看着是有序的，接着从无序的数中拿出数进行比较
 *      2.如果是比前边的数小，就将两个数进行交换，同时再依次和前边有序的数进行两两比较，后边的比前边的数大不进行操作，小就交换
 *  3.最终每趟都保证前边有序的部分仍然有序，逐渐将所有无序的变成有序
 */
public class InsertionSort {
    public  static void insertionSort(int[] arr){
        //如果数组为空或数组少于两个直接返回
        if (arr==null||arr.length<2){
            return;
        }
        //从第二个到最后一个视为无序的部分
        for (int i = 1; i < arr.length ; i++) {
            //将无序部分的第一个元素和有序部分的元素逐个比较
            for (int j = i-1; j >= 0 && arr[j]>arr[j+1]; j--) {
                //后边的元素值大于前边的元素值时进行交换
                ToolHelper.swapWithTmp(arr,j,j+1);
            }
        }
    }
}
