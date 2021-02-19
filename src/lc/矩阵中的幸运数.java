package lc;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个 m * n 的矩阵，矩阵中的数字 各不相同 。请你按 任意 顺序返回矩阵中的所有幸运数。
 * <p>
 * 幸运数是指矩阵中满足同时下列两个条件的元素：
 * <p>
 * 在同一行的所有元素中最小
 * 在同一列的所有元素中最大
 */
public class 矩阵中的幸运数 {
    public static List<Integer> luckyNumbers(int[][] matrix) {
        int[] rowMin = new int[matrix.length];
        int[] columnMax = new int[matrix[0].length];
        int rm = Integer.MAX_VALUE;
        int[] cm = new int[matrix[0].length];
        for (int i = 0; i < cm.length; i++) {
            cm[i] = Integer.MIN_VALUE;
        }
        for (int i = 0; i < matrix.length; i++) {
            rm = Integer.MAX_VALUE;
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] < rm) {
                    rowMin[i] = j;
                    rm = matrix[i][j];
                }
                if (matrix[i][j] > cm[j]) {
                    columnMax[j] = i;
                    cm[j] = matrix[i][j];
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < rowMin.length; i++) {
            if (matrix[i][rowMin[i]] == matrix[columnMax[rowMin[i]]][rowMin[i]]) {
                result.add(matrix[i][rowMin[i]]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
//        int[][] nums = {{3, 7, 8},
//                        {9, 11, 13},
//                        {15, 16, 17}};
        int[][] nums = {{1,10,4,2},
                        {9,3,8,7},
                        {15,16,17,12}};
        List<Integer> integers = luckyNumbers(nums);

    }
}
