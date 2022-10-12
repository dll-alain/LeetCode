package indi.alain.leetcode.string;

/**
 * @author d
 * @date 20220604
 */
public class ReplaceSpace {

    /**
     * StringBuilder 方法
     * @param s
     * @return
     */
    public String replaceSpace1(String s) {
        if (s == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                sb.append(s.charAt(i));
            } else {
                sb.append("%20");
            }
        }
        return sb.toString();
    }


    /**
     * 自造轮子
     * @param s
     * @return
     */
    public String replaceSpace(String s) {
        char[] arrStr = s.toCharArray();
        char[] addStr = "%20".toCharArray();
        int index = 0;
        for (char c : arrStr) {
            if (c == ' ') {
                index++;
            }
        }
        char[] result = new char[arrStr.length + 2 * index];
        for (int i = 0, j = 0; i < arrStr.length; i++) {
            if (arrStr[i] != ' ') {
                result[j] = arrStr[i];
                j++;
            } else {
                for (int k = 0; k < addStr.length; k++) {
                    result[j] = addStr[k];
                    j++;
                }
            }
        }
        return new String(result);
    }
}
