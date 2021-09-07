package lc;

/**
 * 300. 最长递增子序列
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * <p>
 * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 */
public class 最长递增子序列 {

    public static int lengthOfLIS(int[] nums) {
        if (nums.length <= 0) {
            return 0;
        }
        int maxLength = 0;
        int preMin = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > preMin) {
                continue;
            }
            preMin = nums[i];
            int curLength = 0;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] >= nums[i]) {
                    curLength++;
                }
            }
            if (curLength > maxLength) {
                maxLength = curLength;
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
//        int[] nums = {Integer.MAX_VALUE, 0, 3, 8, 4, 2, 7};
//
//        System.err.println(lengthOfLIS(nums));
    }
}
