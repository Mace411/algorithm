package lc;

/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 *
 * 示例:
 * 输入: [2,1,1,3,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 */
public class 跳跃游戏2 {
    /**
     * 最后一步跳跃希望的是从能到达最后位置的且离最后位置最远的点跳，即index + nums[index] >= 最后位置index，且index最小
     * 时间复杂度O(n^2)，空间复杂度O(1)
     * @param nums
     * @return
     */
    public static int jump0(int[] nums) {
        int position = nums.length - 1;
        int steps = 0;
        while (position > 0) {
            for (int i = 0; i < position; i++) {
                //从左到右，找到第一个能到达最后位置的点
                if (i + nums[i] >= position) {
                    //把当前点作为最后位置
                    position = i;
                    steps++;
                    break;
                }
            }
        }
        return steps;
    }

    /**
     * 从左往右推
     * 每次选取当前能到达的点里的最大值，即max(nums[index + 1],nums[index + 2]...num[index+nums[index]])
     * @param nums
     * @return
     */
    public static int jump1(int[] nums) {
        int length = nums.length;
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }
}
