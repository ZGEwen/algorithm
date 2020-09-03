//输入一个链表的头节点，从尾到头反过来打印每个节点的值（不使用数组返回）。
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

import java.util.Stack;

// 从尾到头打印链表，不借助数组打印。
// 提示：循环放入栈再依次弹出打印 或者 递归打印（链表长度太大会导致方法栈溢出）。
public class CongWeiDaoTouDaYinLianBiaoNoArrayLcof {
    public static void main(String[] args) {
        Solution solution = new CongWeiDaoTouDaYinLianBiaoNoArrayLcof().new Solution();
        solution.add(1);
        solution.add(2);
        solution.add(3);
        solution.add(4);
        solution.printReversedOrderIteratively();
        solution.printReversedOrderRecursively(solution.head);
        solution.clear();
        System.out.println(solution.head);
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    class Solution {
        //定义头尾指针
        public ListNode head = null, tail = null;
        public int size = 0;

        public boolean add(int val) {
            ListNode newNode = new ListNode(val);
            if (head == null) {
                head = newNode;
            } else {
                tail.next = newNode;
            }
            tail = newNode;
            size++;
            return true;
        }

        public void clear() {
            for (ListNode node = head; node != null; ) {
                ListNode next =node.next;
                node.next=null;
                node = next;
                size--;
            }
            head=tail=null;
        }
        public void print(){
            for (ListNode node=head;node!=null;node=node.next){
                System.out.print(node.val+",");
            }
            System.out.println();
        }

        /**
         * 借助栈实现倒序打印链表
         */
        public void printReversedOrderIteratively() {
            Stack<ListNode> stack = new Stack<>();
            for (ListNode node = head; node != null; node = node.next) {
                stack.push(node);
            }
            while (!stack.empty()) {
                System.out.println(stack.pop());
            }
        }

        /**
         * 使用递归实现倒序打印链表
         * @param head
         */
        private void printReversedOrderRecursively(ListNode head) {
            if (head != null) {
                if (head.next != null) {
                    printReversedOrderRecursively(head.next);
                }
                System.out.println(head);
            }
        }
    }

}
