package lc;

/**
 * 198. 打家劫舍
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * <p>
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1,2,3,1]
 * 输出：4
 * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 * 偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 2：
 * <p>
 * 输入：[2,7,9,3,1]
 * 输出：12
 * 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 * 偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 */
public class 打家劫舍 {

    /**
     * f(n)n个房子的最高金额
     * f(i) = Max(f(i - 2) + value(i), f(i - 1))
     *
     * @param nums
     * @return
     */
    public static int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        //只有一个房子，必偷
        if (nums.length == 1) {
            return nums[0];
        }
        int f_2 = nums[0];// 表示 f(i - 2)的位置上的最优解
        int f_1 = Math.max(nums[0], nums[1]);// 表是 f(i - 1)位置上的最优解
        for (int i = 2; i < nums.length; i++) {
            int temp = f_1;
            f_1 = Math.max(f_2 + nums[i], f_1);
            f_2 = temp;
        }
        return f_1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 2, 3, 100};
        System.err.println(rob(nums));
    }


}
