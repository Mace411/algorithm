package lc;

import java.util.List;

/**
 * 19. 删除链表的倒数第 N 个结点
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * <p>
 * 进阶：你能尝试使用一趟扫描实现吗？
 */
public class 删除链表的倒数第N个结点 {


    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode pre = new ListNode();
        ListNode slow = pre;
        slow.next = head;
        int count = 0;
        while (fast != null) {
            if (count >= n) {
                slow = slow.next;
            }
            fast = fast.next;
            count++;
        }
        ListNode remove = slow.next;
        slow.next = remove.next;
        remove.next = null;// free
        return pre.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        removeNthFromEnd(head, 1);
    }


}
