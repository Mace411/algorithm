package lc;

/**
 * 1818. 绝对差值和
 * 给你两个正整数数组 nums1 和 nums2 ，数组的长度都是 n 。
 * <p>
 * 数组 nums1 和 nums2 的 绝对差值和 定义为所有 |nums1[i] - nums2[i]|（0 <= i < n）的 总和（下标从 0 开始）。
 * <p>
 * 你可以选用 nums1 中的 任意一个 元素来替换 nums1 中的 至多 一个元素，以 最小化 绝对差值和。
 * <p>
 * 在替换数组 nums1 中最多一个元素 之后 ，返回最小绝对差值和。因为答案可能很大，所以需要对 109 + 7 取余 后返回。
 */
public class 绝对差值和 {

    public static int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int sum = 0;
        int max = 0;
        int index = -1;
        for (int i = 0; i < nums1.length; i++) {
            int result = Math.abs(nums1[i] - nums2[i]);
            if (result > max) {
                max = result;
                index = i;
            }
            sum += result;
        }
        System.err.println("最大的差值：" + max + "\t索引值：" + index);
        if (index > -1) {
            int replaceIndex = -1;
            for (int i = 0; i < nums1.length; i++) {
                int temp = Math.abs(nums1[i] - nums2[index]);
                if (temp < max) {
                    max = temp;
                    replaceIndex = i;
                }
                // 如果找到差值为0的，提前退出
                if (temp == 0) {
                    break;
                }
            }
            if (replaceIndex > -1) {
                sum -= Math.abs(nums1[index] - nums2[index]);
                nums1[index] = nums1[replaceIndex];
                sum += max;
            }
        }
        return (int) (sum % (10e9 + 7));
    }

    public static void main(String[] args) {
//        int[] nums1 = {1,10,5}, nums2 = {2,3,5};
////        int[] nums1 = {57,42,21,28,30,25,22,12,55,3,47,18,43,29,20,44,59,9,43,7,8,5,42,53,99,34,37,88,87,62,38,68,31,3,11,61,93,34,63,27,20,48,38,5,71,100,88,54,52,15,98,59,74,26,81,38,11,44,25,69,79,81,51,85,59,84,83,99,31,47,31,23,83,70,82,79,86,31,50,17,11,100,55,15,98,11,90,16,46,89,34,33,57,53,82,34,25,70,5,1},
////                nums2 = {76,3,5,29,18,53,55,79,30,33,87,3,56,93,40,80,9,91,71,38,35,78,32,58,77,41,63,5,21,67,21,84,52,80,65,38,62,99,80,13,59,94,21,61,43,82,29,97,31,24,95,52,90,92,37,26,65,89,90,32,27,3,42,47,93,25,14,5,39,85,89,7,74,38,12,46,40,25,51,2,19,8,21,62,58,29,32,77,62,9,74,98,10,55,25,62,48,48,24,21};
//        System.err.println(minAbsoluteSumDiff(nums1, nums2));
//        for (int i = 0; i < nums1.length; i++) {
//            System.err.print(nums1[i] + " ");
//        }
//        System.err.println();
//        for (int i = 0; i < nums2.length; i++) {
//            System.err.print(nums2[i] + " ");
//        }
//        System.err.println();
        System.err.println(Runtime.getRuntime().availableProcessors());
    }


}
