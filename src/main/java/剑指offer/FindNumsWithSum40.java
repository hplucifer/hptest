package 剑指offer;

import java.util.ArrayList;

public class FindNumsWithSum40 {
    /*
    题41：
   （一）和为某个值s的两个数字
    输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，输出一对即可
    输入数组{1,2,,4,7,15}和数字15，输出4和11。
   （二）和为某个值s的连续正数序列
    输入一个正数s，打印出所有和为s的连续正数序列（至少含有两个数）。例如输入15，由于1+2+3+4+5=4+5+6=7+8=15，所以打印出
    3个连续序列1～5，4～6，7～8
     */

    /**
     * （一）两个指针，分别指向数组头left和尾right的数字
     *  因为数组递增，如果两数和小于s，则left后移；如果两数和大于s，right前移
     *  解法：快排的思想
     */
    public static ArrayList<Integer> findNumsWithSum(int[] array, int s) {
        ArrayList<Integer> list = new ArrayList<>();
        if (array == null) {
            return list;
        }
        int left = 0;
        int right = array.length - 1;
        while (right > left) {
            if ((array[left] + array[right]) < s) {
                left++;
            } else if ((array[left] + array[right]) > s) {
                right--;
            } else {
                list.add(array[left]);
                list.add(array[right]);
                break;
            }
        }
        return list;
    }

    /**
     * （二）两个指针，一个small指向1，一个big指向给定数字2，移动两个指针，找出中间的连续序列
     *  注意，是找出连续正数组成的序列
     *  因为序列必须是两个数，所以s最多移动到（1+s）/2
     */
    public static ArrayList<ArrayList<Integer>> findContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
        if (sum < 3) {
            return arrayList;//序列必须包含两个数字
        }
        int small = 1;
        int big = 2;
        int middle = (sum + 1) / 2;//small指针最多移动到(sum + 1) / 2
        while (small < middle) {
            int curSum = 0;
            for (int i = small; i <=big; i++) {
                curSum += i;
            }
            if (curSum == sum) {
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = small; i <= big; i++) {
                    list.add(i);
                }
                arrayList.add(list);
                small++;
            } else if (curSum < sum) {
                big++;
            } else {
                small++;//连续正数相加过程，small++，其实就是减少了连续相加正数个数
            }
        }
        return arrayList;
    }
}
