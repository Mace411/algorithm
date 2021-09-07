package lc;

import java.util.StringJoiner;

/**
 * 167. 两数之和 II - 输入有序数组
 * 给定一个已按照 升序排列  的整数数组 numbers ，请你从数组中找出两个数满足相加之和等于目标数 target 。
 * <p>
 * 函数应该以长度为 2 的整数数组的形式返回这两个数的下标值。numbers 的下标 从 1 开始计数 ，所以答案数组应当满足 1 <= answer[0] < answer[1] <= numbers.length 。
 * <p>
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：numbers = [2,7,11,15], target = 9
 * 输出：[1,2]
 * 解释：2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 */
public class 两数之和II输入有序数组 {

    /**
     * 二分查找 O(nlogn)
     *
     * @param numbers
     * @param target
     * @return
     */
    public static int[] twoSum(int[] numbers, int target) {
        int[] answer = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            int num2 = target - numbers[i];
            int index = binarySearch(numbers, i + 1, numbers.length - 1, num2);
            if (index != -1) {
                answer[0] = i + 1;
                answer[1] = index + 1;
                break;
            }
        }
        return answer;
    }

    public static int binarySearch(int[] nums, int start, int end, int target) {
        if (start > end) {
            return -1;
        }
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                start = mid + 1;
            }
            if (nums[mid] > target) {
                end = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 双指针 O(n)
     *
     * @param numbers
     * @param target
     * @return
     */
    public static int[] twoSum1(int[] numbers, int target) {
        int[] answer = new int[2];
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int result = numbers[left] + numbers[right];
            if (result == target) {
                answer[0] = left + 1;
                answer[1] = right + 1;
                break;
            }
            if (result < target) {
                left++;
            } else {
                right--;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] twoSum = twoSum1(new int[]{-1, 0/*2, 7, 11, 15*/}, -1);
        for (int i : twoSum) {
            System.err.print(i + "\t");
        }
    }



}
