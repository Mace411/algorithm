package lc;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 695. 岛屿的最大面积
 * 给定一个包含了一些 0 和 1 的非空二维数组 grid 。
 * <p>
 * 一个 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在水平或者竖直方向上相邻。你可以假设 grid 的四个边缘都被 0（代表水）包围着。
 * <p>
 * 找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为 0 。)
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * [[0,0,1,0,0,0,0,1,0,0,0,0,0],
 * [0,0,0,0,0,0,0,1,1,1,0,0,0],
 * [0,1,1,0,1,0,0,0,0,0,0,0,0],
 * [0,1,0,0,1,1,0,0,1,0,1,0,0],
 * [0,1,0,0,1,1,0,0,1,1,1,0,0],
 * [0,0,0,0,0,0,0,0,0,0,1,0,0],
 * [0,0,0,0,0,0,0,1,1,1,0,0,0],
 * [0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * 对于上面这个给定矩阵应返回 6。注意答案不应该是 11 ，因为岛屿只能包含水平或垂直的四个方向的 1 。
 * <p>
 * 示例 2:
 * <p>
 * [[0,0,0,0,0,0,0,0]]
 * 对于上面这个给定的矩阵, 返回 0。
 */
public class 岛屿的最大面积 {

    public static int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        int rowLen = grid.length;
        int colLen = grid[0].length;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] != 1) {
                    continue;
                }
                grid[i][j] = Integer.MAX_VALUE;
                int area = 1;
                Queue<int[]> queue = new LinkedList<>();
                queue.offer(new int[]{i, j});
                while (!queue.isEmpty()) {
                    int[] poll = queue.poll();
                    // 上
                    if (poll[0] > 0 && grid[poll[0] - 1][poll[1]] == 1) {
                        queue.offer(new int[]{poll[0] - 1, poll[1]});
                        grid[poll[0] - 1][poll[1]] = Integer.MAX_VALUE;
                        area++;
                    }
                    // 下
                    if (poll[0] + 1 < rowLen && grid[poll[0] + 1][poll[1]] == 1) {
                        queue.offer(new int[]{poll[0] + 1, poll[1]});
                        grid[poll[0] + 1][poll[1]] = Integer.MAX_VALUE;
                        area++;
                    }
                    // 左
                    if (poll[1] > 0 && grid[poll[0]][poll[1] - 1] == 1) {
                        queue.offer(new int[]{poll[0], poll[1] - 1});
                        grid[poll[0]][poll[1] - 1] = Integer.MAX_VALUE;
                        area++;
                    }
                    // 右
                    if (poll[1] + 1 < colLen && grid[poll[0]][poll[1] + 1] == 1) {
                        queue.offer(new int[]{poll[0], poll[1] + 1});
                        grid[poll[0]][poll[1] + 1] = Integer.MAX_VALUE;
                        area++;
                    }
                }
                maxArea = Math.max(maxArea, area);
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[][] grid = {{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
        int i = maxAreaOfIsland(grid);
        System.err.println(i);
    }
}