package test;

import solution.AddBinary;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 * @author Chenzf
 * @date 2020/7/11
 */

public class TestAddBinary {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("请输入两个字符串：");
            String a = reader.readLine();
            String b = reader.readLine();

            System.out.println(AddBinary.addBinary(a, b));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
