package test;

import sort.InsertionSort;
import tool.TestHelper;

import static sort.BubbleSort.bubbleSort;

/**
 * @Classname Test
 * @Created by zgw
 * @Date 2018-11-25 14:36
 * @Description 测试类
 */
public class Test {
    public static void main(String[] args) {
        //测试次数
        int testTime = 500000;
        //数组大小
        int maxSize = 10;
        //随机数参数
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = TestHelper.generateRandomArray(maxSize, maxValue);
            int[] arr2 = TestHelper.copyArray(arr1);
            //自己的方法排序
            // bubbleSort(arr1);
            InsertionSort.insertionSort(arr1);
            //绝对正确的方法排序
            TestHelper.comparator(arr2);
            if (!TestHelper.isEqual(arr1, arr2)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "自己的方法能够正确的进行排序" : "Error：自己的方法不能正确的进行排序");

        int[] arr = TestHelper.generateRandomArray(maxSize, maxValue);
        TestHelper.printArray(arr);
        // bubbleSort(arr);
        InsertionSort.insertionSort(arr);
        TestHelper.printArray(arr);
    }
}
