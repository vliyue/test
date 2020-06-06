package cn.vliyue.test.algorithm.sort;

public class MergeSort implements IArraySort {
    @Override
    public void sort(int[] array) {
        int[] temp = new int[array.length];
        mergeSort(array, 0, array.length - 1, temp);
    }

    private void mergeSort(int[] array, int start, int end, int[] temp) {
        if (start >= end) {
            return;
        }
        int half = (end + start) / 2;
        mergeSort(array, start, half, temp);
        mergeSort(array, half + 1, end, temp);
        mergeArray(array, start, half, end, temp);
    }

    private void mergeArray(int[] array, int start, int half, int end, int[] temp) {
        int left = start;
        int right = half + 1;
        int tempi = start;
        while (left <= half && right <= end) {
            if (array[left] < array[right]) {
                temp[tempi++] = array[left++];
            } else {
                temp[tempi++] = array[right++];
            }
        }
        while (left <= half) {
            temp[tempi++] = array[left++];
        }
        while (right <= end) {
            temp[tempi++] = array[right++];
        }
        System.arraycopy(temp, start, array, start, end + 1 - start);
    }

}
