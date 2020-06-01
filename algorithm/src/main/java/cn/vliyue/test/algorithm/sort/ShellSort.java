package cn.vliyue.test.algorithm.sort;

public class ShellSort implements IArraySort {
    @Override
    public void sort(int[] array) {
        int gap = 1;
        while (gap < array.length) {
            gap = gap * 3 + 1;
        }
        while (gap > 0) {
            // i=gap gap前面的是各个分组的第一位，插入排序从第二位开始，i代表当前要处理的数据
            // i++ 后面的都需要插入排序，i++一个一个来是交替执行各个分组了，通过gap来获取同组的数据
            for (int i = gap; i < array.length; i++) {
                int current = array[i];
                // i要和同组的前面的数据做比较，并插入到正确的位置
                int j = i - gap;
                while (j >= 0 && array[j] > current) {
                    array[j + gap] = array[j];
                    // 同组的上上个数据
                    j -= gap;
                }
                array[j + gap] = current;
            }
            gap = (int) Math.floor(gap / 3D);
        }
    }
}
