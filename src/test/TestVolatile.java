package test;

import java.util.concurrent.Callable;

public class TestVolatile implements Callable<String> {
    int a = 1;
    int b = 2;

    public void change() {
        a = 3;
        b = a;
    }

    @Override
    public String call() throws Exception {
        return print();
    }

    public String print() {
        return "b=" + b + ";a=" + a;
    }

    public static void main(String[] args) {
//        while (true) {
//            final TestVolatile test = new TestVolatile();
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    test.change();
//                }
//            }).start();
//
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    test.print();
//                }
//            }).start();
//        }
        TestVolatile test = new TestVolatile();
        try {
            String call = test.call();
            System.err.println(call);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
