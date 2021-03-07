package 剑指offer;

import java.util.LinkedList;

public class LastRemaining44 {
    /*
    题45：0,1...n-1这n个数字排成一个圆圈，从数字0开始每次从这个圆圈里删除第m个数字．求这个圈圈里剩下的最后一个数字
    例如，0，1，2，3，4这5个数字组成一个圆圈，从数字0开始每次删除第三个数字，则删除的前4个数字依次是2，0，4，1，因此剩下的数字是3
     */

    /**
     * 使用链表，删除多，使用linkedlist
     * 排成一个圆圈，就是绕着链表循环，其实就是元素在列表中下标的移动
     * 移动后的下边就是原下标位置（index）+ 移动位数（从当前第三个数字，其实移动了m - 1位），转化为在链表中的位置
     * 其实就是除链表长度（lise.size()，是跟着删除改变的)取模，也就是绕链表移动后的位置
     */
     public static int lastRemaing(int n, int m) {
         if (n == 0 || m == 0) {
             return -1;
         }
         LinkedList<Integer> linkedList = new LinkedList<>();
         for (int i = 0; i < n; i++) {
             linkedList.add(i);
         }
         int index = 0;
         while (linkedList.size() > 1) {
             index = (index + (m - 1)) % linkedList.size();
             linkedList.remove(index);
         }
         return linkedList.get(0);
     }
}
