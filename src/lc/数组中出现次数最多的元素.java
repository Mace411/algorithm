package lc;

public class 数组中出现次数最多的元素 {


    private static int appearTimeMax(int[] nums) {
        int curElem = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (curElem == nums[i]) {
                count++;
            } else {
                if (count == 0) {
                    curElem = nums[i];
                    count++;
                } else {
                    count--;
                }
            }
        }
        return curElem;
    }

    public static void main(String[] args) {
        int[] nums = {1, 8, 3, 8, 56, 5, 5, 8, 8, 8, 8, 8, 7, 8, 47, 8, 17, 8};
        System.err.println(appearTimeMax(nums));
//        StackOverflowError
//        OutOfMemoryError
    }

}
