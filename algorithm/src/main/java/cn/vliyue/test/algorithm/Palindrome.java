package cn.vliyue.test.algorithm;

/**
 * 回文数
 * <p>
 * https://leetcode-cn.com/problems/palindrome-number/
 */
public class Palindrome {

    public static void main(String[] args) {
        System.out.println(isPalindrome(10));
    }

    public static boolean isPalindrome(int x) {
        if (x < 0 || x % 10 == 0) {
            return false;
        }
        int r = 0;
        while (x > r) {
            r = x % 10 + r * 10;
            x /= 10;
        }
        return x == r || x == r / 10;
    }
}
