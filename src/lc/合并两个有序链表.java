package lc;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Objects;

/**
 * 21. 合并两个有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */
public class 合并两个有序链表 {

    private int a;

    private String b;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        合并两个有序链表 合并两个有序链表 = (合并两个有序链表) o;
        return a == 合并两个有序链表.a &&
                Objects.equals(b, 合并两个有序链表.b);
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b);
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode();
        pre.next = l1;
        ListNode l1Cur = pre;
        ListNode l2Cur = l2;
        while (l1Cur.next != null && l2Cur != null) {
            if (l1Cur.next.val > l2Cur.val) {
                ListNode l1Temp = l1Cur.next;
                ListNode l2Temp = l2Cur.next;
                l1Cur.next = l2Cur;
                l1Cur.next.next = l1Temp;
                l2Cur = l2Temp;
            }
            l1Cur = l1Cur.next;
        }
        if (l2Cur != null) {
            l1Cur.next = l2Cur;
        }
        return pre.next;
    }

    public static void main(String[] args) {
//        ListNode l1 = new ListNode(1);
//        l1.next = new ListNode(3);
//        l1.next.next = new ListNode(5);
////        l1.next.next.next = new ListNode(7);
////        l1.next.next.next.next = new ListNode(9);
//
//        ListNode l2 = new ListNode(2);
//        l2.next = new ListNode(4);
//        l2.next.next = new ListNode(6);
//        l2.next.next.next = new ListNode(8);
//        l2.next.next.next.next = new ListNode(10);
//
//        mergeTwoLists(l1, l2);
        //目标对象
        A a = new A();
        AProxy proxy = new AProxy(a);

        Object proxyObj =  Proxy.newProxyInstance(a.getClass().getClassLoader(), a.getClass().getInterfaces(), proxy);
        Parent1 p1 = (Parent1) proxyObj;
        p1.speak();
        p1.walk();
//        Parent2 p2 = (Parent2) proxyObj;
//        p2.sleep();
    }


}

interface Parent1 {
    void speak();

    void walk();
}

interface Parent2 {

    void sleep();
}

class A implements Parent1/*, Parent2*/ {

    private int a = 100;

    @Override
    public void speak() {
        System.err.println("A speak" + 100);
    }

    @Override
    public void walk() {
        System.err.println("A walk");
    }

//    @Override
//    public void sleep() {
//        System.err.println("A sleep");
//    }
}

class AProxy implements InvocationHandler {
    private Object target;

    public AProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.err.println("before");
        Object invoke = method.invoke(target, args);
        System.err.println("after");
        return invoke;
    }

}
