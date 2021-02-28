package lc;

import java.util.ArrayDeque;

public class 跳跃游戏3 {

    private static boolean canReach(int[] arr, int start) {
        if (arr[start] == 0) {
            return true;
        }
        int n = arr.length;
        boolean[] used = new boolean[arr.length];
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.push(start);
        used[start] = true;

        while (!queue.isEmpty()) {
            int u = queue.getFirst();
            queue.pop();
            if (u + arr[u] < n && !used[u + arr[u]]) {
                if (arr[u + arr[u]] == 0) {
                    return true;
                }
                queue.push(u + arr[u]);
                used[u + arr[u]] = true;
            }
            if (u - arr[u] >= 0 && !used[u - arr[u]]) {
                if (arr[u - arr[u]] == 0) {
                    return true;
                }
                queue.push(u - arr[u]);
                used[u - arr[u]] = true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {4, 2, 3, 0, 3, 1, 2};
        int start = 5;
        System.err.println(canReach(nums, start));
    }
}
