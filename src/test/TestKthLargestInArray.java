package test;

import solution.KthLargestInArray_v2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 * leetcode_215_数组中的第k个最大元素
 * @author Chenzf
 * @date 2020/7/23
 * @version 1.0 基于快速排序的选择方法
 */

public class TestKthLargestInArray {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("请输入待测数组：");
            String[] strings = reader.readLine().split(" ");
            int[] nums = new int[strings.length];
            for (int i = 0; i < strings.length; i++) {
                nums[i] = Integer.parseInt(strings[i]);
            }

            System.out.println("请输入需要找第几个最大值：");
            int k = Integer.parseInt(reader.readLine());

            System.out.printf("数组中第%d个最大的值是：%d", k, KthLargestInArray_v2.findKthLargest(nums, k));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
