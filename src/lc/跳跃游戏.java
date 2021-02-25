package lc;

/**
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 判断你是否能够到达最后一个下标。
 * <p>
 * 示例 1：
 * 输入：nums = [2,3,1,1,1]
 * 输出：true
 * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 * <p>
 * 示例 2：
 * 输入：nums = [3,2,1,0,1]
 * 输出：false
 * 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
 */
public class 跳跃游戏 {

    /**
     * @param nums
     * @return
     */
    public static boolean canJump(int[] nums) {
        //遍历数组,更新能到达的最远的位置,位置x能到达的最远位置为x+nums[x],出现x>目前能到达的最远位置，则表示不可达
        int maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            if (maxLen >= i) {
                maxLen = Math.max(nums[i] + i, maxLen);
                if (maxLen > nums.length) {
                    return true;
                }
            }
            if (i > maxLen) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        int[] nums = {2, 3, 2, 1, 0, 1};
        System.err.println(canJump(nums));
    }

}
