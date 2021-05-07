package sort;

public class QuickSort {

//    private static void quickSort(int[] nums, int low, int high) {
//        if (low >= high) {
//            return;
//        }
//        int p, i, j, temp;
//        p = nums[low];//取第一个数为基准值
//        i = low;
//        j = high;
//        while (i < j) {
//            while (nums[j] >= p && i < j) {//右边先开始
//                j--;
//            }
//            while (p >= nums[i] && i < j) {//左边
//                i++;
//            }
//            temp = nums[i];
//            nums[i] = nums[j];
//            nums[j] = temp;
//
//        }
//        //到这里肯定是i == j,这个位置也就是p应该放的位置,交换基准值和这个位置的值
//        nums[low] = nums[i];
//        nums[i] = p;
//        //继续排序
//        quickSort(nums, low, i - 1);//左边的
//        quickSort(nums, i + 1, high);//右边的
//    }

    //主方法
    public static void quickSort(int arr[], int left, int right) {
        int pivot;
        if (left < right) {
            //以pivot为枢轴，较之小的元素在左，较之大的元素在右
            pivot = partition(arr, left, right);
            //对左边的元素调用快速排序
            quickSort(arr, left, pivot - 1);
            //对右边数组调用快速排序
            quickSort(arr, pivot + 1, right);
        }

    }

    //快速排序算法的切割链表
    public static int partition(int arr[], int left, int right) {
        int pivotkey = arr[left];
        //枢轴选中后永远不变，最终在中间，前边小后变大
        while (left < right) {
            while (left < right && arr[right] >= pivotkey) {
                --right;
            }
            arr[left] = arr[right];
            //此时arr[left]为空，不过它的值保存着pivot中
            while (left < right && arr[left] <= pivotkey) {
                ++left;
            }
            arr[right] = arr[left];


        }
        arr[left] = pivotkey;
        return left;
    }

    public static void main(String[] args) {
        int nums[] = {3, 2, 4, 5, 6, 7, 2, 9, 6, 4/*4, 6, 9, 2, 7, 6, 5, 4, 2, 3*/};
        quickSort(nums, 0, nums.length - 1);
        for (int num : nums) {
            System.err.print(num + "\t");
        }
    }
}
