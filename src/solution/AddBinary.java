package solution;

/**
 * leetcode_67_二进制求和，与“leetcode_2_两数相加”相似
 * @author Chenzf
 * @date 2020/7/11
 * @version 1.0
 */

public class AddBinary {
    public static String addBinary(String a, String b) {
        StringBuilder ans = new StringBuilder();
        // 进位标志
        int carry = 0;
        // int sum = 0;

        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            // ans当前位的和
            int sum = carry;
            sum += (i >= 0 ? a.charAt(i) - '0' : 0);
            sum += (j >=0 ? b.charAt(j) - '0' : 0);
            ans.append(sum % 2);
            // carry /= 2;
            carry = sum / 2;
        }

        // 会多产生一个进位
        ans.append(carry == 1 ? carry : "");

        return ans.reverse().toString();
    }
}
