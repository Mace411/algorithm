package lc;

/**
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */
public class 重排链表 {
    public static void reorderList(ListNode head) {
        int size = 0;
        ListNode slow = null;
        ListNode quick = head;
        // 找到中间的节点
        while (quick != null) {
            if (size % 2 == 0) {
                if (slow == null) {
                    slow = head;
                } else {
                    slow = slow.next;
                }
            }
            size++;
            quick = quick.next;
        }
        if (size <= 2) {
            return;
        }
        ListNode pre = null;
        ListNode cur = slow.next;
        ListNode next = cur.next;
        //把后半段反转
        while (next != null) {
            ListNode temp = next.next;
            next.next = cur;
            cur.next = pre;
            pre = cur;
            cur = next;
            next = temp;
        }
        //断开链表
        slow.next = null;
        // 把后半段插入到前半段
        ListNode left = head;
        ListNode right = cur;
        ListNode leftTemp;
        while (left != null && right != null) {
            leftTemp = left.next;
            left.next = right;
            ListNode rightTemp = right.next;
            right.next = leftTemp;
            left = leftTemp;
            right = rightTemp;
        }
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
//        node.next.next.next = new ListNode(4);
//        node.next.next.next.next = new ListNode(5);
//        node.next.next.next.next.next = new ListNode(6);
        reorderList(node);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

}
