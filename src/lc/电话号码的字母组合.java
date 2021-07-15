package lc;

import java.util.*;

/**
 * 17. 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 */
public class 电话号码的字母组合 {

    private final static Map<Character, String[]> num2String;

    static {
        num2String = new HashMap<>();
        num2String.put('2', new String[]{"a", "b", "c"});
        num2String.put('3', new String[]{"d", "e", "f"});
        num2String.put('4', new String[]{"g", "h", "i"});
        num2String.put('5', new String[]{"j", "k", "l"});
        num2String.put('6', new String[]{"m", "n", "o"});
        num2String.put('7', new String[]{"p", "q", "r", "s"});
        num2String.put('8', new String[]{"t", "u", "v"});
        num2String.put('9', new String[]{"w", "x", "y", "z"});
    }

    public static List<String> letterCombinations(String digits) {
        if ("".equals(digits)) {
            return Collections.EMPTY_LIST;
        }
        char[] nums = digits.toCharArray();
        if (nums.length <= 1) {
            return Arrays.asList(num2String.get(nums[0]));
        }
        Queue<String[]> queue = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            String[] strings = num2String.get(nums[i]);
            queue.add(strings);
            if (queue.size() >= 2) {
                // 开始合并
                String[] s1 = queue.poll();
                String[] s2 = queue.poll();
                List<String> list = new ArrayList<>();
                for (int j = 0; j < s1.length; j++) {
                    for (int k = 0; k < s2.length; k++) {
                        list.add(s1[j] + s2[k]);
                    }
                }
                queue.add(list.toArray(new String[0]));
            }
        }
        return Arrays.asList(queue.poll());
        // 时间复杂度O(3^m * 4^n),m对应的是输入的digits中，3个字母的数字的个数，n是4个字母的数字的个数，m + n = digits.length()
    }

    public static void main(String[] args) {
        String d = "234";
        List<String> result = letterCombinations(d);
    }

}
