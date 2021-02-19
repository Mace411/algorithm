package sort;

/**
 * 归并排序
 */
public class MergeSort {


    private static void mergeSort(int[] nums, int low, int high) {
        if (low == high) {
            return;
        }
        int mid = (low + high) / 2;
        mergeSort(nums, low, mid);
        mergeSort(nums, mid + 1, high);
        merge(nums, low, high);
    }
    /**
     * 在原址上修改数组的顺序
     *
     * @param nums
     * @param low
     * @param high
     */
    public static void merge(int[] nums, int low, int high) {
//        if (low == high) {
//            return;
//        }
        int mid = (low + high) / 2;
//        merge(nums, low, mid);
//        merge(nums, mid + 1, high);// mergeSort()只是把这部分给抽出来了
        int[] leftNums = new int[mid - low + 1];
        for (int i = 0; i < leftNums.length; i++) {
            leftNums[i] = nums[low + i];
        }
        int[] rightNums = new int[high - mid];
        for (int i = 0; i < rightNums.length; i++) {
            rightNums[i] = nums[mid + 1 + i];
        }
        int left = 0;
        int right = 0;
        for (int i = low; i <= high; i++) {
            if (leftNums[left] <= rightNums[right]) {
                nums[i] = leftNums[left];
                left++;
            } else {
                nums[i] = rightNums[right];
                right++;
            }
            if (left == leftNums.length) {
                System.arraycopy(rightNums, right, nums, i + 1, rightNums.length - right);
                break;
            }
            if (right == rightNums.length) {
                System.arraycopy(leftNums, left, nums, i + 1, leftNums.length - left);
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {5, 2, 4, 7, 1, 3, 2, 6};
        mergeSort(nums, 0, nums.length - 1);
        for (int num : nums) {
            System.err.print(num + "\t");
        }
    }
}
