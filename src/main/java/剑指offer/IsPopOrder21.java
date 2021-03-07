package 剑指offer;

import java.util.Stack;

public class IsPopOrder21 {
    /*
    题22：栈的压入、弹出序列
    输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出数据。假设压入栈的所有数字均不相等
    例如：序列1，2，3，4，5是某栈的压栈序列，序列4，5，3，2，1是该栈序列对应的一个弹出序列，但是4，3，5，2，1就不可能
    是该压栈序列的弹出序列
     */

    /**
     * 如果一个弹出的数字刚好是栈顶数字（例子中压入1，2，3，4，此时4在栈顶），那么直接弹出，如果下一个弹出的数字（5）不在栈顶，
     * 我们把压栈序列中还没有入栈的数字压入（把5压入，然后弹出）辅助栈，直到把下一个（下一个是3）需要弹出的数字压入栈顶为止。
     * （此时栈中是1，2，3）如果所有的数字都压入栈了仍然没有找到下一个弹出的数字，那么该序列就不可能
     *是一个弹出序列
     * 解法：借助辅助栈
     */
    public static boolean isPopOrder(int[] pushArray, int[] popArray) {
        boolean flag = false;
        if (pushArray != null || popArray != null) {
           return flag;
        }

        int point = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < pushArray.length; i++) {
            stack.push(pushArray[i]);//先将栈里的序列依次压入辅助栈
            //压入过程中判断和弹出序列元素的关系
            while (!stack.isEmpty() && stack.peek() == popArray[point]) {
                stack.pop();
                point++;
            }//循环结束时，如果是栈的弹出序列，则辅助栈肯定清空
        }
        return stack.isEmpty();//如果序列是弹出序列，那栈肯定会清空
    }
}
