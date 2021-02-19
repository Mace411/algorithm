package lc;

/**
 * 两个链表，逆序存储了两个数，求两者之和，并逆序存放在一个链表中
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class 链表实现两数之和 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        ListNode listNode = addTwoNumbers(l1, l2);

    }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode finalList = null;
        int l1temp;
        int l2temp;
        int add = 0;
        ListNode tempNode = null;
        while (l1 != null || l2 != null) {
            l1temp = l1 != null ? l1.val : 0;
            l2temp = l2 != null ? l2.val : 0;
            int temp = l1temp + l2temp + add;
            int result = temp % 10;
            add = temp / 10;
            if (finalList == null) {
                finalList = new ListNode(result);
            } else {
                if (tempNode == null) {
                    finalList.next = new ListNode(result);
                    tempNode = finalList.next;
                } else {
                    tempNode.next = new ListNode(result);
                    tempNode = tempNode.next;
                }
            }
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        return finalList;
    }

}
