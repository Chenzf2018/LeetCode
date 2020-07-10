import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 * @author Chenzf
 * @date 2020/7/10
 */

public class TestLongestSubstringWithoutRepeatingCharacter {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("请输入待检测字符串：");
            String string = reader.readLine();

            int result =
                    LongestSubstringWithoutRepeatingCharacters.longestSubstringWithoutRepeatCharacters(string);

            System.out.println(result);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
