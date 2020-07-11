package test;

import solution.NextPermutation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 * @author Chenzf
 * @date 2020/7/9
 */

public class TestNextPermutation {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("请输入待处理数组：");
            String[] strings = reader.readLine().split(" ");
            int[] arr = new int[strings.length];
            for (int i = 0; i < strings.length; i++) {
                arr[i] = Integer.parseInt(strings[i]);
            }

            NextPermutation.nextPermutation(arr);

            for (int num : arr) {
                System.out.print(num + " ");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
