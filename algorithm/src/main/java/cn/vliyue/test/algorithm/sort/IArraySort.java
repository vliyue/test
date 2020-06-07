package cn.vliyue.test.algorithm.sort;

public interface IArraySort {

    void sort(int[] array);

    default void swap(int[] array, int i, int j) {
        if (i == j) {
            return;
        }
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
