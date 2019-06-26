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
        System.out.print(a + " + " + b + " = ");
        AAndB aAndB = new AAndB();
        int toInt = aAndB.aplusb(a, b);
        System.out.println(toInt);
    }
    /*
     * param a: The first integer
     * param b: The second integer
     * return: The sum of a and b
     */
    public int aplusb(int a, int b) {
        // write your code here, try to do it without arithmetic operators.
        int sum = 0 ;
        int carry = 0;
        for(int i = 0;i< 32 ;i++){
            int a1 = a & 1;
            int b1 = b & 1;
            int val = 0 ;
            if(a1 == 0 && b1 == 0 && carry == 0){
                val = 0;
                carry = 0;
            }else if(a1 == 1 && b1 == 1 && carry == 1){
                val = 1;
                carry = 1;
            }else if(a1==0 && b1 ==0 || a1 ==0 && carry ==0 || b1 ==0 && carry ==0){
                val = 1;
                carry = 0;
            }else{
                val = 0;
                carry = 1;
            }
            val = val << i;
            sum = sum | val;
            a = a >> 1;
            b = b >> 1;
        }
        return sum;
    }

    public int aplusb2(int a, int b) {
        // write your code here, try to do it without arithmetic operators.
        if(b==0) {
            return a;
        }
        return aplusb( a ^ b,(a&b)<<1);
    }
}
