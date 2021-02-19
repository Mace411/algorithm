package lc;

public class Compose {

    /**
     * 原来做的方法是错误的，只是巧合前面几个数对了
     * 这里的方法是从大往小推，一阶一阶推到1阶，就像是一颗树，18阶其实有点像是高为18的树的节点数有多少个，所以有点接近指数递增
     * @param level
     * @param composeNum
     * @return
     */
    public static int getNum1(int level, int composeNum) {
        if (level == 1) {
            return composeNum;
        }
        int num = 0;
        //多少个5的
        int five = composeNum / 2;
        //多少个3的，这里其实就只会有一个3的
        int three = composeNum % 2;
        //从小一阶开始推算需要多少个
        for (int i = level - 1; i > 0; i--) {
            num = five * 5 + three * 3;
            five = num / 2;
            three = num % 2;
        }
        return num;
    }

    public static int getNum(int level, int composeNum) {
        if (level == 1) {
            return composeNum;
        }
        int num = 0;
        //多少个5的
        int five = composeNum / 2;
        //多少个3的，这里其实就只会有一个3的
        int three = composeNum % 2;
        //从小一阶开始推算需要多少个
        num = five * 5 + three * 3;
        return getNum(level - 1, num);
    }

    public static int getNum2(int level) {
        return getNum(level - 1, 3);
    }

    public static void main(String[] args) {

    }
}
