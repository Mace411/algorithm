package lc;

/**
 * 231. 2 的幂
 * 给你一个整数 n，请你判断该整数是否是 2 的幂次方。如果是，返回 true ；否则，返回 false 。
 *
 * 如果存在一个整数 x 使得 n == 2x ，则认为 n 是 2 的幂次方。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 1
 * 输出：true
 * 解释：20 = 1
 * 示例 2：
 *
 * 输入：n = 16
 * 输出：true
 * 解释：24 = 16
 */
public class 二的幂 {

    /**
     * n & (n - 1) == 0
     * @param n
     * @return
     */
    public static boolean isPowerOfTwo(int n) {
        return n > 0 && (n & n - 1) == 0;
    }

    /**
     * (n & -n) == n
     * @param n
     * @return
     */
    public static boolean isPowerOfTwo1(int n) {
        return n > 0 && (n & -n) == n;
    }

    public static void main(String[] args) {
        System.err.println(isPowerOfTwo1(6));
    }
}
