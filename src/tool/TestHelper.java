package tool;

import java.util.Arrays;

/**
 * @Classname TestHelper
 * @Created by zgw
 * @Date 2018-11-25 14:19
 * @Description 对数器，验证算法是否正确的一种方式
 *
 * 随机产生数组，通过自己的排序算法与系统提供的排序算法进行排序，比较两者排序结果是否相同
 */
public class TestHelper {
    /**
     * 系统提供的绝对正确的排序方法进行排序
     * @param arr
     */
    public static void comparator(int[] arr){
        Arrays.sort(arr);
    }

    /**
     * 用于产生随机样本
     * @param maxSize
     * @param maxValue
     * @return
     *
     * Math.random()产生double类型的[0,1)
     * (int) ((maxSize + 1) * Math.random()) 产生[0,maxSize] 整数
     */
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    /**
     * 数组复制
     * @param arr
     * @return
     */
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    /**
     * 判断两个数组是否相等
     * @param arr1
     * @param arr2
     * @return
     */
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 打印输出
     * @param arr
     */
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
