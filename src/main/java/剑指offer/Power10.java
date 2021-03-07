package 剑指offer;

public class Power10 {
    /*
    题11：数值的整数次方
    实现函数double Power（double base， int exponent），求base的exponent次方，不得使用函数库，同时不需要考虑大数问题
     */

    /**
     * 要考虑输入指数为负数和0的情况
     * 当输入指数为负数时，去倒数，这时候就要考虑base为0的情况
     * 解法：对输入的数进行条件判断后计算结果
     */
    public static double power(double base, int exponent) throws Exception {
        double result = 0.0;
        if (equal(base, 0.0) && exponent < 0) {
            throw new Exception("0的负数次幂无意义");
        }
        if (equal(exponent, 0)) {
            return 1.0;
        }
        if (exponent < 0) {
            result = powerWithExponent(1.0 / base, -exponent);
        } else {
            result = powerWithExponent(base, exponent);
        }
        return result;
    }

    public static double powerWithExponent(double base, int exponent) {
        double result = 1.0;
        for (int i = 1; i < exponent; i++) {
            result *= base;
        }
        return result;
    }

    /**
     * 由于计算机表示小数（包括float和double型小数）都有误差，我们不能直接用等号（==）判断两个小数是否相等
     * 如果两个小数的差的绝对值很小，比如小于0.0000001，就可以认为它们相等
     * @param num1
     * @param num2
     * @return
     */
    public static boolean equal(double num1, double num2) {
        if (num1 - num2 > -0.0000001 && num1 - num2 < 0.0000001) {
            return true;
        } else {
            return false;
        }
    }
}
