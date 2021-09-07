package lc;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 542. 01 矩阵
 * 给定一个由 0 和 1 组成的矩阵 mat ，请输出一个大小相同的矩阵，其中每一个格子是 mat 中对应位置元素到最近的 0 的距离。
 * <p>
 * 两个相邻元素间的距离为 1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：mat = [[0,0,0],[0,1,0],[0,0,0]]
 * 输出：[[0,0,0],[0,1,0],[0,0,0]]
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：mat = [[0,0,0],[0,1,0],[1,1,1]]
 * 输出：[[0,0,0],[0,1,0],[1,2,1]]
 */
public class 矩阵 {

    private static int[][] result;

    public static int[][] updateMatrix(int[][] mat) {
        int row = mat.length;
        if (row <= 0) {
            return mat;
        }
        int col = mat[0].length;
        if (col <= 0) {
            return mat;
        }
        result = new int[row][col];
        int[] curPos = new int[2];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (mat[i][j] == 0) {
                    continue;
                }


            }
        }
        return new int[][]{};

    }

    static int distance(int[] curPos, int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        Queue<int[]> queue = new LinkedList<>();
//        curPos[0] = i;
//        curPos[1] = j;
        queue.offer(curPos);
        int[] zeroPos = new int[2];
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            //上
            if (curPos[0] - 1 >= 0) {
                if (mat[curPos[0] - 1][curPos[1]] == 0) {
                    zeroPos[0] = curPos[0] - 1;
                    zeroPos[1] = curPos[1];
                    break;
                }
                queue.offer(new int[]{curPos[0] - 1, curPos[1]});
            }
            //下

            //左

            //右
        }
        return 0;
    }

}
