package lc;

/**
 * 189. 旋转数组
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * <p>
 * 进阶：
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 你可以使用空间复杂度为 O(1) 的 原地 算法解决这个问题吗？
 */
public class 旋转数组 {
    /**
     * O(kn)
     */
    public static void rotate(int[] nums, int k) {
        if (nums.length <= 1) {
            return;
        }
        k = k % nums.length;
        for (int i = 1; i <= k; i++) {
            int temp = nums[nums.length - 1];
            for (int j = nums.length - 1; j > 0; j--) {
                nums[j] = nums[j - 1];
                nums[j - 1] = temp;
            }
        }
    }

    /**
     * O(n)
     * 为每一个元素找到其位置，用temp记录被替换的元素的值，但是要注意回到初始位置，重复
     */
    public static void rotate1(int[] nums, int k) {
        if (nums.length <= 1) {
            return;
        }
        k = k % nums.length;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count >= nums.length) {
                return;
            }
            int current = i;
            int next;
            int temp = nums[current];
            for (int j = 0; j < nums.length; j++) {
                next = (current + k) % nums.length;
                int nextTemp = nums[next];
                nums[next] = temp;
                temp = nextTemp;
                current = next;
                count++;
                if (current == i) {
                    break;
                }
            }
        }
    }

    public static void rotate2(int[] nums, int k) {
        if (nums.length <= 1) {
            return;
        }
        k = k % nums.length;
        // 逆序
        for (int i = 0; i < nums.length / 2; i++) {
            int temp = nums[i];
            nums[i] = nums[nums.length - 1 - i];
            nums[nums.length - 1 - i] = temp;
        }
        for (int i = 0; i < k / 2; i++) {
            int temp = nums[i];
            nums[i] = nums[k - 1 - i];
            nums[k - 1 - i] = temp;
        }
        for (int i = 0; i < (nums.length - k) / 2; i++) {
            int temp = nums[k + i];
            nums[k + i] = nums[nums.length - i - 1];
            nums[nums.length - i - 1] = temp;
        }
    }


    public static void main(String[] args) {
        int[] nums = /*{-1, -100, 3, 99}*/{1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        rotate2(nums, k);
        for (int num : nums) {
            System.err.print(num + "\t");
        }
    }
}
