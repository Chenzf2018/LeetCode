package solution;

import javafx.util.Pair;

/**
 * leetcode_165_比较版本号
 * @author Chenzf
 * @date 2020/7/21
 * @version 2.0
 */

public class CompareVersionNumbers_v2 {
    public int compareVersion(String version1, String version2) {
        int point1 = 0, point2 = 0;
        int length1 = version1.length(), length2 = version2.length();

        int i1, i2;
        Pair<Integer, Integer> pair;
        while (point1 < length1 || point2 < length2) {
            pair = getNextChunk(version1, length1, point1);
            i1 = pair.getKey();
            point1 = pair.getValue();

            pair = getNextChunk(version2, length2, point2);
            i2 = pair.getKey();
            point2 = pair.getValue();

            if (i1 != i2) {
                return i1 > i2 ? 1 : -1;
            }
        }

        // 版本相等
        return 0;
    }

    /**
     * Map对象是key, value 可以多对
     *
     * Pair对象是 object, object 只能一对
     */
    public Pair<Integer, Integer> getNextChunk(String version, int StringLength, int point) {
        // if pointer is set to the end of string, return 0
        // i1 = pair.getKey(); point1 = pair.getValue();
        if (point > StringLength - 1) {
            return new Pair<>(0, point);
        }

        // find the end of chunk
        int i, pointEnd = point;
        while (pointEnd < StringLength && version.charAt(pointEnd) != '.') {
            pointEnd++;
        }

        //retrieve the chunk
        if (pointEnd != StringLength - 1) {
            i = Integer.parseInt(version.substring(point, pointEnd));
        } else {
            i = Integer.parseInt(version.substring(point, StringLength));
        }

        // find the beginning of next chunk
        point = pointEnd + 1;

        return new Pair(i, point);
    }
}
