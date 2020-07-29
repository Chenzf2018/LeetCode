package solution;

/**
 * leetcode_344_反转字符串
 * @author Chenzf
 * @date 2020/7/26
 * @version 1.0
 */

public class ReverseString {
    public void reverseString(char[] chars) {
        if (chars == null || chars.length == 0) {
            return;
        }

        int left = 0, right = chars.length - 1;
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }
}
