package 剑指offer;

import java.util.Stack;

public class StackWithMin20 {
    /*
    题21：包含min函数的栈
    定义栈的结构，请在该类型中实现一个能够得到栈的最小元素的min函数。
     */
    /**
     * 首先想到的是，把元素压入栈后，对栈中元素进行排序，但是排序后的数据结构已经不是栈了
     * 其次想到的是在栈里添加一个成员变量，用来保存最小元素，每次元素压入栈，与该成员变量对比，小于则更新，但是如果成员变量
     * 里保存的最小元素，栈里弹出后，这样是不可行的
     * 解法：用一个辅助栈，每次都把最小元素压入辅助栈，同步数据栈弹出，能保证辅助栈栈顶为最小元素
     */
    private static Stack<Integer> stack1 = new Stack<>();
    private static Stack<Integer> stack2 = new Stack<>();

    public static void push(int node) {
        stack1.push(node);
        if (stack2.empty()) {
            stack2.push(node);
        } else {
            if (stack2.peek() > node) {
                stack2.push(node);
            } else {
                stack2.push(stack2.peek());
            }
        }
    }

    public static void pop() throws Exception {
        if (stack1.isEmpty() || stack2.isEmpty()) {
           throw new Exception("栈为空");
        } else {
            stack1.pop();
            stack2.pop();
        }
    }

    public static int top() {
        return stack1.peek();
    }

    public static int min() {
        return stack2.peek();
    }
}
