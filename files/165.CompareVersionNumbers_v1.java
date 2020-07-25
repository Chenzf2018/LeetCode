package solution;

/**
 * leetcode_165_比较版本号
 * @author Chenzf
 * @date 2020/7/21
 * @version 1.0
 */

public class CompareVersionNumbers_v1 {
    public int compareVersion(String version1, String version2) {
        String[] nums1 = version1.split("\\.");
        String[] nums2 = version2.split("\\.");
        int length1 = nums1.length, length2 = nums2.length;

        int i1, i2;
        for (int i = 0; i < Math.max(length1, length2); i++) {
            i1 = (i < length1) ? Integer.parseInt(nums1[i]) : 0;
            i2 = (i < length2) ? Integer.parseInt(nums2[i]) : 0;

            if (i1 != i2) {
                return i1 > i2 ? 1 : -1;
            }
        }

        // 相等
        return 0;
    }
}
