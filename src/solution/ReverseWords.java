package solution;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * leetcode_151. 翻转字符串里的单词
 * @author Chenzf
 * @date 2020/7/26
 * @version 1.0
 */


public class ReverseWords {
    public String reverseWords(String string) {
        int left = 0, right = string.length() - 1;

        // 去掉字符串开头的空白字符
        while (left <= right && string.charAt(left) == ' ') {
            left++;
        }

        // 去掉字符串末尾的空白字符
        while (left <= right && string.charAt(right) == ' ') {
            right--;
        }

        Deque<String> deque = new ArrayDeque<>();
        StringBuilder word = new StringBuilder();

        while (left <= right) {
            char ch = string.charAt(left);
            if ((word.length() != 0) && (ch == ' ')) {
                // 将单词 push 到队列的头部
                deque.offerFirst(word.toString());
                word.setLength(0);
            } else if (ch != ' ') {
                word.append(ch);
            }
            left++;
        }

        // 将最后一个单词压入队列的头部
        deque.offerFirst(word.toString());

        // 将队列转成字符串
        return String.join(" ", deque);
    }
}
