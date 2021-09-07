package lc;

/**
 * 25. K 个一组翻转链表
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * <p>
 * k 是一个正整数，它的值小于或等于链表的长度。
 * <p>
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * <p>
 * 进阶：
 * <p>
 * 你可以设计一个只使用常数额外空间的算法来解决此问题吗？
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 */
public class K个一组翻转链表 {

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        ListNode cur = head;
        int size = 0;
        while (cur != null) {
            size++;
            cur = cur.next;
        }
        if (size < k) {
            return head;
        }
        ListNode pre = new ListNode();
        pre.next = head;
        cur = head;
        int count = 0;
        ListNode firstPre = pre;
        ListNode lastNext = null;
        while (cur != null) {
            while (count <= k && size >= k) {
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
                count++;
                size--;
                if (count == k) {
                    lastNext = cur;
                }
            }

        }



    }


}
