package lc;

public class Compose {
    /**
     * f(i) = Math.ceil(f(i - 1) * 2.5)
     * f(2) = 3
     * @param level
     * @return
     */
    public static int getNum1(int level) {
        if (level <= 1) {
            return 1;
        }
        int num = 0;
        for (int i = 1; i < level; i++) {
            num = (int) Math.ceil(i * 2.5);
        }
        return num;
    }

    public static int getNUm2(int level) {
        if (level == 1) {
            return 1;
        }
        return (int) Math.ceil(getNUm2(level - 1) * 2.5);
    }

    public static void main(String[] args) {
        System.err.println(getNUm2(3));
    }
}
