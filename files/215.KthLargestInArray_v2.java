package solution;

/**
 * leetcode_215_数组中的第k个最大元素
 * @author Chenzf
 * @date 2020/7/25
 * @version 2.0 基于堆排序的选择方法
 */

public class KthLargestInArray_v2 {
    public static int findKthLargest(int[] nums, int k) {
        // heapSize->lastIndex
        int heapSize = nums.length;
        // 创建堆
        buildMaxHeap(nums, heapSize);

        /*
        将堆的最大值与最后一个值交换后，形成树与有序部分
        欲找第k个最大元素，就是需要k次maxHeapify，k-1次将堆中最大值移至有序部分
         (nums.length - 1)-(k-1) + 1=nums.length - k + 1
         */
        for (int i = nums.length - 1; i >= nums.length - k + 1; i--) {
            // 交换k-1次
            swap(nums, 0, i);
            heapSize--;
            maxHeapify(nums, 0, heapSize);
        }
        // 第k个最大元素尚未交换
        return nums[0];
    }

    /**
     * 将数组转化为堆
     * 从最靠近数组末尾的第一个非叶子结点开始。
     * 这个非叶子结点在下标lastIndex/2处，因为它是树中的最后一个叶子结点的父结点。
     * 然后一直执行到heap[1]
     * @param heapSize -> lastIndex
     */
    private static void buildMaxHeap(int[] array, int heapSize) {
        for (int i = heapSize / 2; i >= 0; i--) {
            maxHeapify(array, i, heapSize);
        }
    }

    /**
     * 将半堆转换为堆
     * 沿着从根到叶子结点的路径执行
     * @param heapSize -> lastIndex
     */
    private static void maxHeapify(int[] array, int index, int heapSize) {
        int leftIndex = index * 2 + 1, rightIndex = index * 2 + 2, largestIndex = index;
        if (leftIndex < heapSize && array[leftIndex] > array[largestIndex]) {
            largestIndex = leftIndex;
        }
        if (rightIndex < heapSize && array[rightIndex] > array[largestIndex]) {
            largestIndex = rightIndex;
        }
        if (largestIndex != index) {
            swap(array, index, largestIndex);
            maxHeapify(array, largestIndex, heapSize);
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
