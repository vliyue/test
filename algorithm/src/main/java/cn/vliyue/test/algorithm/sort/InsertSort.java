package cn.vliyue.test.algorithm.sort;

public class InsertSort implements IArraySort {
    @Override
    public void sort(int[] array) {
        // i 已排序部分最后一位下标
        for (int i = 0; i < array.length - 1; i++) {
            int current = array[i + 1];
            // j 当前比较的已排序的数字，从后往前比
            for (int j = i; j >= 0; j--) {
                // 找到合适的位置
                if (current < array[j] && (j == 0 || current >= array[j - 1])) {
                    // 插入，顺序往后移
                    for (int k = i + 1; k > j; k--) {
                        array[k] = array[k - 1];
                    }
                    array[j] = current;
                    break;
                }
            }
        }
    }
}
