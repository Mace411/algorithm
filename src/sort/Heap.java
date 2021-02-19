package sort;

/**
 * 堆
 */
public class Heap {
    /**
     * 元素
     */
    private int[] nums;
    /**
     * 堆的大小
     */
    private int size;

    public int[] getNums() {
        return nums;
    }

    public void setNums(int[] nums) {
        this.nums = nums;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Heap(int[] nums) {
        this.nums = nums;
        this.size = nums.length;
    }

    /**
     * 获取节点的父节点
     *
     * @param i 索引从0开始
     * @return
     */
    public int parent(int i) {
        if (i % 2 != 0) {
            return i >> 1;
        } else {
            return (i >> 1) - 1;
        }
        //todo 做判断
    }

    /**
     * 获取节点的左节点
     *
     * @param i 索引从0开始
     * @return
     */
    public int leftChild(int i) {
        return (i << 1) + 1;//todo 做判断
    }

    /**
     * 获取节点的右节点在数组中的索引
     *
     * @param i 索引从0开始
     * @return
     */
    public int rightChild(int i) {
        return (i << 1) + 2;//todo 做判断
    }

    /**
     * 构造大根堆
     *
     * @param nums
     * @return
     */
    public void buildMaxHeap(int[] nums) {
        if (size <= 1) {
            return;
        }
        for (int i = size / 2 - 1; i >= 0; i--) {
            maxHeapify(nums, i);
        }

    }

    /**
     * 维护大根堆
     * @param nums
     * @param i    在数组中的index
     */
    private void maxHeapify(int[] nums, int i) {
        int left = leftChild(i);
        int right = rightChild(i);
        int largest = i;
        if (left < size && nums[largest] < nums[left]) {
            largest = left;
        }
        if (right < size && nums[largest] < nums[right]) {
            largest = right;
        }
        if (largest == i) {
            return;
        }
        //交换值
        int temp = nums[i];
        nums[i] = nums[largest];
        nums[largest] = temp;
        //递归
        maxHeapify(nums, largest);
    }

    /**
     * 构建小根堆
     * @param nums
     */
    public void buildMinHeap(int[] nums) {
        if (size <= 1) {
            return;
        }
        for (int i = size / 2 - 1; i >= 0; i--) {
            minHeaify(nums, i);
        }
    }

    /**
     * 维护小根堆
     * @param nums
     * @param i
     */
    private void minHeaify(int[] nums, int i) {
        while (i < (size << 1)) {
            int left = leftChild(i);
            int right = rightChild(i);
            int minus = i;
            if (left < size && nums[minus] > nums[left]) {
                minus = left;
            }
            if (right < size && nums[minus] > nums[right]) {
                minus = right;
            }
            if (minus == i) {
                break;
            }
            int temp = nums[minus];
            nums[minus] = nums[i];
            nums[i] = temp;
            i = minus;
        }
//        minHeaify(nums, minus);//也可以用递归实现
    }

    /**
     * 堆排序（大根堆做顺序排序）
     */
    public void heapAscSort() {
        //先构建大根堆
        buildMaxHeap(nums);
        //从根开始遍历，直到剩下1个元素的时候，整个数组就已经是有序的了
        for (int i = size - 1; i > 0; i--) {
            int temp = nums[0];
            nums[0] = nums[size - 1];
            nums[size- 1] = temp;
            size--;
            maxHeapify(nums, 0);
        }
        size = nums.length;//因为上面修改了size的值，实际size还是数组的大小，所以重新赋值
    }

    /**
     * 堆排序（小根堆做倒序排序）
     */
    public void heapDescSort() {
        //先构建小根堆
        buildMinHeap(nums);
        //从根开始遍历，直到剩下1个元素的时候，整个数组就已经是有序的了
        for (int i = size - 1; i > 0; i--) {
            int temp = nums[0];
            nums[0] = nums[size - 1];
            nums[size- 1] = temp;
            size--;
            minHeaify(nums, 0);
        }
        size = nums.length;//因为上面修改了size的值，实际size还是数组的大小，所以重新赋值
    }
    public static void main(String[] args) {
        int[] nums = {4, 1, 3, 2, 16, 9, 10, 14, 8, 7};
//        buildMaxHeap(nums);
//        buildMinHeap(nums);
        Heap heap = new Heap(nums);
        heap.heapAscSort();
        for (int num : nums) {
            System.err.print(num + "\t");
        }
        System.err.println();
        heap.heapDescSort();
        for (int num : nums) {
            System.err.print(num + "\t");
        }
    }
}
