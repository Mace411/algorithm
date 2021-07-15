package test;

import java.util.concurrent.LinkedBlockingQueue;

public class 两个线程交替打印1到100 {

    private Integer count = 1;

    private final Object lock = new Object();

    private LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<>();

    {
        for (int i = 1; i <= 100; i++) {
            queue.add(i);
        }
    }

    class Print implements Runnable {

        private final int i;

        public Print(int i) {
            this.i = i;
        }

        @Override
        public void run() {
            while (count <= 100) {
                synchronized (lock) {
                    if (count > 100) {
                        break;
                    }
                    if (count % 2 == i) {
                        System.err.println(Thread.currentThread().getName() + " - " + count);
                        count++;
                        lock.notify();
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        两个线程交替打印1到100 print = new 两个线程交替打印1到100();
//        for (int i = 1; i < 17; i++) {
//            Print p = print.new Print(i - 1);
//            Thread t = new Thread(p, "T" + i);
//            t.start();
//        }
        Print p1 = print.new Print(1);
        Print p2 = print.new Print(0);
        Thread t1 = new Thread(p1, "T1");
        Thread t2 = new Thread(p2, "T2");
        t2.start();
        t1.start();
        t1.join();
        t2.join();

    }


}
