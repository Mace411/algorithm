package lc;

/**
 * 41. 缺失的第一个正数
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 * <p>
 * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,0]
 * 输出：3
 * 示例 2：
 * <p>
 * 输入：nums = [3,4,-1,1]
 * 输出：2
 * 示例 3：
 * <p>
 * 输入：nums = [7,8,9,11,12]
 * 输出：1
 */
public class 缺失的第一个整数 {
    /**
     * 利用原数组做为一个hash表，第一个元素的位置对应数字1，第二个元素的地方对应数字2...
     * 先把负数转成比数组长度大的数
     * 然后把出现了的正整数做一个标记，把他们hash对应数组的位置变成负数，那么最后，数组中第一个不是负数的地方就是缺少的最小整数
     *
     * @param nums
     * @return
     */
    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;
        //先把非正数全部换成比n大的数
        for (int i = 0; i < n; ++i) {
            if (nums[i] <= 0) {
                nums[i] = n + 1;
            }
        }
        // 和hashMap原理一样
        for (int i = 0; i < n; ++i) {
            int num = Math.abs(nums[i]);
            if (num <= n) {
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }
        for (int i = 0; i < n; ++i) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return n + 1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 9, 5, 4, 3, 7, 10};
        int i = firstMissingPositive(nums);
        System.err.println(i);
    }
}
