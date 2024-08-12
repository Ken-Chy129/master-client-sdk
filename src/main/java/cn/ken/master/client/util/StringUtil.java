package cn.ken.master.client.util;

import java.util.Objects;

/**
 * @author Ken-Chy129
 * @date 2024/8/12
 */
public class StringUtil {

    public static boolean equals(String str1, String str2) {
        return Objects.equals(str1, str2);
    }

    public static boolean isBlank(String str) {
        int strLen;
        if (str == null || (strLen = str.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isNotBlank(String str) {
        return !isBlank(str);
    }

    public static boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

}
