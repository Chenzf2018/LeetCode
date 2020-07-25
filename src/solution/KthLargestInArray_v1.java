package solution;

import java.util.Random;

/**
 * leetcode_215_数组中的第k个最大元素
 * @author Chenzf
 * @date 2020/7/23
 * @version 1.0 基于快速排序的选择方法
 */

public class KthLargestInArray_v1 {
    static Random random = new Random();

    public static int findKthLargest(int[] nums, int k) {
        // 返回数组排序之后的倒数第k个位置
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    public static int quickSelect(int[] array, int left, int right, int index) {
        // 随机找一个分隔值
        int q = randomPartition(array, left, right);
        if (q == index) {
            return array[q];
        } else {
            return q < index ? quickSelect(array, q + 1, right, index) : quickSelect(array, left, q - 1, index);
        }
    }

    public static int randomPartition(int[] array, int left, int right) {
        // 随机选择一个范围内的数
        int i = random.nextInt(right - left + 1) + left;
        // 将找到的partition先与最后一位数交换
        swap(array, i, right);
        return partition(array, left, right);
    }

    public static int partition(int[] array, int left, int right) {
        // x为分隔值
        int x = array[right], i = left - 1;
        // 注意这里的j的最大值
        for (int j = left; j < right; j++) {
            if (array[j] <= x) {
                // 因为i是从left - 1开始，所以需++i
                swap(array, ++i, j);
            }
        }

        // 数组中从left到i的数都是小于分隔值的
        swap(array, i + 1, right);
        return i + 1;
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
