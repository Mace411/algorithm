package lc;
/**
 * 11. 盛最多水的容器
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器。
 */
public class 盛最多水的容器 {


    public static int maxArea(int[] height) {
        if (height.length < 2) {
            return 0;
        }
        int left = 0;
        int right = height.length - 1;
        int maxWater = 0;
        while (left < right) {
            int x = right - left;
            int y = height[left] <= height[right] ? height[left++] : height[right--];
            if (x * y > maxWater) {
                maxWater = x * y;
            }
        }
        return maxWater;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,1,/*4,3,2,1,41,18,6,2,5,4,8,3,7*/};
        System.err.println(maxArea(nums));
    }
}
