package lc;

/**
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 * <p>
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
 * 输入：x = -101
 * 输出：false
 */
public class 回文数 {
    /**
     * 字符串处理方法
     *
     * @param x
     * @return
     */
    public static boolean isPalindrome0(int x) {
        String s = String.valueOf(x);
        char[] chars = s.toCharArray();
        int i = 0;
        while (i < chars.length / 2) {
            if (chars[i] != chars[chars.length - i - 1]) {
                return false;
            }
            i++;
        }
        return true;
    }

    /**
     * 不使用字符串方法
     * 但是需要额外空间
     *
     * @param x
     * @return
     */
    public static boolean isPalindrome1(int x) {
        //负数或者末尾为0肯定不是
        if (x < 0 || (x > 0 && x % 10 == 0)) {
            return false;
        }
        int temp = x;
        int[] eachPos = new int[32];
        int index = 0;
        int length = 0;
        while (temp != 0) {
            int pos = temp % 10;
            eachPos[index++] = pos;
            temp = (temp - pos) / 10;
            length++;
        }
        index = 0;
        while (index < length / 2) {
            if (eachPos[index] != eachPos[length - index - 1]) {
                return false;
            }
            index++;
        }
        return true;
    }

    /**
     * 只需要常量空间
     * 判断1221/1000 == 1221 % 10
     *
     * @param x
     * @return
     */
    public static boolean isPalindrome2(int x) {
        if (x < 0 || (x > 0 && x % 10 == 0)) {
            return false;
        }
        int divide = 1;
        while (x / divide >= 10) {
            divide *= 10;
        }
        while (x > 0) {
            int left = x / divide;
            int right = x % 10;
            if (left != right) {
                return false;
            }
            x = (x % divide) / 10;
            divide /= 100;
        }
        return true;
    }

    public static void main(String[] args) {
        System.err.println(isPalindrome2(1212));
    }
}
