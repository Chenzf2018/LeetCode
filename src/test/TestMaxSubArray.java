package test;

import solution.MaximumSubarray;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 * leetcode_53_最大子序和
 * @author Chenzf
 */

public class TestMaxSubArray {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("请输入待测数组：");
            String[] strings = reader.readLine().split(" ");
            int[] nums = new int[strings.length];
            for (int i = 0; i < strings.length; i++) {
                nums[i] = Integer.parseInt(strings[i]);
            }

            int result = MaximumSubarray.maxSubArray(nums);

            System.out.println("最大子序和为：" + result);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
