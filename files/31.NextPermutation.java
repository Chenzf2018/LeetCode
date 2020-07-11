public class NextPermutation {
    public static void nextPermutation(int[] nums) {
        // 从数组中index=nums.length-2的数开始向左遍历
        // 找到第一个不满足“从右至左升序排列”的数nums[i]
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }

        // 找到nums[i]右侧，最后一个比nums[i]大的数
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }

            // 交换nums[j]和nums[i]
            swap(nums, i, j);
        }

        // 将nums[i]右侧的数(已是降序排序)反转--最终按升序排序
        reverse(nums, i + 1);
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * 双指针，前后交换
     */
    private static void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}
