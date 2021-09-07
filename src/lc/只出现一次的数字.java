package lc;

/**
 * 136. 只出现一次的数字
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * <p>
 * 说明：
 * <p>
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 * <p>
 * 输入: [4,1,2,1,2]
 * 输出: 4
 */
public class 只出现一次的数字 {

    /**
     * 使用位运算
     *
     * @param nums
     * @return
     */
    public static int singleNumber(int[] nums) {
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result ^= nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
//        int[] nums = {1, 1, 2, 2, 3, 4, 3, 5, 4};
//        System.err.println(singleNumber(nums));

        int a = 3;
        int b = 6;
        System.err.println(Integer.toBinaryString(~(a^ b)));
    }


}
