package cn.vliyue.test.algorithm.link;

/**
 * https://leetcode-cn.com/problems/rotate-list/
 *
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class RotateList {

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        rotateRight(head, 4);
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        int length = 1;
        ListNode temp = head;
        while (temp.next != null) {
            length++;
            temp = temp.next;
        }
        temp.next = head;
        for (int i = 0; i < length - k % length - 1 ; i++) {
            head = head.next;
        }
        temp = head.next;
        head.next = null;
        return temp;
    }

}