package 剑指offer;

public class FindGreatestSumOfSubArray30 {
    /*
    题31：输入一个整形数组，数组里有整数也有负数。数组中一个或连续多个整数组成的一个子数组，求所有子数组的和的最大值，要求时间
    复杂度0（n）
     */

    /**
     * 动态规划问题
     * 解法：当以第i-1个数字结尾的子数组中所有数字的和小于0，如果把这个负数与第i个数累加，得到的结果比第i个数本身还小，
     * 所以这种情况下以第i个数字结尾的数组就是第i个数字本身。如果以第i-1个数字结尾的子数组中所有数字的和大于0，与第i个
     * 数字累加就得到以第i个数字结尾的子数组中所有数字的和。
     */
    public static int findGreatestSumOfSubArray(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }

        int curSum = 0;
        int greatest = 0x80000000;//32位int最小负数，作为保存数组相加的大值变量

        for (int i = 0; i < array.length; i++) {
            if (curSum <= 0) {
                curSum = array[i];
            } else {
                curSum += array[i];
            }
            if (curSum > greatest) { //greatest用来保存当前大的cursum值，如果下次cursum大于改值，则更新，否则不更行，以此保证greatest最大
                greatest = curSum;
            }
        }
        return greatest;
    }
}
