package sort;

import tool.ToolHelper;

/**
 * @Classname NetherlandsFlag
 * @Created by zgw
 * @Date 2018-11-27 9:55
 * @Description 荷兰国旗问题
 *
 * 给定一个数组arr，和一个数num，请把小于num的数放在数组的左边，
 * 等于num的数放在数组的中间，大于num的数放在数组的右边，不要求大于部分和小于部分内部也有序
 */
public class NetherlandsFlag {

    /**
     * 对于下标[l r]的数组，与p进行比较，比p小的放左边，比p大的放右边，等于p的放中间
     * @param arr 数组
     * @param l 左侧下标
     * @param r 右侧下标
     * @param p 作为比较的数
     * @return  等于p的数组区域的左边界和右边界
     */
    public static int[] partition(int[] arr, int l, int r, int p) {
        int less = l - 1;
        int more = r + 1;
        //当前位置
        while (l < more) {
            if (arr[l] < p) {
                //比p小的放数组左边
                //将less的下一个位置的数和l位置的数进行交换，并将l右移一个位置，less在刚才已经右移
                ToolHelper.swapWithTmp(arr, ++less, l++);
            } else if (arr[l] > p) {
                //比p大的放数组右边
                //将more的前一个位置的数和l位置的数进行交换，more已经左移一个位置。l保持不变，用以检查l位置新的数与p之间的关系
                ToolHelper.swapWithTmp(arr, --more, l);
            } else {
                //和p相等的数放数组中间
                //l右移，不去管其他，大于和小于区域保持不变
                l++;
            }
        }
        //等于p的区域的下标左边界和右边界
        return new int[] { less + 1, more - 1 };
    }
}
