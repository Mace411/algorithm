package lc;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcbcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */
public class 无重复字符的最长子串 {
    /**
     * map存已经遍历的字符和index，直到出现相同的字符时，修改开始的index
     * 动态规划 : f(i):index = i的时候，size的值
     * f(i + 1) = max(size, i - newIndex + 1)
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        int startIndex = 0;
        int size = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Integer same = map.put(c, i);
            if (same != null && same >= startIndex) {//重复了，但是有可能是startIndex之前的值
                startIndex = same + 1;
            }
            size = Math.max(size, i - startIndex + 1);
        }
        return size;
    }

    public static void main(String[] args) {
        String s = "abcbcbb";
        System.err.println(lengthOfLongestSubstring(s));
    }
}
