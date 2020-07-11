package test;

import solution.TwoSum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


/**
 * @author Chenzf
 * @date 2020/7/11
 */

public class TestTwoSum {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("请输入待测数据：");
            String[] strings = reader.readLine().split(" ");
            int[] nums = new int[strings.length];
            for (int i = 0; i < strings.length; i++) {
                nums[i] = Integer.parseInt(strings[i]);
            }
            System.out.println("请输入目标值：");
            int target = Integer.parseInt(reader.readLine());

            // System.out.println(TwoSum.twoSum(nums, target)); // [I@16d3586

            int[] results = TwoSum.twoSum(nums, target);
            for (int result : results) {
                System.out.print(result + " ");
            }

        } catch(IOException exception) {
            exception.printStackTrace();
        }
    }
}
