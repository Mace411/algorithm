package lc;

import java.util.Random;

/**
 * 分治策略
 * 找到数组中和最大的子数组
 */
public class 数组中和最大的子数组 {

    /***
     * 暴力解法，时间复杂度O(n^2)
     * 处理了重复计算的问题
     * @param nums
     * @return 子数组在原数组的下标
     */
    private static int[] findMaxSubArray(int[] nums) {
        if (nums.length <= 1) {
            return new int[]{0, 0};
        }
        int[] maxArrayIndex = new int[2];
        int max = Integer.MIN_VALUE;
//        int a = 0;
//        int b = 0;
//        int c = 0;
//        int d = 0;
        for (int i = 1; i <= nums.length; i++) {//元素个数
            int sum = 0;
//            a++;
            for (int j = 0; j + i < nums.length; j++) {//坐标
                if (j == 0) {
                    for (int k = 0; k < i; k++) {//O(n^2)
                        sum += nums[j + k];
//                        b++;
                    }
                } else {
                    sum = sum + nums[j + i - 1] - nums[j - 1];
//                    c++;
                }
                if (sum > max) {
                    max = sum;
                    maxArrayIndex[0] = j;
                    maxArrayIndex[1] = j + i - 1;
                }
//                d++;
            }
        }
//        System.err.println("a:" + a + "\t" + "b:" + b + "\t" + "c:" + c + "\t" + "d:" + d);
        return maxArrayIndex;
    }

    /**
     * @param nums
     * @param low
     * @param high
     * @return 最大和，左下标，右下标
     */
    private static int[] findMaxSubArray(int[] nums, int low, int high) {
        if (low == high) {
            return new int[]{nums[low], low, high};
        }
        int mid = (low + high) / 2;
        int[] leftMaxSubArray = findMaxSubArray(nums, low, mid);
        int[] rightMaxSubArray = findMaxSubArray(nums, mid + 1, high);
        int[] mergeMaxSubArrayMerge = findMaxSubArrayMerge(nums, low, mid, high);
        if (leftMaxSubArray[0] >= rightMaxSubArray[0] && leftMaxSubArray[0] >= mergeMaxSubArrayMerge[0]) {
            return leftMaxSubArray;
        } else if (rightMaxSubArray[0] >= leftMaxSubArray[0] && rightMaxSubArray[0] >= mergeMaxSubArrayMerge[0]) {
            return rightMaxSubArray;
        } else {
            return mergeMaxSubArrayMerge;
        }
    }

    private static int[] findMaxSubArrayMerge(int[] nums, int low, int mid, int high) {
        int sum = 0;
        int left = mid;
        int leftMax = Integer.MIN_VALUE;
        for (int i = mid; i >= low; i--) {
            sum += nums[i];
            if (sum > leftMax) {
                left = i;
                leftMax = sum;
            }
        }
        int right = mid + 1;
        int rightMax = Integer.MIN_VALUE;
        sum = 0;
        for (int i = mid + 1; i <= high; i++) {
            sum += nums[i];
            if (sum > rightMax) {
                right = i;
                rightMax = sum;
            }
        }
        return new int[]{leftMax + rightMax, left, right};
    }

    public static void main(String[] args) {
        int[] nums = new int[100000];
        Random random = new Random();
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (int) (random.nextInt(1000) * (Math.pow(-1, i)));
            System.err.print(nums[i] + "\t");
        }
        System.err.println();
//        int[] nums = {13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7, 13, -3, -25, 20, -3, -23, 18, 20, -7, 12, 12, -5, -22, 15, -4, 7, 13, -3, -25, 20, -3};

        long start = System.currentTimeMillis();
        int[] maxSubArray = findMaxSubArray(nums);
        System.err.println("暴力解法耗时:" + (System.currentTimeMillis() - start));
        System.err.println(maxSubArray[0] + "\t" + maxSubArray[1]);

        start = System.currentTimeMillis();
        int[] maxSubArray0 = findMaxSubArray(nums, 0, nums.length - 1);
        for (int i : maxSubArray0) {
            System.err.print(i + "\t");
        }
        System.err.println();
        System.err.println("分治法耗时:" + (System.currentTimeMillis() - start));
    }


}
