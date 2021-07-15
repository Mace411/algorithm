package lc;

import java.util.Stack;

/**
 * 栈实现队列的add，poll，front，back
 */
public class 栈实现队列 {

    private Stack<Integer> pushStack = new Stack<>();

    private Stack<Integer> popStack = new Stack<>();

    private int backElem;

    public void add(int elem) {
        pushStack.add(elem);
        backElem = elem;
    }

    private void dump() {
        while (!pushStack.isEmpty()) {
            popStack.push(pushStack.pop());
        }
    }

    public int poll() {
        if (popStack.isEmpty() && pushStack.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        // 把push的元素倒入pop里面
        if (popStack.isEmpty()) {
            dump();
        }
        return popStack.pop();
    }

    public int front() {
        if (popStack.isEmpty() && pushStack.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        // 把push的元素倒入pop里面
        if (popStack.isEmpty()) {
            dump();
        }
        return popStack.peek();
    }

    public int getBackElem() {
        return backElem;
    }

    public static void main(String[] args) {
        栈实现队列 队列 = new 栈实现队列();
        队列.add(1);
        队列.add(2);
        队列.add(3);
        队列.add(4);
        System.err.println(队列.poll());
        队列.add(5);
        System.err.println(队列.poll());
        System.err.println(队列.front());
        System.err.println(队列.getBackElem());
    }
}
