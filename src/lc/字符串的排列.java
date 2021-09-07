package lc;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 567. 字符串的排列
 * 给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。
 * <p>
 * 换句话说，s1 的排列之一是 s2 的 子串 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s1 = "ab" s2 = "eidbaooo"
 * 输出：true
 * 解释：s2 包含 s1 的排列之一 ("ba").
 * 示例 2：
 * <p>
 * 输入：s1= "ab" s2 = "eidboaoo"
 * 输出：false
 */
public class 字符串的排列 {

    public static boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) {
            return false;
        }
        Map<Character, Integer> cnt = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            cnt.merge(s1.charAt(i), -1, Integer::sum);
            cnt.merge(s2.charAt(i), 1, Integer::sum);
        }
        int diff = 0;
        for (Map.Entry<Character, Integer> entry : cnt.entrySet()) {
            if (entry.getValue() != 0) {
                diff++;
            }
        }
        if (diff == 0) {
            return true;
        }
        for (int i = s1.length(); i < s2.length(); i++) {
            char cur = s2.charAt(i);
            char pre = s2.charAt(i - s1.length());

            if (pre == cur) {
                continue;
            }
            if (cnt.getOrDefault(pre, 0) == 0) {
                diff++;
            }
            Integer merge = cnt.merge(pre, -1, Integer::sum);
            if (merge == 0) {
                diff--;
            }

            if (cnt.getOrDefault(cur, 0) == 0) {
                diff++;
            }
            merge = cnt.merge(cur, 1, Integer::sum);
            if (merge == 0) {
                diff--;
            }
            if (diff == 0) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidboaoo";
        System.err.println(checkInclusion(s1, s2));
    }
}
