package 剑指offer;

import java.util.Arrays;

public class InversePairs35 {
    /*
    题36：数组中的逆序对
    在数组中的两个数字如果前面(注意，必须是前面)一个数字大于后面的数字，则两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
    例如，在数组{7， 5， 6， 4}中，一共存在5个逆序对75 76 74 54 64，输出总数为5。
     */

    /**
     * 解法：归并排序的思想
     * 在归并排序，两个序列合并时，左右两个序列都是递增排序的，而且左边序列里的元素在原数组本身就排在右边序列之前
     * 比较左右序列元素大小，依次来规律求出逆序总数
     */
    private static int count = 0;
    public static int inversePairs(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int[] clone = new int[array.length];
        clone = Arrays.copyOf(array, array.length);
        mergeSort(clone, 0, clone.length - 1);
        return count;
    }

    public static void mergeSort(int[] array, int start, int end) {
        if(start < end){//当子序列中只有一个元素时结束递归
            int mid = (start + end) / 2;//划分子序列
            mergeSort(array, start, mid);//对左侧子序列进行递归排序
            mergeSort(array, mid + 1, end);//对右侧子序列进行递归排序
            merge(array, start, mid, end);//合并
        }
    }

    //两路归并算法，两个排好序的子序列合并为一个子序列
    public static void merge(int[] array, int start, int mid, int end) {
        int[] temp = new int[array.length];//辅助数组
        int p1 = start;
        int p2 = mid + 1;
        int k = start;//p1、p2是检测指针，k是辅助数组作为元素下标的存放指针
        while (p1 <= mid && p2 <= end) {
            if (array[p1] <= array[p2]) {
                temp[k++] = array[p1++];
            } else {
                /**
                 * 合并时，前面序列和后面序列都是排好序的，然后是分别挪动p1和p2指针
                 * p1和p2都是向前挪动，但是，如果后面序列，左边的值取出后，其实这个位置就空出来了，p2向后挪动了，
                 * 如果再算逆序，其实就重复包含了空出来的这个位置，所以就把后面序列p2所指的值挪到空出来的位置，
                 * 其实就是相当于固定了p2最初指向的位置，也就是mid+1
                 */
                count += (mid + 1) - p1;
                temp[k++] = array[p2++];
            }
        }

        /**
         * p1<=mid,说明前面序列剩下的元素都大于后面序列， 而且前后序列都是排序好的，所以直接挪到数组后面即可
         */
        while (p1 <= mid) {
            temp[k++] = array[p1++];//如果第一个序列未检测完，直接将后面所有元素加到合并的序列中
                                  //例如合并第一步，start=0， mid=0，end=1，此时如果array[p1]>array[p2]
                                  //那temp[0]=array[p2],但是array[p1]在上面并没有放进temp，在这里就是将
                                  //未检测完的元素直接放到temp内。
        }

        //同上
        while (p2 <= end) {
            temp[k++] = array[p2++];//如果第一个序列未检测完，直接将后面所有元素加到合并的序列中
        }

        //复制回原数组
        for (int i = start; i <= end; i++) {
            array[i] = temp[i];
        }
    }
}
