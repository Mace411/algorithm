package lc;

/**
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * <p>
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 * <p>
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 */
public class 整数反转 {

    public static int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            if (rev < Integer.MIN_VALUE / 10 || rev > Integer.MAX_VALUE / 10) {
                return 0;
            }
            int cur = x % 10;
            x /= 10;
            rev = rev * 10 + cur;
        }
        return rev;

    }

    public static void main(String[] args) {
        System.err.println(reverse(-2147483648));
    }

}
