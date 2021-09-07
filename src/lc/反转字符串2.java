package lc;

/**
 * 541. 反转字符串 II
 * 给定一个字符串 s 和一个整数 k，从字符串开头算起，每 2k 个字符反转前 k 个字符。
 *
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 *
 *
 * 示例 1：
 *
 * 输入：s = "abcdefg", k = 2
 * 输出："bacdfeg"
 * 示例 2：
 *
 * 输入：s = "abcd", k = 2
 * 输出："bacd"
 */
public class 反转字符串2 {

    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        int index = 0;
        do {
            if (k + index >= s.length()) {
                k = s.length() - index - 1;
            }
            for (int i = 0; i < k / 2; i++) {
                char temp = chars[i + index];
                chars[i] = chars[index + k - i];
                chars[index + k - 1] = temp;
            }
            index += 2 * k;
        } while (index < s.length());
        String s1 = new String(chars);
        return new StringBuilder(s1).reverse().toString();
    }

//    public String reverseStr1(String s, int k) {
//        StringBuilder sb = new StringBuilder();
//        int index = 0;
//        boolean flip = false;
//        for (int i = 0; i < s.length(); i++) {
//            if (i == index) {
//                flip = true;
//            } else if () {
//
//            }
//            if (flip) {
//
//            }
//        }
//    }
}
