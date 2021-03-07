package 剑指offer;

public class NumOf1Between1AndN31 {
    /*
    题32：从1到n整数中1出现的次数
    输入一个整数n，例如输入12，从1到12中，包含1的有1， 10， 11， 12，1一共出现了5次
     */

    /**
     * 搞不清楚了，记着规律了
     * 前一部分，
     * 当前位
     * 后一部分
     * 例如，n=21034
     * i = 1， 当前位是4，before = 2103, current = 4， after = 0
     * https://www.cnblogs.com/yongh/p/9947165.html
     */

    public static long numOf1Between1AndN(long n) {
        long count = 0;
        long i = 1;
        long before = 0, current = 0, after = 0;

        while ((n / i) != 0) {
            before = n / (i * 10);
            current = (n / i) % 10;
            after = n - (n / i) * i;

            if (current == 0) {
                count = count + before * i;
            } else if (current == 1) {
                count = count + before * i + after + 1;
            } else if (current > 1) {
                count = count + (before + 1) * i;
            }
            i *= 10;
        }
        return count;
    }

    public static long number1Low(long n) {
        long number = 0;
        for (long i = 1; i < n; i++) {
            number += numberOf1(i);
        }
        return number;
    }

    public static long numberOf1(long n) {
        long count = 0;
        while (n > 0) {
            if (n % 10 == 1) {
                count++;
            }
            n /= 10;
        }
        return count;
    }
}
