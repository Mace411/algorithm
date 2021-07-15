package lc;

public class 二分查找 {


    private static int binarySearch(int[] arrays, int value) {
        int left = 0;
        int right = arrays.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (arrays[middle] < value) {
                left = middle + 1;
            } else if (arrays[middle] > value) {
                right = middle - 1;
            } else {
                return middle;
            }
        }
        // left == right还是没找到，就有返回-1
        return -1;
    }

    public static void main(String[] args) {
        int[] arrays = {1, 2, 3, 4};
        int result = binarySearch(arrays, 1);
        System.err.println(result);
    }

}
