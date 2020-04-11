package cn.vliyue.test.algorithm.dp;

import java.util.Arrays;

/**
 * 01背包问题
 *
 * 状态转移：每一步尝试加入一个新的物品
 * 状态内容：加入该物品后每种容量下最大价值
 *
 * f最大价值，i物品，v容量
 * c物品容量，w物品价值
 * <p>
 * 状态转移方程：f[i][v]=max{f[i-1][v], f[i-1][v-c[i]] + w[i]}
 *
 * @author vliyue
 */
public class Package01 {

    public static void main(String[] args) {
        int n = 5, w = 10;                    //物品个数，背包容量
        int[] value = {0, 6, 3, 5, 4, 6};     //各个物品的价值
        int[] weight = {0, 2, 2, 6, 5, 4};    //各个物品的重量
        System.out.println(getMaxValue(weight, value, w, n));

        // first is weight, second is value
        int[][] things = {{1, 2}, {2, 3}, {2, 2}, {3, 4}};
        int capacity = 5;
        int maxValue = maxValue(things, capacity);
        System.out.println(maxValue);
    }

    private static int maxValue(int[][] things, int capacity) {
        // 行：每种物品是否已经加入背包
        // 列：该物品加入背包后，在每个容量下的最大价值
        int[][] v = new int[things.length + 1][capacity + 1];
        // 上左各多了一圈0，为了节省第一行列的处理，i-1时可以自动取到0
        for (int i = 1; i <= things.length; i++) {
            int[] thing = things[i-1];
            for (int j = 1; j <= capacity; j++) {
                if (thing[0] > j) {
                    // 装不下，和没装的价值一样
                    v[i][j] = v[i - 1][j];
                } else {
                    // 装得下，比较：没装该物品时的最大价值 vs （装了的价值 = 把该物品对应的空间让出去后的价值 + 该物品的价值）
                    v[i][j] = Math.max(v[i - 1][j], v[i - 1][j - thing[0]] + thing[1]);
                }
            }
        }
        System.out.println(Arrays.deepToString(v));
        return v[things.length][capacity];
    }

    public static int getMaxValue(int[] weight, int[] value, int w, int n) {
        int[][] table = new int[n + 1][w + 1];
        for (int i = 1; i <= n; i++) { //物品
            for (int j = 1; j <= w; j++) {  //背包大小
                if (weight[i] > j) {
                    //当前物品i的重量比背包容量j大，装不下，肯定就是不装
                    table[i][j] = table[i - 1][j];
                    // System.out.print(table[i][j]+ " ");
                } else { //装得下，Max{装物品i， 不装物品i}
                    table[i][j] = Math.max(table[i - 1][j], table[i - 1][j - weight[i]] + value[i]);
                    //System.out.print(table[i][j]+ " ");
                }
            }
            // System.out.println();
        }
        return table[n][w];
    }
}
