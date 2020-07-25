package solution;

/**
 * leetcode_53_最大子序和
 * @author Chenzf
 * @date 2020/7/23
 * @version 1.0
 */

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        if (nums == null) {
            return 0;
        }

        int[] dp = new int[nums.length];
        int result = nums[0];
        dp[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (dp[i - 1] > 0) {
                dp[i] = dp[i - 1] + nums[i];
            } else {
                dp[i] = nums[i];
            }

            // 摒弃前面出现的衰减因素
            result = Math.max(result, dp[i]);
        }

        return result;
    }
}
