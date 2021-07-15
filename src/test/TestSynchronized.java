package test;

import java.util.concurrent.atomic.AtomicInteger;

public class TestSynchronized {

    private volatile AtomicInteger atomicInteger = new AtomicInteger(1);

    private Integer i = 1;

    private void test() {
        synchronized (i) {
            i = i + 1;
            throw new RuntimeException();
        }
    }

    public static void main(String[] args) {
        TestSynchronized testSynchronized = new TestSynchronized();
        try {
            testSynchronized.test();
        } catch (Exception e) {

        }
        System.err.println(testSynchronized.i);
    }

}
