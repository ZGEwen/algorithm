package leetcode.editor.cn;
//反转一个单链表。
//
// 示例:
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL
//
// 进阶:
//你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
// Related Topics 链表
// 👍 1256 👎 0

// 反转链表
class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }
public class ReverseLinkedList {
    public static void main(String[] args) {
        Solution solution = new ReverseLinkedList().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    //1->2->3->4
    public ListNode reverseList(ListNode head) {
        ListNode pre=null;
        ListNode cur=head;
        ListNode temp=null;
        while (cur!=null){
            //记录cur后边的位置
            temp=cur.next;
            //部分反转
            cur.next=pre;
            //向前挪动pre
            pre=cur;
            //向前挪动cur
            cur=temp;
        }
        return pre;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
