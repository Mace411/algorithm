package lc;

import java.util.ArrayList;
import java.util.List;

/**
 * 120. 三角形最小路径和
 * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
 * <p>
 * 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
 * 输出：11
 * 解释：如下面简图所示：
 * 2
 * 3 4
 * 6 5 7
 * 4 1 8 3
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 * 示例 2：
 * <p>
 * 输入：triangle = [[-10]]
 * 输出：-10
 */
public class 三角形最小路径和 {

    /**
     * dp
     * F(i,j)是从顶点到下标为ij的点的最小路径
     * F(i,j) = min(F(i-1,j), F(i-1,j-1)) + value(i,j)
     * 初始化
     * F(0,0) = value(0,0)
     * F(1,0) = F(0,0) + value(1,0)
     * F(1,1) = F(0,0) +  value(1,1)
     *
     * @param triangle
     * @return
     */
    public static int minimumTotal(List<List<Integer>> triangle) {
        int min = triangle.get(0).get(0);
        if (triangle.size() <= 1) {
            return min;
        }
        List<Integer> lastMin = new ArrayList<>();
        lastMin.add(min);
        for (int i = 1; i < triangle.size(); i++) {
            lastMin.add(Integer.MAX_VALUE);
        }
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> curRow = triangle.get(i);
            int upPre = Integer.MAX_VALUE;
            for (int j = 0; j < curRow.size(); j++) {
                int up = lastMin.get(j);
                lastMin.set(j, Math.min(upPre, up) + curRow.get(j));
                upPre = up;
            }
        }
        min = Integer.MAX_VALUE;
        for (Integer count : lastMin) {
            min = count < min ? count : min;
        }
        return min;
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(2);
        triangle.add(list);
        list = new ArrayList<>();
        list.add(3);
        list.add(4);
        triangle.add(list);
        list = new ArrayList<>();
        list.add(6);
        list.add(5);
        list.add(7);
        triangle.add(list);
        list = new ArrayList<>();
        list.add(4);
        list.add(1);
        list.add(8);
        list.add(3);
        triangle.add(list);
        int i = minimumTotal(triangle);
        System.err.println(i);
    }

}
