package 剑指offer;

public class FindNumsAppearOne39 {
    /*
    题40：数组中只出现一次的数字
    一个整形数组里除了两个数字之外，其他的数字都出现了两次，请写方法，找出这两个只出现一次的数字。
     */

    /**
     * 异或：二进制同一位相同则结果为0，不同为1
     * 任何一个数字异或自己都为0
     * 如果一个整形数组，除了一个数字所有数字都出现两次，那把数组里的元素依次异或运算，结果就是那个只出现一次的数字
     * 数组里有两个，那就想到如果能把数组分成两部分，每一部分正好含有一个只出现一次的数字，其他数字都出现两次，就可以找出
     * 关键在于如何分组，界限确定
     */

    /**
     * 解法：数组元素依次异或，最后得到的结果就是两个只出现一次的数字异或结果
     * 由于两个数字不同，那结果数字二进制表示至少有一位为1
     * 我们在结果数字中找到从低位开始第一个为1的位置，记为第n位。
     * 然后以第n位是否为1为标准，将数组中的数字分为两组，一组为第n位为1的数字，一组为第n位位0的数字
     * 因为相同数字的某一位肯定是相同的，所以这种分法肯定能将出现两次的数字分到同一组
     */
    public static int[] findNumsAppearOne(int[] array) {
        if (array == null || array.length < 2) {
            return null;
        }
        int[] number = new int[2];
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            result ^= array[i];
        }

        int indexOf1 = findFirstBitIs1(result);
        for (int j = 0; j < array.length; j++) {
            if ((isBit1(array[j], indexOf1)) == 0) {
                number[0] ^= array[j];//该位为0的数字分为一组，然后元素依次异或
            } else {
                number[1] ^= array[j];//该位为1的数字分为一组，然后元素依次异或
            }
        }
        return number;
    }

    //获取结果数字二进制从低位开始最早出现1的位置
    public static int findFirstBitIs1(int num) {
        int indexBit = 0;
        while ((num & 0x01) == 0) {
            num = num >> 1;
            indexBit++;
        }
        return indexBit;//返回的是第一个为1的前一个位置
    }

    public static int isBit1(int num, int indexBit) {
        num = num >> indexBit;
        return (num & 1);
    }
}
