package cn.vliyue.test.algorithm.sort;

public class QuickSort implements IArraySort {
    @Override
    public void sort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private void quickSort(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }
        int i = partition2(array, start, end);
        quickSort(array, start, i - 1);
        quickSort(array, i + 1, end);
    }

    /**
     * 左右指针法
     */
    private int partition(int[] array, int start, int end) {
        // 这里取左还是取右作为基准，和下面的两个while的顺序有关
        int x = array[start];
        int left = start;
        int right = end;
        while (left < right) {
            while (left < right && array[right] >= x) {
                right--;
            }
            while (left < right && array[left] <= x) {
                left++;
            }
            swap(array, left, right);
        }
        swap(array, start, left);
        return left;
    }

    /**
     * 从左到右放置法，最直观
     */
    private int partition1(int[] array, int start, int end) {
        int x = array[start];
        // index 下一个可以放小于x的数的位置
        int index = start + 1;
        for (int i = index; i <= end; i++) {
            if (array[i] < x) {
                swap(array, index, i);
                index++;
            }
        }
        swap(array, index - 1, start);
        return index - 1;
    }

    /**
     * 挖坑填数法
     */
    private int partition2(int[] array, int start, int end) {
        int x = array[start];
        int left = start;
        int right = end;
        while (left < right) {
            while (left < right && array[right] >= x) {
                right--;
            }
            array[left] = array[right];
            while (left < right && array[left] <= x) {
                left++;
            }
            array[right] = array[left];
        }
        array[right] = x;
        return right;
    }
}
