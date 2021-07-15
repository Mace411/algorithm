package lc;

/**
 * 14. 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 */
public class 最长公共前缀 {

    public static String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs[0].length(); i++) {
            char cur = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || cur != strs[j].charAt(i)) {
                    return sb.toString();
                }
            }
            sb.append(cur);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] strs = {"leet", "leetcode", "le"};
        System.err.println(longestCommonPrefix(strs));

    }

}
