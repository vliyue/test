package cn.vliyue.test.algorithm.link;

/**
 * https://leetcode-cn.com/problems/reverse-linked-list/
 */
public class ReverseList {

    public ListNode reverseList(ListNode head) {
        ListNode result = head;
        ListNode current = head.next;
        while(current != null) {
            ListNode next = current.next;
            current.next = result;
            result = current;
            current = next;
        }
        return result;
    }
}
