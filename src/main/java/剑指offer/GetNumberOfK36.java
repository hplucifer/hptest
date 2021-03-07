package 剑指offer;

import java.util.Date;

public class GetNumberOfK36 {
    /*
    题38：数字在排序数组中出现的次数
    统计一个数字在排序数组中出现的次数。例如输入排序数组{1，2，3，3，3，3，4，5}和数字3，输出为4次
     */

    /**
     * 解法：采用二分查找法，找到第一个和最后一个k,即两次二分查找
     * 分情况，若二分法定位的中间数字，小于K（只在右边找）、大于K（只在左边找），等于k（看k位置前后数字）
     */
    public static int getNumberOfK(int[] array, int k) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int count = 0;
        int first = getFirstOfK(array, array.length, k, 0, array.length - 1);
        int last = getLastOfK(array, array.length, k, 0, array.length - 1);

        if (first > -1 && last > -1) {
            count = last - first + 1;
        }
        return count;
    }

    public static int getFirstOfK(int[] array, int length, int k, int start, int end) {
        if (start > end) {
            return -1;
        }

        int middleIndex = (start + end) / 2;
        int middleData = array[middleIndex];

        //用来确定第一个k的位置，如果k之前位置不等与k，则此位置为k第一次出现位置
        //第一个的边界是middleindex==0，if内的判断前半部分是括号起来的，不会有middleindex-1越界
        if (middleData == k) {
            if ((middleIndex > 0 && array[middleIndex - 1] != k) || middleIndex == 0) {
                return middleIndex;
            } else {
                end = middleIndex - 1;
            }
        } else if (middleData > k) {
            end = middleIndex - 1;
        } else {
            start = middleIndex + 1;
        }

        return getFirstOfK(array, length, k, start, end);
    }

    public static int getLastOfK(int[] array, int length, int k, int start, int end) {
        if (start > end) {
            return -1;
        }
        int middleIndex = (start + end) / 2;
        int middleData = array[middleIndex];

        //用来确定最后一个k的位置，如果k之后位置不等与k，则此位置为k最后一次出现位置
        //最后一个的边界是middleIndex == length - 1，if内的判断前半部分是括号起来的，不会有middleindex+1越界
        if (middleData == k) {
            if ((middleIndex < length - 1 && array[middleIndex + 1] != k) || middleIndex == length - 1) {
                return middleIndex;
            }else {
                start =  middleIndex + 1;
            }
        } else if (middleData < k) {
            start = middleIndex + 1;
        } else {
            end = middleIndex - 1;
        }

        return getLastOfK(array, length, k, start, end);
    }
}
