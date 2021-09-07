package lc;

/**
 * 283. 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 * <p>
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 */
public class 移动零 {
    /**
     * 双指针
     *
     * @param nums
     */
    public static void moveZeroes(int[] nums) {
        if (nums.length <= 1) {
            return;
        }
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[slow] != 0 && nums[fast] == 0) {
                slow = fast;
                continue;
            }
            if (nums[slow] == 0 && nums[fast] != 0) {
                nums[slow] = nums[fast];
                nums[fast] = 0;
                slow++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes(nums);
        for (int num : nums) {
            System.err.print(num + "\t");
        }
    }
}
