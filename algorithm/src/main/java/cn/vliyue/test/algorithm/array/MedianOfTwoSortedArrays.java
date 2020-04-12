package cn.vliyue.test.algorithm.array;

/**
 * @link https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
 */
class MedianOfTwoSortedArrays {

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1, 2, 4}, new int[]{3}));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int start1 = 0, start2 = 0;
        int end1 = nums1.length - 1, end2 = nums2.length - 1;
        while (true) {
            int mi1 = mid(start1, end1);
            int mi2 = mid(start2, end2);
            int maxLeft = Math.max(nums1[mi1], nums2[mi2]);
            int minRight = Math.min(end1 - start1 > 1 ? nums1[mi1 + 1] : nums1[mi1],
                    end2 - start2 > 1 ? nums2[mi2 + 1] : 9999);
            if (maxLeft <= minRight) {
                return (maxLeft + minRight) / 2.0;
            }
            if (nums1[mi1] < nums2[mi2]) {
                start1 = mi1;
                end2 = mi2;
            } else if (nums1[mi1] > nums2[mi2]) {
                start2 = mi2;
                end1 = mi1;
            }
        }

    }

    private static int mid(int start, int end) {
        if (end - start == 1) {
            return start;
        }
        if ((end - start) % 2 == 0) {
            return (end - start) / 2;
        } else {
            return (end - start) / 2 + 1;
        }
    }
}