package test;

import solution.LongestConsecutiveSequence;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 * @author Chenzf
 * @date 2020/7/9
 */

public class TestLongsetConsecutiveSequence {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("请输入待测试的整数数组：");
            String[] strings = reader.readLine().split(" ");
            int[] arr = new int[strings.length];
            for (int i = 0; i < strings.length; i++) {
                arr[i] = Integer.parseInt(strings[i]);
            }

            System.out.printf("%d",
                    LongestConsecutiveSequence.longestConsecutiveSequence(arr));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
