package lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定1，3，5元的硬币，最少用多少枚硬币凑够11块呢？
 * 状态​：F(i)表示组合i元最少用多少个硬币
 * 递推：F(i) = min(F(i - 1) + 1, F(i - 3) + 1, F(i-5) + 1)
 * ​初始化：F(0)=0, F(1)=1, F(2)=2, F(3)=1, F(4)=2, F(5)=1
 * ​返回结果：F(n)
 */
public class 最少的硬币 {

    private static final List<Integer> record = new ArrayList<>(Arrays.asList(0,1,2,1,2,1));

    /**
     * 给定1，3，5元的硬币，最少用多少枚硬币凑够11块呢？
     *
     * @param money 需要凑够的总额
     * @return 最少的硬币数
     */
    private static int lessCoin(int money) {
        switch (money) {
            case 0:
                return record.get(0);
            case 1:
                return record.get(1);
            case 2:
                return record.get(2);
            case 3:
                return record.get(1);
            case 4:
                return record.get(2);
            case 5:
                return record.get(1);
        }

        int cur = 6;
        int one = record.get(cur - 1);
        int three = record.get(cur - 3);
        int five = record.get(cur - 5);
        int f_next = 0;
        while (cur <= money) {
            f_next = min(one + 1, three + 1, five + 1);
            record.add(f_next);
            cur++;
            one = record.get(cur - 1);
            three = record.get(cur - 3);
            five = record.get(cur - 5);
        }
        return f_next;
    }

    private static int min(int a, int b, int c) {
        return a < b ? (a < c ? a : c) : (b < c ? b : c);
    }

    public static void main(String[] args) {
        System.err.println(lessCoin(15));
    }

}
