package easy;

import java.util.Scanner;

/**
 *
 * 1. A + B Problem
 *
 * Write a function that add two numbers A and B.
 *
 * Example
 * Example 1:
 *
 * Input:  a = 1, b = 2
 * Output: 3
 * Explanation: return the result of a + b.
 * Example 2:
 *
 * Input:  a = -1, b = 1
 * Output: 0
 * Explanation: return the result of a + b.
 * Challenge
 * Of course you can just return a + b to get accepted. But Can you challenge not do it like that?(You should not use + or any arithmetic operators.)
 *
 * Clarification
 * Are a and b both 32-bit integers?
 *
 * @ClassName AAndB
 * @Description TODO
 * @Author allen
 * @Date: 2019-06-24 17:11
 * @Version 1.0
 */
public class AAndB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入第一个数字a: ");
        int a = scanner.nextInt();
        System.out.println("请输入第二个数字b: ");
        int b = scanner.nextInt();

        //convert to binary
        String aToBinaryString = Integer.toBinaryString(a);
        String bToBinaryString = Integer.toBinaryString(b);
        System.out.println("a转换成二进制字符串为：" + aToBinaryString);
        System.out.println("b转换成二进制字符串为：" + bToBinaryString);
        Integer aLength = aToBinaryString.length();
        Integer bLength = bToBinaryString.length();

        //swallow the length
        StringBuffer aNeedApend = new StringBuffer();
        StringBuffer bNeedApend = new StringBuffer();

        for (int i = 0; i < aLength; i++) {
            bNeedApend.append("0");
        }
        for (int i = 0; i < bLength; i++) {
            aNeedApend.append("0");
        }

        aToBinaryString = aNeedApend.append(aToBinaryString).toString();
        bToBinaryString = bNeedApend.append(bToBinaryString).toString();

        System.out.println("填充后的二进制数据a：" + aToBinaryString);
        System.out.println("填充后的二进制数据b：" + bToBinaryString);

        int tyP = 0;
        int tyL = 0;
        int c = 0;

        //calculate
        Integer len = aToBinaryString.length();
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < len; i++) {
            a = Integer.parseInt(String.valueOf(aToBinaryString.charAt(i)));
            b = Integer.parseInt(String.valueOf(bToBinaryString.charAt(i)));
            if (a == 1 && b == 1) {
                tyP = 1;
            }
            c = a & b;
            if (c == 1 && tyP == 1) {
                tyL = 1;
            }
            c = c & tyP & tyL;
            result.append(c);
        }
        System.out.println("a+b=" + result);
    }
}
