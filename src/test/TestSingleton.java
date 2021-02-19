package test;

public class TestSingleton {
    public static volatile TestSingleton singleton;

    /**
     * 构造函数私有，禁止外部实例化
     */
    private TestSingleton() {};

    public static TestSingleton getInstance() {
        if (singleton == null) {
            synchronized (singleton) {
                if (singleton == null) {
                    singleton = new TestSingleton();
                }
            }
        }
        return singleton;
    }

    public static void main(String[] args) {
        TestSingleton instance = getInstance();
    }
}
