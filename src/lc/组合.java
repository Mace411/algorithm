package lc;

import java.util.ArrayList;
import java.util.List;

/**
 * 77. 组合
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * <p>
 * 你可以按 任何顺序 返回答案。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 4, k = 2
 * 输出：
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 * 示例 2：
 * <p>
 * 输入：n = 1, k = 1
 * 输出：[[1]]
 */
public class 组合 {

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (k > n) {
            return result;
        }
        List<Integer> mark = new ArrayList<>();
        for (int i = n; i > n - k; i--) {
            mark.add(i);
        }
        while (mark.get(0) >= k) {
            Integer change = mark.get(mark.size() - 1);
            for (int i = change; i > 0; i--) {
                List<Integer> list = new ArrayList<>(mark);
                list.set(mark.size() - 1, i);
                result.add(list);
            }
            int offset = 2;
            int index = mark.size() - offset;
            while (index >= 0) {
                int curChange = mark.get(index);
                if (curChange > offset) {
                    for (int i = index; i < mark.size(); i++) {
                        mark.set(i, --curChange);
                    }
                    break;
                } else {
                    index--;
                    offset++;

                }
            }
            //已经不能再找到新的组合了
            if (index == -1) {
                mark.set(0, -1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 1;
        int k = 1;
        List<List<Integer>> combine = combine(n, k);
        for (List<Integer> list : combine) {
            for (Integer num : list) {
                System.err.print(num + "\t");
            }
            System.err.println();
        }

    }


}
