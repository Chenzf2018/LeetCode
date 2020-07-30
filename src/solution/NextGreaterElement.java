package solution;

import java.util.Stack;

/**
 * leetcode_503_下一个更大元素
 * @author Chenzf
 * @date 2020/7/30
 * @version 1.0
 */

public class NextGreaterElement {
    public int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 2 * nums.length - 1; i >= 0; i--) {
            while (! stack.empty() && nums[stack.peek()] <= nums[i % nums.length]) {
                stack.pop();
            }

            result[i % nums.length] = stack.empty() ? -1 : nums[stack.peek()];
            stack.push(i % nums.length);
        }

        return result;
    }
}
