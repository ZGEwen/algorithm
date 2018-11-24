package sort;

import tool.ToolHelper;

/**
 * @Classname BubbleSort
 * @Created by zgw
 * @Date 2018-11-24 20:50
 * @Description 冒泡排序
 *
 * ①从前往后依次取相邻两个数做比较，如果第一个数比第二个数大就交换，否则就不交换；
 * ②从前到后每比较完一趟，会将本次最大的数放到本次的末尾。
 */
public class BubbleSort {
    public static void bubbleSort(int[] arr){
        //如果数组为空或数组少于两个直接返回
        if (arr==null||arr.length<2){
            return;
        }
        //对于beginIndex~endIndex间的数进行比较
        for (int endIndex=arr.length-1;endIndex>0;endIndex--){
            for (int beginIndex=0;beginIndex<endIndex;beginIndex++){
                if (arr[beginIndex]>arr[beginIndex+1]){
                    ToolHelper.swapWithTmp(arr,beginIndex,beginIndex+1);
                }
            }
        }
    }
}
