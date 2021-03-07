package 剑指offer;

public class MoreThanHalfNum28 {
    /*
    题29：数组中出现次数超过一半的数字，找出这个数字
     */

    /**
     * 如果数组中有出现次数超过一般的数字，那这个数组排序后，这个数字肯定会在数组中间位置出现
     * 首先想到排序后，取出数组中间位置的数字即可，但是时间复杂度最快的快排也需要0(nlogn）
     * 解法：在遍历数组时，保存两个值，一个是数字，一个是次数。时间复杂度0（n）
     * 因为没有说给定数组肯定含有次数超过一般的数字，所以要加防护
     * 如果个数是一半时，也是满足的，待议
     */
    public static int moreThanHalfNum(int[] array) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int result = array[0];
        int times = 1;
        for (int i = 1; i < array.length; i++) {
            //数组内不相同的数字会互相抵消time的加减，最终为0，所以最后一次+1肯定是大于数组长度1/2的数字
            if (times == 0) {
                result = array[i];
                times = 1;//如果数组含有次数超过一般的数字，最后一次改变times为1的数字肯定出现次数大于数组长度的一半
            }
            if (result == array[i]) {
                times++;
            } else {
                times--;
            }
        }
        if (!isHasMoreThanHalfNum(array, result)) {
            return -1;
        }
        return result;
    }

    public static boolean isHasMoreThanHalfNum(int[] array, int num) {
        boolean flag = false;
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == num) {
                count++;
            }
        }
        if (2 * count > array.length) {
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }
}
