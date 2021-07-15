package lc;

import java.util.Stack;

public class 栈实现排序 {

    public static void stackSort(Stack<Integer> nums) {
        Stack<Integer> sortNums = new Stack<>();
        while (!nums.empty()) {
            int cur = nums.pop();
            //如果空的就直接放进去
            if (sortNums.isEmpty()) {
                sortNums.add(cur);
            } else {
                int temp = sortNums.peek();
                //把比cur小的元素出栈，压回nums里面。直到找到比cur大的数，把cur压进sortNums中
                if (temp < cur) {
                    while (temp < cur && !sortNums.isEmpty()) {
                        temp = sortNums.pop();
                        nums.add(temp);
                    }
                }
                sortNums.add(cur);
            }
        }
        // 把sortNums中的元素倒回到nums中
        while (!sortNums.isEmpty()) {
            nums.add(sortNums.pop());
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.add(5);
        stack.add(3);
        stack.add(4);
        stack.push(1);
        stack.push(2);
        stackSort(stack);
        while (!stack.isEmpty()) {
            System.err.print(stack.pop() + "\t");
        }
    }

}

