package cn.vliyue.test.algorithm.array;

import java.io.IOException;
import java.util.Arrays;

public class ProcessQueries {

    public static void main(String[] args) throws IOException {
        System.out.println(Arrays.toString(processQueries(new int[]{3, 1, 2, 1}, 5)));
    }

    public static int[] processQueries(int[] queries, int m) {
        int[] result = new int[queries.length];
        int[] init = new int[m+1];
        for (int i = 1; i <= m; i++) {
            init[i] = i;
        }
        for (int i = 0; i < queries.length; i++) {
            result[i] = init[queries[i]] - 1;
            for (int j = 0; j < m; j++) {
                if (init[j+1] < init[queries[i]]) {
                    init[j+1] ++;
                }
            }
            init[queries[i]] = 1;
        }
        return result;
    }
}
