package cn.vliyue.test.algorithm.string;

import java.util.HashMap;

/**
 * 子串——滑动窗口
 * 重复——散列hash
 *
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 */
public class LongestSubstring {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("asdd"));
    }

    public static int lengthOfLongestSubstring(String s) {
        // 特殊情况考虑
        // case1: s为空
        // case2：s字符完全一样
        if (s == null || s.length() < 1) {
            return 0;
        }
        char[] array = s.toCharArray();
        int longestLength = 1;
        HashMap<Character, Integer> map = new HashMap<>();
        int length = 0;
        int i = 0;
        for (int j = i; j < array.length; j++) {
            if (map.containsKey(array[j])) {
                int start = map.get(array[j]) + 1;
                for (int k = i; k < start; k++) {
                    map.remove(array[k]);
                    length--;
                }
                i = start;
            }
            map.put(array[j], j);
            length++;
            if (length > longestLength) {
                longestLength = length;
            }
        }
        return longestLength;
    }
}
