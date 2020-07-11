package solution;

import java.util.Map;
import java.util.HashMap;

/**
 * leetcode_1_两数之和
 * @author Chenzf
 * @date 2020/7/11
 * @version 1.0
 */

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        // 创建一个HashMap来存储数据，便于查找
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // V put(K key, V value)
            hashMap.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            // 如果hashMap中存在complement且不是nums[i]本身
            // hashMap.get(Object Key)
            if (hashMap.containsKey(complement) && hashMap.get(complement) != i) {
                return new int[] {i, hashMap.get(complement)};
            }
        }

        // Missing return statement
        throw new IllegalArgumentException("No two sum solution");
    }
}
