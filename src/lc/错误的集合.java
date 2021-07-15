package lc;

import java.util.Arrays;
import java.util.Stack;

/**
 * 645. 错误的集合
 * 集合 s 包含从 1 到 n 的整数。不幸的是，因为数据错误，导致集合里面某一个数字复制了成了集合里面的另外一个数字的值，导致集合 丢失了一个数字 并且 有一个数字重复 。
 * <p>
 * 给定一个数组 nums 代表了集合 S 发生错误后的结果。
 * <p>
 * 请你找出重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。
 */
public class 错误的集合 {

    public static int[] findErrorNums(int[] nums) {
        int[] res = new int[2];
        Arrays.sort(nums);// 先做排序，让重复的元素连续
        int sum = 0;
        for( int i = 0; i < nums.length; ++i ){
            sum += nums[i];
            if( i > 0 && nums[i] == nums[i - 1] ){
                // 如果和前一位的数字相同，则这个数字就是重复的那个
                res[0] = nums[i];

            }
        }
        // 正确的sum - miss = 错误的sum - 重复的数字
        res[1] = (nums.length * (nums.length + 1)) / 2 - (sum - res[0]);
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,5,6,6,7,8,9};
        findErrorNums(nums);

        Stack<String[]> stack = new Stack<>();
        

    }

}
