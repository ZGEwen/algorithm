package list;

import pojo.Node;

import java.util.Stack;

/**
 * @Classname IsPalindromeList
 * @Created by zgw
 * @Date 2018-12-03 15:51
 * @Description 判断一个链表是否为回文结构
 * 【题目】 给定一个链表的头节点head，请判断该链表是否为回文结构。
 * 例如： 1->2->1，返回true。 1->2->2->1，返回true。15->6->15，返回true【15看成一个整体数字】。 1->2->3，返回false。
 * 进阶： 如果链表长度为N，时间复杂度达到O(N)，额外空间复杂度达到O(1)。
 */
public class IsPalindromeList {

    /**
     * need n extra space
     * @param head
     * @return
     * 借助栈先进后出，先遍历结点将所有结点压入栈中；之后再重新遍历结点与依次出栈的元素进行比较。
     * 值全部相同，则是回文序列；否则，不是回文序列
     */
    public static boolean isPalindrome1(Node head) {
        Stack<Node> stack = new Stack<Node>();
        Node cur = head;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        while (head != null) {
            if (head.value != stack.pop().value) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    /**
     * need n/2 extra space
     * @param head
     * @return
     * 慢指针走一步，快指针走两步，当快指针到结尾时，慢指针在中间
     * 将此时慢指针指的中间以及到结尾的值压入栈中
     * 从头结点依次和出栈的值进行比较
     */
    public static boolean isPalindrome2(Node head) {
        if (head == null || head.next == null) {
            return true;
        }
        Node right = head.next;
        Node cur = head;
        while (cur.next != null && cur.next.next != null) {
            right = right.next;
            cur = cur.next.next;
        }
        Stack<Node> stack = new Stack<Node>();
        while (right != null) {
            stack.push(right);
            right = right.next;
        }
        while (!stack.isEmpty()) {
            if (head.value != stack.pop().value) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    /**
     * need O(1) extra space不用辅助空间
     * @return
     * 奇数个时mid为中点位置，偶数个时mid为两个中点的前一个中点位置
     */
    public static boolean isPalindrome3(Node head) {
        if (head == null || head.next == null) {
            return true;
        }
        Node n1 = head;
        Node n2 = head;
        while (n2.next != null && n2.next.next != null) { // find mid node
            n1 = n1.next; // n1 -> mid
            n2 = n2.next.next; // n2 -> end
        }
        //循环结束，n1指向中点位置，n2指向末尾位置
        //将后半部分逆序，n2指向右半部分的第一个节点，n1中点位置的下一个位置指向空
        n2 = n1.next; // n2 -> right part first node
        n1.next = null; // mid.next -> null
        Node n3 = null;
        //将右半部分逆序
        //n2没指向空时，n3指向n2的下一个节点，n2所指节点下一个节点改为n1，将n1移动指向n2位置，n2移动指向n3位置
        while (n2 != null) { // right part convert
            n3 = n2.next; // n3 -> save next node
            n2.next = n1; // next of right node convert
            n1 = n2; // n1 move
            n2 = n3; // n2 move
        }
        //循环结束后，n2，n3都是null，n1指向最后一个节点
        //n3指向最后一个节点，n2指向头结点；【此时n1指向的是最后的一个数据节点，n2指向了原来的第一个数据结点】
        n3 = n1; // n3 -> save last node
        n2 = head;// n2 -> left first node
        boolean res = true;
        //n1从后往前到中点，n2从前往后到中点，只要有一个到了中点的下一个节点null，停止循环
        while (n1 != null && n2 != null) { // check palindrome
            if (n1.value != n2.value) {
                res = false;
                break;
            }
            //n1从右向左到中点；n2从左向右到中点
            n1 = n1.next; // left to mid
            n2 = n2.next; // right to mid
        }
        //比较结束，将右半部分的链表恢复到原来
        //处理最后一个非空节点，n1指向倒数第二个非空节点，最后一个非空节点指向空
        n1 = n3.next;
        n3.next = null;
        //n1非空时，n2指向n1的下一个节点，n1的下一个节点位置改为n3，n3移动到n1，n1移动到n2
        while (n1 != null) { // recover list
            n2 = n1.next;
            n1.next = n3;
            n3 = n1;
            n1 = n2;
        }
        return res;
    }

    public static void printLinkedList(Node node) {
        System.out.print("Linked List: ");
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Node head = null;
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(2);
        head.next.next.next = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

    }

}
