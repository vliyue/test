package cn.vliyue.test.algorithm.hex;

public class Sum {

    public static void main(String[] args) {
        System.out.println(new Sum().getSum(2, -1));
    }

    public int getSum(int a, int b) {
        // a表示sum，b表示进位
        while (b != 0) {
            int temp = (a & b) << 1;
            a = a ^ b;
            b = temp;
        }
        return a;
    }
}
