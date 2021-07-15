package lc;

/**
 * 6. Z 字形变换
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 * <p>
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 * <p>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 */
public class Z字形变换 {

    public static String convert(String s, int numRows) {
        if (numRows <= 1 || s.length() <= 1) {
            return s;
        }
        if (s.length() <= numRows) {
            return s;
        }
        char[] sChar = s.toCharArray();
        StringBuilder[] sbs = new StringBuilder[numRows];
        boolean sign = false;
        int curRow = 0;
        for (int i = 0; i < sChar.length; i++) {
            if (sbs[curRow] == null) {
                sbs[curRow] = new StringBuilder();
            }
            sbs[curRow].append(sChar[i]);
            if (curRow == 0 || curRow == numRows - 1) {
                sign = !sign;
            }
            curRow += sign ? 1 : -1;
        }
        StringBuilder sb = new StringBuilder();
        for (StringBuilder str : sbs) {
            sb.append(str.toString());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 4;
        convert(s, numRows);

    }

}
