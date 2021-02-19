package lc;

/**
 * 5. 最长回文子串
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * 输入: "cbbd"
 * 输出: "bb"
 *
 */
public class 最长回文子串 {
    /**
     * 动态规划：从回文中心出发扩展，两边的字符相等的话，就说明是一个回文串，假如不等，选取下一个回文中心
     *          但是只能解决有2个字符以上的字符串，当字符不多于2个时，要特殊处理
     * 定义 : f(i,j) 表示字符串索引i到j这个子串
     * 状态转移方程 : f(i，j) = f(i - 1, j + 1) & char[i] == char[j]
     *                        char(0) == char(1),s.length == 2
     *
     * @param s
     * @return
     */
    public static String longestPalindrome0(String s) {
        String maxStr = "";
        char[] chars = new char[s.length()];
        s.getChars(0, s.length(), chars, 0);
        for (int i = 0; i < chars.length; i++) {
            int left = i - 1;
            int right = i + 1;
            String tempStr = String.valueOf(s.charAt(i));
            while (left >= 0 && right < chars.length) {
                //可能会有中间的字符只等于左边或者右边的情况
                if (chars[left] == chars[i] && chars[i] != chars[right]) {//等于左边
                    tempStr = String.valueOf(chars, left, i - left + 1);
                    left--;
                } else if (chars[left] != chars[i] && chars[i] == chars[right]) {//等于右边
                    tempStr = String.valueOf(chars, i, right - i + 1);
                    right++;
                } else if (chars[left] != chars[right]) {
                    break;
                }
                tempStr = String.valueOf(chars, left, right - left + 1);
                left--;
                right++;
            }
        }
//        if (tempStr.length() > maxStr.length()) {
//            maxStr = tempStr;
//        }
//            if (maxStr.length() > (chars.length - 1 - i) * 2) {//在已经找到最大回文子串的情况下，提前退出循环
//                break;
//            }
//    }
        return maxStr;
}

    /***
     * 尝试从两边往中间压
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        String maxStr = "";
//        char[] chars = new char[s.length()];// 这里直接用原字符串，执行时间反而更长，内存使用更多，还不如new 一个char数组
//        s.getChars(0, s.length(), chars, 0);
        for (int start = 0; start < s.length(); start++) {
            int left = start;
            int right = s.length() - 1;
            int end = s.length() - 1;
            int lastEqualStart = Integer.MAX_VALUE;//下一次可以从上一次相同的地方出发
            while (right > left) {
                if (s.charAt(start) == s.charAt(right) && right != end && lastEqualStart >= end) {
                    lastEqualStart = right;
                }
                if (s.charAt(left) == s.charAt(right)) {
                    left++;
                    right--;
                    continue;
                }
                if (start == left) {//防止出现一直起始和结束不等
                    right--;
                }
                if (lastEqualStart < end) {
                    right = lastEqualStart;
                }
                left = start;
                end = right;
            }
            if (end - start + 1 > maxStr.length()) {
                maxStr = s.substring(start, end + 1);/*String.valueOf(chars, start, end - start + 1);*/
            }
        }
        return maxStr;
    }


    public static void main(String[] args) {
//        String s = "babad";
//        String s = "cbbd";
        String s = "aabadaefgcdabaa";
        String s1 = longestPalindrome(s);
        System.err.println(s1);
    }
}
