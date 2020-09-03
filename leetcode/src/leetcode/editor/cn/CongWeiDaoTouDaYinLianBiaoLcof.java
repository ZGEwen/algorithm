package leetcode.editor.cn;
//输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
//
//
//
// 示例 1：
//
// 输入：head = [1,3,2]
//输出：[2,3,1]
//
//
//
// 限制：
//
// 0 <= 链表长度 <= 10000
// Related Topics 链表
// 👍 52 👎 0

import java.util.ArrayList;
import java.util.Stack;

// 从尾到头打印链表
public class CongWeiDaoTouDaYinLianBiaoLcof {
    public static void main(String[] args) {
        Solution solution = new CongWeiDaoTouDaYinLianBiaoLcof().new Solution();
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        ArrayList<Integer> al = new ArrayList<>();

        public int[] reversePrint(ListNode head) {
            // 1.使用栈
            // return getIntsUseStack(head);
            // 2.使用递归
            // getIntsUseRecur(head);
            // int[] res = new int[al.size()];
            // for (int i=0;i<res.length;i++){
            //     res[i] =al.get(i);
            // }
            // return res;
            // 3.使用简单方法
            return simple(head);
        }

        /**
         * 同样的扫描两遍，第一遍记录链表大小，第二遍把链表中的值倒序放到数组相应的位置
         *
         * @param head
         * @return
         */
        public int[] simple(ListNode head) {
            //记录头结点，第一遍遍历之后，节点为null，不改变原链表
            ListNode node = head;
            int size = 0;
            while (node != null) {
                node = node.next;
                size++;
            }
            node = head;
            int[] nums = new int[size];
            //遍历赋值
            for (int i = size - 1; i >= 0; i--) {
                nums[i] = node.val;
                node = node.next;
            }
            return nums;
        }

        /**
         * 递归方法
         *
         * @param head
         */
        public void getIntsUseRecur(ListNode head) {
            if (head == null) return;
            getIntsUseRecur(head.next);
            al.add(head.val);
        }

        public int[] getIntsUseStack(ListNode head) {
            //链表遍历为从头到尾，输出为从尾到头，借助栈来实现
            Stack<Integer> sk = new Stack<>();
            while (head != null) {
                sk.push(head.val);
                head = head.next;
            }
            //输出格式为数组，因此将结果保存到数组
            int[] res = new int[sk.size()];
            int i = 0;
            while (!sk.isEmpty()) {
                res[i++] = sk.pop();
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
