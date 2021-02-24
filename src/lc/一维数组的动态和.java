package lc;

/**
 * 给你一个数组 nums 。数组「动态和」的计算公式为：runningSum[i] = sum(nums[0]…nums[i]) 。
 * <p>
 * 请返回 nums 的动态和。
 * <p>
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,6,10]
 * 解释：动态和计算过程为 [1, 1+2, 1+2+3, 1+2+3+4] 。
 */
public class 一维数组的动态和 {
    public static int[] runningSum(int[] nums) {
        int[] sum = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                sum[i] = nums[i];
                continue;
            }
            sum[i] = sum[i - 1] + nums[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 2, 10, 1};
        int[] ints = runningSum(nums);
        for (int anInt : ints) {
            System.err.print(anInt + "\t");
        }
    }
}
