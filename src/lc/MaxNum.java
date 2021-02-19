package lc;

public class MaxNum {

    public static int getMaxNum(int[] nums) {
        if (nums.length <= 2) {
            return nums[0];
        }
        int count = 1;
        int curNum = nums[0];//初始状态 f(0) = nums[0]
        int haft = nums.length % 2 == 0 ? nums.length / 2 : nums.length / 2 + 1;
        for (int i = 1; i < nums.length; i++) {
            if (count >= haft) {
                break;
            }
            //f(i) = f(i - 1) + 1 || f (i - 1) - 1 || nums[i]
            if (count == 0) {
                curNum = nums[i];
                count++;
                continue;
            }
            if (curNum == nums[i]) {
                count++;
                continue;
            }
            if (curNum != nums[i]) {
                count--;
                continue;
            }
        }
        return curNum;
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 5, 5, 5, 5, 1, 2, 2, 2};
        System.err.println(getMaxNum(nums));
    }
}
