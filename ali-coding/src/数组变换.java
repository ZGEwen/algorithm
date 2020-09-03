import java.util.Arrays;

/**
 * @Classname 数组变换
 * @Created by zgw
 * @Date 2020-08-29 18:13
 * @Description 题目描述
 * 等级：中等
 * 知识点：排序、贪心
 * 查看题目：数组变换 https://developer.aliyun.com/coding/110
 * 给出一个长度为 n 的数组，和一个正整数 d。
 * 你每次可以选择其中任意一个元素 a[i] 将其变为 a[i] + d 或 a[i] - d，这算作一
 * 次操作。
 * 你需要将所有的元素全部变成相等元素，如果有解，请输出最小操作次数，如果
 * 无解请输出 -1。
 * 输入数字 n、数字 d，和一个长度为 n 的数组 a。1 <= n <= 100000，1 <= d
 * <= 100, 1 <= a[i] <= 100000。
 * 输出一个数字，表示最小的操作次数，如果无解输出 -1。
 * 示例 1
 * 输入：
 * 5
 * 2
 * [3,5,7,1,9]
 * 输出：
 * 6
 * 注意
 * 最优解为全部变为 5，共 1 + 0 + 1 + 2 + 2 = 6 次。
 * 解题方法：
 * 首先判断无解的情况，可以发现 a[i]，a[i]+d, a[i]-d 在 模 d 情况下的余数不会发生
 * 改变，因此如果原数组中的存在任意两个数字它们对 d 取余结果不同，那么此时无解。
 * 设余数为 r。判断完无解之后，需要求出将所有的元素全部变成相等元素操作的最小值。
 * 先将数组 a[i] 排序，然后除以 d，得到从 r 变成 a[i] 需要的步数。
 * 枚举元素 a[i]，将所有元素全部变成 a[i] 需要考虑两部分，i 之前和 i 之后 : 对于 i
 * 之前的元素，假设都是 r，那么需要 (i-1)*a[i]，但是因元素并不都是 0，所有我们可以
 * 用一个变量 val 存放前 i-1 项的和，然后我们在减去 val 就是前 i-1 个元素真正需要
 * 操作的步数。
 * 对于 i 之后的元素，也是类似的。我们假设 i 之后的所有项和为 val，假设我
 * 们要将它们变为 r，则消耗即为 val，但是我们只需要将其变为 a[i]，因此需要减去
 * (n-i)*a[i]。
 * 看完之后是不是有了答题思路了呢，快来练练手吧：数组变换
 */
public class 数组变换 {
    public static void main(String[] args) {
        int n = 5, d = 2;
        int[] a = {3, 5, 7, 1, 9};
        System.out.print(solution(n, d, a));
    }


    public static int solution(int n, int d, int[] a) {
        int r = a[0] % d;
        for (int i = 1; i < a.length; i++) {
            if (a[i] % d != r) {
                //模不相等返回-1
                return -1;
            }
        }
        Arrays.sort(a);
        int left=0;
        int right=0;
        //保留数组中每个数都变成该数的次数，最后取最小的
        for(int i=0;i<n;i++){
            if(i<n/2){
                left+=a[i];
            }
            if(i>n/2){
                right+=a[i];
            }
        }
        return (a[n/2]*(n/2)-left)/d+Math.abs((a[n/2]*(n-n/2-1)-right))/d;
        //
        // //运行超时
        // int min = Integer.MAX_VALUE;
        // for (int i = 0; i <= n; i++) {
        //     int flag = r + d * i;
        //     int count = 0;
        //     //排好序的数组,数组中所有的元素达到当前时所需要的步数
        //     for (int num : a) {
        //         count += Math.abs(num - flag) / d;
        //     }
        //     if (min > count) {
        //         min = count;
        //     }
        // }
        // // 返回步数的最小值
        // return min;

    }
}
