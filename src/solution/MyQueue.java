package solution;

import java.util.Stack;

/**
 * leetcode_232_用栈实现队列
 * @author Chenzf
 * @date 2020/7/26
 * @version 1.0
 */

public class MyQueue {
    Stack<Integer> stackPush;
    Stack<Integer> stackPop;

    public MyQueue() {
        stackPush = new Stack<>();
        stackPop = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int value) {
        stackPush.push(value);
    }
}
