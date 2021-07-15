package lc;

/**
 * 8. 字符串转换整数 (atoi)
 * 请你来实现一个 myAtoi(string s) 函数，使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 atoi 函数）。
 * <p>
 * 函数 myAtoi(string s) 的算法如下：
 * <p>
 * 读入字符串并丢弃无用的前导空格
 * 检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
 * 读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
 * 将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。
 * 如果整数数超过 32 位有符号整数范围 [−231,  231 − 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −231 的整数应该被固定为 −231 ，大于 231 − 1 的整数应该被固定为 231 − 1 。
 * 返回整数作为最终结果。
 * 注意：
 * <p>
 * 本题中的空白字符只包括空格字符 ' ' 。
 * 除前导空格或数字后的其余字符串外，请勿忽略 任何其他字符。
 */
public class 字符串转换整数 {

    public static int myAtoi(String s) {
        if (s.length() <= 0) {
            return 0;
        }
        char[] chars = s.toCharArray();
        boolean firstNum = false;
        int sign = 1;
        int signCount = 0;
        long result = 0;
        for (int i = 0; i < chars.length; i++) {
            if (!firstNum) {
                // 去掉前导空格
                if (chars[i] == ' ' && signCount == 0) {
                    continue;
                }
                // 符号
                if (chars[i] == '-' || chars[i] == '+') {
                    //处理一下 -----5这种情况
                    if (signCount >= 1) {
                        return (int) result;
                    }
                    signCount++;
                    if (chars[i] == '-') {
                        sign = -1;
                    }
                    continue;
                }
            }
            // 是数字
            if (48 <= chars[i] && chars[i] <= 58) {
                result = result * 10 + (chars[i] - 48) * sign;
                if (result < Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                } else if (result > Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
                firstNum = true;
            } else {
                // 不是数字也不是前导空格
                break;
            }
        }
        return (int) result;
    }

    public static void main(String[] args) {
        String s = "2147483648";
        System.err.println(myAtoi(s));
    }
}
