package sort;

import tool.ToolHelper;

/**
 * @Classname SelectionSort
 * @Created by zgw
 * @Date 2018-11-24 21:13
 * @Description 选择排序
 *
 * 将i从开始递增往后到数组结束
 *  找到每趟中从i位置开始到最后最小的数对应的数组下标
 *  将i下标数组中的数和最小下标数组中的数 两者进行交换，一趟结束后i位置放着最小的数
 * 最终数组中的数从小到大排序
 */
public class SelectionSort {

    public static void selectionSort(int[] arr){
        //如果数组为空或数组少于两个直接返回
        if (arr==null||arr.length<2){
            return;
        }
        //从i开始到最后，找到i位置上开始到最后最小的数
        for (int i = 0; i < arr.length - 1; i++) {
            //最小的数的下标
            int minIndex=i;
            //找到从i开始到最后的最小的数的下标
            for (int j = i+1; j < arr.length - 1; j++) {
                //逐个比较找到最小数的下标
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            //这一趟中只有当最小数的下标发生变化时，才进行交换
            if (i!=minIndex){
                ToolHelper.swapWithTmp(arr,i,minIndex);
            }
        }

    }
}
