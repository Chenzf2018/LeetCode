import java.util.HashSet;
import java.util.Set;

/**
 * leetcode_128 最长连续序列
 * @author Chenzf
 * @date 2020/7/7
 * @version 1.0
 */

public class LongestConsecutiveSequence {
    public static int longestConsecutiveSequence(int[] nums) {
        // 使用num_set去重
        Set<Integer> num_set = new HashSet<>();
        for (int num : nums) {
            num_set.add(num);
        }

        int longestStreak = 0;

        for (int num : num_set) {
            // 去重数组中包含当前数的前驱数，则跳过
            if (!num_set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;
                // 寻找数组中有没有连续的数
                while (num_set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }
}
