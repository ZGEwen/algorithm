package tool;

/**
 * @Classname ToolHelper
 * @Created by zgw
 * @Date 2018-11-24 21:57
 * @Description 公共工具类
 */
public class ToolHelper {
    /**
     * 利用中间变量交换两个数的位置
     * @param arr
     * @param i
     * @param j
     */
    public static void swapWithTmp(int[] arr, int i, int j) {
        int tmp=arr[i];
        arr[i]=arr[j];
        arr[j]=tmp;
    }

    /**
     * 不使用中间变量进行交换
     * @param arr
     * @param i
     * @param j
     */
    public static void swapWithoutTmp(int[] arr, int i, int j) {
        arr[i]=arr[i]^arr[j];
        arr[j]=arr[i]^arr[j];
        arr[i]=arr[i]^arr[j];
    }
}
