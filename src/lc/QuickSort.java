package lc;

public class QuickSort {

    private static void quickSort(int[] nums, int low, int high) {
        int p, i, j, temp;
        if (low >= high) {
            return;
        }
        p = nums[low];//取第一个数为基准值
        i = low;
        j = high;
        while (i < j) {
            while (nums[j] >= p && i < j) {//右边先开始
                j--;
            }
            while (p >= nums[i] && i < j) {//左边
                i++;
            }
            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;

        }
        //到这里肯定是i == j,这个位置也就是p应该放的位置,交换基准值和这个位置的值
        nums[low] = nums[i];
        nums[i] = p;
        //继续排序
        quickSort(nums, low, i - 1);//左边的
        quickSort(nums, i + 1, high);//右边的
    }

    public static void main(String[] args) {
        int nums[] = {9, 5, 8, 6 ,7};
        quickSort(nums, 0, nums.length - 1);
        for (int num : nums) {
            System.err.print(num + "\t");
        }
    }
}
