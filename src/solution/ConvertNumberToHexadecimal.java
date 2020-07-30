package solution;

/**
 * leetcode_405_数字转换成十六进制数
 * @author Chenzf
 * @date 2020/7/30
 * @version 1.0
 */

public class ConvertNumberToHexadecimal {
    public String toHex(int num) {
        if (num == 0) {
            return "0";
        }

        StringBuilder stringBuilder = new StringBuilder();
        char[] chars = "0123456789abcdef".toCharArray();

        while (num != 0) {
            // 十六进制的1111刚好对应十进制的15
            int temp = num & 15;
            stringBuilder.append(chars[temp]);
            num >>>= 4;
        }

        return stringBuilder.reverse().toString();
    }
}
