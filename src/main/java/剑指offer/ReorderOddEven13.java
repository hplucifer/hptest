package 剑指offer;

public class ReorderOddEven13 {
    /*
    题14：调整数组顺序，使奇数位于偶数前面
    输入一个整数数组，实现一个函数，来调整该数组数字的顺序，使得所有奇数位于数组前半部分，偶数位于数组后半部分
    （没要求调整后是有序的）
     */

    /**
     * 首先想到的是遍历，遇到偶数就拿出来，把后面所有元素往前移动，拿出的偶数放到后面产生的空位，这样时间复杂度为0（n*n）
     * 解法：前后两个指针，前面指针遇到偶数，后面指针遇到奇数，互换
     */
    public static void reoderOddEven(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        int begin = 0;
        int end = array.length - 1;
        while (begin < end) {
            while (begin < end && (array[begin] & 0x01) != 0) {
                begin++;
            }
            while (begin < end && (array[end] & 0x01) == 0) {
                end--;
            }
            if (begin < end) {
                int temp = array[begin];
                array[begin] = array[end];
                array[end] = temp;
            }
        }
        printArray(array);
    }

    /**
     * 将前后两部分各自排序后打印
     * @param array
     */
    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (i == array.length - 1) {
                System.out.println(array[i]);
                break;
            }
            if ((array[i] & 0x01) != 0) {
                if ((array[i + 1] & 0x01) != 0) {
                    if (array[i] > array[i + 1]) {
                        int temp = array[i];
                        array[i] = array[i + 1];
                        array[i + 1] = temp;
                    }
                }
            } else {
                if (array[i] > array[i + 1]){
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }
            }
            System.out.println(array[i]);
        }
    }
}
