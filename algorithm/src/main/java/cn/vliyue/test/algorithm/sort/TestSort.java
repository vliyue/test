package cn.vliyue.test.algorithm.sort;

import java.util.Arrays;

public class TestSort {

    public static void main(String[] args) {
        int[] array = new int[]{1, 9, 3, 4, 6, 5, 2, 8, 7};

//        new BubbleSort().sort(array);
//        new SelectSort().sort(array);
//        new InsertSort().sort(array);
//        new ShellSort().sort(array);
        new MergeSort().sort(array);


        System.out.println(Arrays.toString(array));

        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                System.out.println(i);
            }
        }
    }
}
