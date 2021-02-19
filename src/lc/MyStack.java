package lc;

import java.util.ArrayList;
import java.util.List;

public class MyStack {
    private List<String> list = new ArrayList<String>();

    public void push(String value) {
        synchronized (this) {
            list.add(value);
            notify();
        }
    }

    public String pop() throws InterruptedException {
        synchronized (this) {
            if (list.size() <= 0) {
                wait();
            }
            if (list.size() <= 0) {
                return "";
            }
            return list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final MyStack myStack = new MyStack();
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                new Thread() {
                    @Override
                    public void run() {
                        try {
                            String str1 = myStack.pop();
                            System.out.println("pop:" + str1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }.start();
            }
            for (int i = 0; i < 10000; i++) {
                final int finalI = i;
                new Thread() {
                    @Override
                    public void run() {
                        myStack.push("aabb" + finalI);
                    }
                }.start();
            }
        });
    }
}
