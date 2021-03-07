package 剑指offer;

import java.util.ArrayList;
import java.util.Arrays;

public class GetLeastNumbers29 {
    /*
    题30：最小的k个数
    输入n个整数，找出其中最小的k个数
    例如输入4，5，1，6，2，7，3，8这八个数，则其中最小的4个数字是1，2，3，4
     */

    /**
     * 解法：用最大堆，
     */
    public static ArrayList<Integer> getLeastNumbers(int[] array, int k) {
        ArrayList<Integer> list = new ArrayList<>();

        if (array == null || array.length == 0 || k == 0 || k > array.length) {
            return list;
        }
        int[] data = Arrays.copyOfRange(array, 0, k);

        heapSort(data);

        //从k开始与根节点比较，若大于根节点，舍去，若小于，取代根节点，重排最大堆
        for (int i = k; i < array.length; i++) {
            if (array[i] < data[0]) {
                data[0] = array[i];
            }
            heapSort(data);
        }

        for (int j = data.length - 1; j >= 0; j--) {
            list.add(data[j]);
            System.out.println(data[j]);
        }

        return list;
    }

    //堆排序，构建大顶堆
    public static void heapSort(int[] array) {
        int len = array.length;
        for (int i = (len - 2) / 2; i >= 0; i--) {
            adjustHeap(array, i, len);
        }
        for (int j = len - 1; j >= 1; j--) {
            int temp = array[0];
            array[0] = array[j];
            array[j] = temp;
            adjustHeap(array, 0, j);
        }
    }

    public static void adjustHeap(int[] array, int k, int length) {
        int k1 = 2 * k + 1;
        if (k1 < length - 1 && array[k1] > array[k1 + 1]) {
            k1++;
        }
        if (k1 > length - 1 || array[k] <= array[k1]) {
            return;
        } else {
            int temp = array[k];
            array[k] = array[k1];
            array[k1] = temp;
            adjustHeap(array, k1, length);
        }
    }
}
