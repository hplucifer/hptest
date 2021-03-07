package 剑指offer;

public class GetUglyNumber33 {
    /*
    题34：丑数
    我们把只包含因子2、3和5的数成为丑数。求按从小到大的顺序的第1500个丑数。例如6，8都是丑数，但7不是。1是第一个丑数
     */

    /**
     * 解法1：逐个判断找到第1500个丑数
     * 效率低，但需要空间小
     */
    public static int getUglyNumber1(int n) {
        if (n <= 0) {
            return -1;
        }
        int number = 0;
        int uglyNumber = 0;
        while (uglyNumber < n) {
            number++;
            if (isUglyNumber(number)) {
                uglyNumber++;
            }
        }
        return number;
    }

    //如果是丑数，则该数经过除2、3和5取模肯定是0，然后整除2、3和5后肯定结果是1
    public static boolean isUglyNumber(int num) {
        while (num % 2 == 0) {
            num /= 2;
        }
        while (num % 3 == 0) {
            num /= 3;
        }
        while (num % 5 == 0) {
            num /= 5;
        }
        return (num == 1) ? true : false;
    }

    /**
     * 解法2：创建数组保存已找到的的丑数
     * 会新建数组，消耗空间，空间换取时间
     */
    public static int getUglyNumber2(int n) {
        if (n <= 0) {
            return -1;
        }

        int[] uglyNumbers = new int[n];
        uglyNumbers[0] = 1;
        int multiply2 = 0;
        int multiply3 = 0;
        int multiply5 = 0;

        for(int i = 1; i < n; i++) { //这里i从1开始，因为uglyNumbers[0]已经赋值为1
            /**
             * 一个排序好的丑数数组，对于乘2而言，肯定存在某一个丑数T,排在它之前的每一个丑数乘2都小于该数组的最大丑数，排在它之后的
             * 丑数乘2都大于。记下这个丑数位置，同时每次生成新的丑数时候，更新这个。乘3、乘5同理
             *以1为第一个丑数（T)开始，记录下乘2、乘3、乘5后的最小数，加入数组记录，循环
             *
             */

            /**
             * 这样即能保证取到的min是当前条件下最小的丑数
             * 也能保证min只含有因子2、3、5一个或多个，又能保证丑数数组内是排序来了，不会漏掉min之前的
             */
            int min = Math.min(uglyNumbers[multiply2] * 2, Math.min(uglyNumbers[multiply3] * 3, uglyNumbers[multiply5] * 5));
            uglyNumbers[i] = min;

            if (uglyNumbers[multiply2] * 2 == min) {
                multiply2++;
            }
            if (uglyNumbers[multiply3] * 3 == min) {
                multiply3++;
            }
            if (uglyNumbers[multiply5] * 5 == min) {
                multiply5++;
            }
        }
        return uglyNumbers[n - 1];
    }
}
