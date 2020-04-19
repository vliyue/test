package cn.vliyue.test.algorithm.array;

import java.util.Arrays;

public class BinarySearch {

    public static int rank(int key, int[] a) { // 数组必须是有序的
        int low = 0;
        int high = a.length - 1;
        while (low <= high) { // 被查找的键要么不存在，要么必然存在于a[low..high]之中
            int mid = low + (high - low) / 2;
            if (key < a[mid]) {
                high = mid - 1;
            } else if (key > a[mid]) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] whitelist = new int[]{1, 2, 3, 4, 5};
        Arrays.sort(whitelist);
        int key = 3;
        System.out.println(rank(key, whitelist));
    }
}