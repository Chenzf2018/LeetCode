import java.util.Set;
import java.util.HashSet;

/**
 * leetcode_3_无重复字符的最长子串
 * @author Chenzf
 * @date 2020/7/10
 * @version 1.0
 */

public class LongestSubstringWithoutRepeatingCharacters {
    public static int longestSubstringWithoutRepeatCharacters(String s) {
        // 创建HashSet存入字符
        Set<Character> hashSet = new HashSet<>();

        int length = s.length();
        // 最长子串的截止位置
        int rk = 0;
        int result = 0;

        for (int i = 0; i < length; i++) {
            if (i != 0) {
                // 左指针右移一位，并移除当前字符的前一个字符
                hashSet.remove(s.charAt(i - 1));
            }

            while (rk < length && ! hashSet.contains(s.charAt(rk))) {
                hashSet.add(s.charAt(rk));
                rk++;
            }

            result = Math.max(result, ((rk - 1) - i) + 1);
        }

        return result;
    }

}
