package lc;

import java.util.ArrayList;
import java.util.List;

/**
 * 89.格雷编码
 * 在一组数的编码中，若任意两个相邻的代码只有一位二进制数不同，则称这种编码为格雷码（Gray Code），另外由于最大数与最小数之间也仅一位数不同，即“首尾相连”，因此又称循环码或反射码
 * 第一步，改变最右边的位元值；
 * 第二步，改变右起第一个为1的位元的左边位元；
 * 第三步，第四步重复第一步和第二步，直到所有的格雷码产生完毕（换句话说，已经走了(2^n) - 1 步）
 * n位的格雷码总共有1<<n个
 * f(i) = i ^ i>>1
 */
public class GrayCode {

    /**
     *
     * @param n 编码的位数
     * @return
     */
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < 1 << n; i++) {
            result.add(i ^ i>>1);
        }

        return result;
    }



}
