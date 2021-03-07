package 剑指offer;

public class Fibonacci8 {
    /*
     * 题9：斐波那契数列
     * 斐波那契数列指的是这样一个数列 0, 1, 1, 2, 3....
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级，求青蛙跳上一个n级的台阶总共有多少种跳法
     */

    /**
     * 解法：定义三个变量，作为交换
     * (不用递归，递归后每层会有很多重复的点，如果n很大的话，效率很慢），时间复杂度0（n）
     */

    /**
     * 现根据f(0)+f（1）=f（2），保存下f（1）和f（2）
     * 在根据f（1）+f（2）=f（3），保存下f（2）和f（3），依次类推
     * 需要是三个变量
     * @param n
     * @return
     */
    public static int getFibonacci(int n) {
        int[] result = {0, 1};
        if (n < 2) {
            return result[n];
        }

        int fibNMinusOne = 0;
        int fibNMinusTwo = 1;
        int fibN = 0;
        for (int i = 2; i <= n; i++) { //是从2开始
            fibN = fibNMinusOne + fibNMinusTwo;

            fibNMinusOne = fibNMinusTwo;
            fibNMinusTwo = fibN;
        }
        return fibN;
    }
}
