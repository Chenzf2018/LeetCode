public class Test {
    public static void nextPermutation (int[] nums) {
        int i = nums.length - 2;

        // 找到第一个从右至左不满足升序排序的数
        while (i > 0 && nums[i + 1] <= nums[i]) {
            i--;
        }

        // 从右向左遍历，找到第一个大于nums[i]的数
        int j = nums.length - 1;
        while (i > j && nums[i] >= nums[j]) {
            j--;
        }

        swap(nums, i, j);

        reverse(nums, i);
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static void reverse(int[] nums, int start) {
        int i = start + 1, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}