package lc;

import java.util.Random;

/**
 * 给定一个乱序的数组，找出数组中比其左边的元素大，比右边元素小的数
 */
public class 数组中比左边大比右边小的元素 {

    /**
     * 找出一个
     *
     * @param nums
     * @return
     */
    private static int findMiddleNum(int[] nums) {
        //先使用第一个数来尝试，第一个数左边没有数，不用管
        int cur = nums[0];
        //当前遍历过的数中最大的数
        int curMax = nums[0];
        //遍历数组,从第二个数开始遍历
        int i = 1;
        while (i < nums.length) {
            //假如比当前尝试的数小，则当前的数不符合条件，而且index = i之前的数都不符合条件，从index = i + 1开始继续找
            if (nums[i] < cur) {
                //如果i + 1的数 < curMax，则这个位置的数也不符合条件，继续往后找
                while (i + 1 < nums.length && nums[++i] < curMax) {
                    //只是让i自增
                }
                cur = nums[i];
                //解决数组中不存在符合条件的数的情况
                if (i + 1 == nums.length && cur < curMax) {
                    return Integer.MIN_VALUE;
                }
            }
            curMax = Math.max(curMax, nums[i]);
            i++;
        }
        return cur;
    }

    /**
     * 上面的方法不好看，这个算法是O(n)的复杂度，应该一个for循环搞定
     *
     * @param nums
     * @return
     */
    private static int findMiddleNum0(int[] nums) {
        //先使用第一个数作为候选数，第一个数左边没有数，不用管
        int cur = nums[0];
        //候选数是不是合适的
        boolean exist = true;
        //当前遍历过的数中最大的数
        int curMax = nums[0];
        //遍历数组,从第二个数开始遍历
        for (int i = 1; i < nums.length; i++) {
            if (exist) {
                //当前候选数不符合，则从下一个数开始寻找符合的候选数
                if (cur > nums[i]) {
                    exist = false;
                }
            } else {
                if (nums[i] > curMax) {
                    cur = nums[i];
                    exist = true;
                }
            }
            curMax = Math.max(curMax, nums[i]);
        }
        return exist ? cur : Integer.MIN_VALUE;
    }

    /**
     * 找出全部的符合条件的数，返回下标
     * 这里需要找一个思路，其实符合条件的数，就是比左边的最大值大，比右边的最小值小的数，
     * 这个候选数的位置是变化的，所以左右区间的最大最小值也是在变化，所以需要存储
     * 可以先遍历一遍数组，找到右区间的最小值，用一个数组来存放
     * 这里有个点，求右区间最小值的时候，为了方便下标，存储最小值的数组大小跟原数组一样，最后一个位置设为一个很大的数，因为右边已经没有数了，
     * 只要看左边的就可以了，取数的时候，用原数组候选数的下标去右区间最小值数组取到的就是这个数右边区间的最小值
     * 数组的这些关系最好画图来解决，不然容易出错，而且画图画多了，对这类问题应该更加容易想象。
     * 时间复杂度O(n),遍历了两次数组。空间复杂度是O(n),需要一个跟原数组一样大小的右区间最小值数组
     * @param nums
     * @return
     */
    private static int[] findAllMiddleNums(int[] nums) {
        //存储后区间的最小值，即[候选数index,nums.length-1]之间的最小值
        int[] rightMinArray = new int[nums.length];
        int rightMin = Integer.MAX_VALUE;
        rightMinArray[rightMinArray.length - 1] = rightMin;
        //遍历一遍数组，找出右区间的最小值
        for (int i = nums.length - 2; i >= 0; i--) {
            rightMin = Math.min(rightMin, nums[i + 1]);
            rightMinArray[i] = rightMin;
        }
        int[] array = new int[nums.length];
        int arrayIndex = 0;
        int leftMax = Integer.MIN_VALUE;
        //正序遍历数组，找到所有符合条件的数
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > leftMax) {
                if (nums[i] < rightMinArray[i]) {
                    array[arrayIndex++] = i;
                }
                leftMax = nums[i];
            }
        }
        int[] finalArray = new int[arrayIndex];
        System.arraycopy(array, 0, finalArray, 0, arrayIndex);
        return finalArray;
    }


    public static void main(String[] args) {
//        int[] nums = {2,1,3,4,5,8,7,6,4};//3
//        int[] nums = {2,1,3,4,5,8,2,6,4};//不存在符合条件的数
//        int[] nums = {9,8,7,6,5,4,3,2,1,99};//99
//        int[] nums = new int[20];
//        Random random = new Random();
//        for (int i = 0; i < 20; i++) {
//            nums[i] = random.nextInt(100);
//            System.err.print(nums[i] + "\t");
//        }
//        System.err.println();
//        int middleNum = findMiddleNum0(nums);
//        System.err.println(middleNum);
//        int nArr[] = {1,2,3,1,2,0,5,6};
        int nArr[] = {1,2,3,4,5,6,7};
        int[] allMiddleNums = findAllMiddleNums(nArr);
        for (int allMiddleNum : allMiddleNums) {
            System.err.print(nArr[allMiddleNum] + "\t");
        }
    }
}
