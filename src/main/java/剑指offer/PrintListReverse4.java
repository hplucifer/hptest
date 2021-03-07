package 剑指offer;

import java.util.ArrayList;
import java.util.Stack;

public class PrintListReverse4 {
    /*
    题4：从尾到头打印链表
    输入一个链表，从尾到头到头打印链表的每个节点的值
     */

    /**
     * 解法1：通过栈，FILO
     * 传入的为头节点
     */
    public static ArrayList<Integer> printListReverse1(Common.ListNode headNode) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<Common.ListNode> stack = new Stack<>();
        while (headNode != null) {
            stack.push(headNode);
            headNode = headNode.next;
        }

        while (stack.isEmpty()) {
            list.add(stack.pop().val);
        }

        return list;
    }

    /**
     * 解法2：递归
     */
    public static ArrayList<Integer> printListReverse2(Common.ListNode headNode) {
        ArrayList<Integer> list = new ArrayList<>();

        if (headNode != null) {
            if (headNode.next != null) {
                list = printListReverse2(headNode.next);
            }
            list.add(headNode.val);
        }
        return list;
    }
}
