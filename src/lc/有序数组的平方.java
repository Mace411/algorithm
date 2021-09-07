package lc;

/**
 * 977. 有序数组的平方
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 解释：平方后，数组变为 [16,1,0,9,100]
 * 排序后，数组变为 [0,1,9,16,100]
 */
public class 有序数组的平方 {
    /**
     * 思想是归并排序，找到中间非负和负数的分界点，然后左右开始做归并排序
     * @param nums
     * @return
     */
    public static int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        if (nums.length <= 0) {
            return result;
        }
        int left = -1;
        int right = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                left = i - 1;
                right = i;
                break;
            }
        }
        // 排除全是负数的情况
        if (left == -1) {
            left = nums.length - 1;
        }
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (left < 0) {
                result[index++] = nums[right] * nums[right];
                right++;
                continue;
            }
            if (right >= nums.length) {
                result[index++] = nums[left] * nums[left];
                left--;
                continue;
            }
            if (nums[left] * nums[left] <= nums[right] * nums[right]) {
                result[index++] = nums[left] * nums[left];
                left--;
                continue;
            } else {
                result[index++] = nums[right] * nums[right];
                right++;
                continue;
            }

        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 4, 6, 7, 9, 10}/*{-10, -9, -6, -3, -1}*//*{-4,-1,0,3,10}*/;
        int[] result = sortedSquares(nums);
        for (int i : result) {
            System.err.println(i);
        }
    }


}
