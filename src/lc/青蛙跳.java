package lc;

public class 青蛙跳 {

    /**
     * 每次走一阶或者两阶
     * F(n) = F(n-1) + F(n-2)
     *
     * @param level
     * @return
     */
    public static int jump(int level) {
        int n_1 = 1;
        int n_2 = 2;
        //只有一个台阶，直接返回1种
        if (level == 1) {
            return n_1;
        }
        //两个阶梯就返回两种
        if (level == 2) {
            return n_2;
        }
        //一共有多少个走法
        int n = 0;
        //从第二阶开始算，因为前两阶已经知道答案了呀。
        for (int i = 2; i < level; i++) {
            n = n_1 + n_2;
            n_1 = n_2;
            n_2 = n;
        }
        return n;
    }


    public int JumpFloor(int level) {
        return (int) Math.pow(2, level - 1);
    }

    public static void main(String[] args) {
        System.err.println(jump(3));
    }

}
