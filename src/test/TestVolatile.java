package test;

public class TestVolatile {
    int a = 1;
    int b = 2;

    public void change() {
        a = 3;
        b = a;
    }

    public void print() {
        System.out.println("b=" + b + ";a=" + a);
    }

    public static void main(String[] args) {
        while (true) {
            final TestVolatile test = new TestVolatile();
            new Thread(new Runnable() {
                @Override
                public void run() {

                    test.change();
                }
            }).start();

            new Thread(new Runnable() {
                @Override
                public void run() {

                    test.print();
                }
            }).start();

        }
    }
}
