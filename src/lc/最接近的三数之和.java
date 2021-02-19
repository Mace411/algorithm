package lc;

import java.util.Arrays;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 */
public class 最接近的三数之和 {

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
//            if () {
//
//            }
            sum = nums[i] + nums[i + 1] + nums[i + 2];
        }
        return sum;
    }
}
