package lc;

/**
 * 1470. 重新排列数组
 * 给你一个数组 nums ，数组中有 2n 个元素，按 [x1,x2,...,xn,y1,y2,...,yn] 的格式排列。
 * <p>
 * 请你将数组按 [x1,y1,x2,y2,...,xn,yn] 格式重新排列，返回重排后的数组。
 */
public class 重新排列数组 {

    public static int[] shuffle(int[] nums, int n) {
        int[] newNums = new int[nums.length];
        int x = 0;
        for (int i = 0; i + n < nums.length; i++) {
            newNums[x] = nums[i];
            newNums[++x] = nums[i + n];
            x++;
        }
        return newNums;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2};
        //2, 3, 5, 4, 1, 7
        int[] shuffle = shuffle(nums, nums.length / 2);
    }

}
