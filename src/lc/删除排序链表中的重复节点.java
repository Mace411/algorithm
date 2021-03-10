package lc;

/**
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 *
 */
public class 删除排序链表中的重复节点 {

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        //现在头部添加一个虚节点,为了删除头节点，同时也可以维持着新的头节点的引用
        ListNode fakeNode = new ListNode();
        fakeNode.next = head;
        ListNode pre = fakeNode;
        ListNode cur = head;
        boolean flag = false;
        //直到最后一个节点退出循环
        while (cur.next != null) {
            //相等，接着遍历，直到后面第一个不等的节点
            if (cur.val == cur.next.val) {
                flag = true;
            } else {
                if (flag) {
                    pre.next = cur.next;
                    flag = false;
                } else {
                    pre = cur;
                }
            }
            cur = cur.next;
        }
        if (flag) {
            pre.next = cur.next;
        }
        return fakeNode.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(3);
        l1.next.next.next.next = new ListNode(4);
        l1.next.next.next.next.next = new ListNode(4);
        l1.next.next.next.next.next.next = new ListNode(5);
        deleteDuplicates(l1);
    }

}
